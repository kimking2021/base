package priv.kimking.base.core.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/24
 */
public class SocketChannelExample {
    
    static void serverSocketChannel() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress("host",80));
        channel.configureBlocking(false);
        while (true) {
            SocketChannel channelClient = channel.accept();
            //  In non-blocking mode the accept() method returns immediately, and may thus return null
            if (channelClient != null) {

            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();

        // You can set a SocketChannel into non-blocking mode.
        // When you do so, you can call connect(), read() and write() in asynchronous mode.
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("host", 80));

        // In non-blocking mode the write() method may return without having written anything. Therefore you need to call the write() method in a loop.
        // In non-blocking mode the read() method may return without having read any data at all. Therefore you need to pay attention to the returned int, which tells how many bytes were read.
        while (!channel.finishConnect()) {

            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.clear();
            buf.put("hello".getBytes());
            buf.flip();
            channel.write(buf);
            // channel.read(buf);

        }


    }
}
