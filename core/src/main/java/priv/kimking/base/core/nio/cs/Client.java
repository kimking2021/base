package priv.kimking.base.core.nio.cs;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/26
 */
public class Client {

    public static void main(String[] args) throws IOException {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

            ByteBuffer writeBuffer = ByteBuffer.allocate(32);
            ByteBuffer readBuffer = ByteBuffer.allocate(32);

            writeBuffer.put("hello".getBytes());
            writeBuffer.flip();

            // while (true) {
                writeBuffer.rewind();
                socketChannel.write(writeBuffer);
                readBuffer.clear();
                socketChannel.read(readBuffer);
                System.out.println("resp: " + new String(readBuffer.array()));
            // }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
