package priv.kimking.base.core.network;

import java.awt.im.InputContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/24
 */
public class SocketExample {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("host", 80);
        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());
        os.flush();
        os.close();
        socket.close();

        Socket socketS = new Socket("host", 80);
        InputStream is = socketS.getInputStream();
        int data = is.read();
        is.close();
        socketS.close();

        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socketClient = serverSocket.accept();
    }
}
