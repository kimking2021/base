package priv.kimking.base.netty.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>
 *
 * @author kim
 * @date 2020/9/27
 */
public class SocketServer {

    public void start(int port) {
        //1.创建 ServerSocket 对象并且绑定一个端口
        try (ServerSocket server = new ServerSocket(port)) {
            //2.通过 accept()方法监听客户端请求， 这个方法会一直阻塞到有一个连接建立
            for (;;) {
                final Socket socket = server.accept();
                System.out.println("client connected");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
                            //3.通过输入流读取客户端发送的请求信息
                            Message message = (Message) objectInputStream.readObject();
                            System.out.println("server receive message:" + message.getContent());
                            message.setContent("new content");
                            //4.通过输出流向客户端发送响应信息
                            objectOutputStream.writeObject(message);
                            objectOutputStream.flush();
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("occur exception:" + e);
                        }
                    }
                });
            }
        } catch (IOException e) {
            System.out.println("occur IOException:" + e);
        }
    }

    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();
        socketServer.start(6666);
    }

}
