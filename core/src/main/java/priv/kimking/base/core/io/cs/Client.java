package priv.kimking.base.core.io.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/26
 */
public class Client {

    // 如果客户端在连接建立之后，sleep再发送数据，服务端会占用资源，导致服务端并发处理浪费，因此有了NIO-Server
    public static void main(String[] args) throws IOException {
        Socket client = null;
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            client = new Socket();
            client.connect(new InetSocketAddress("localhost",8686));
            printWriter = new PrintWriter(client.getOutputStream(),true);
            printWriter.println("hello");
            printWriter.flush();

            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));            //读取服务器返回的信息并进行输出
            System.out.println("来自服务器的信息是："+bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            printWriter.close();
            bufferedReader.close();
            client.close();
        }
    }

}
