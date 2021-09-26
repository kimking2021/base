package priv.kimking.base.core.io.cs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/26
 */
public class Server {

    private static ExecutorService executorService = Executors.newCachedThreadPool();       //创建一个线程池

    private static class HandleMsg implements Runnable {         //一旦有新的客户端请求，创建这个线程进行处理
        private static final Logger log = LoggerFactory.getLogger(HandleMsg.class);

        Socket client;          //创建一个客户端

        public HandleMsg(Socket client) {        //构造传参绑定
            this.client = client;
        }

        @Override
        public void run() {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                String inputLine = null;
                long a = System.currentTimeMillis();
                while ((inputLine = bufferedReader.readLine())!=null){
                    log.info(inputLine);
                }
                long b = System.currentTimeMillis();
                System.out.println("此线程花费了："+(b-a)+"秒！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {         //服务端的主线程是用来循环监听客户端请求
        ServerSocket server = new ServerSocket(8686);       //创建一个服务端且端口为8686
        Socket client = null;
        while (true){           //循环监听
            client = server.accept();       //服务端监听到一个客户端请求
            System.out.println(client.getRemoteSocketAddress()+"地址的客户端连接成功!");
            executorService.submit(new HandleMsg(client));      //将该客户端请求通过线程池放入HandlMsg线程中进行处理
        }
    }

}
