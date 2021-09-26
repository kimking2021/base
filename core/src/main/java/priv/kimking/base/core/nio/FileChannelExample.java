package priv.kimking.base.core.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/24
 */
public class FileChannelExample {

    private static final Logger log = LoggerFactory.getLogger(FileChannelExample.class);

    static void baseUsage() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(48);
        int byteRead = channel.read(buffer);
        // buffer.put(Byte.parseByte("a"));
        while (byteRead != -1) {
            log.info("Read " + byteRead);
            // switch the buffer from writing mode into reading mode
            buffer.flip();

            // rewind: sets the position back to 0, so you can reread all the data in the buffer
            // buffer.rewind();

            // compact: copies all unread data to the beginning of the Buffer. Then it sets position to right after the last unread element.
            // The limit property is still set to capacity, just like clear() does
            // buffer.compact();

            // buffer.mark();

            // buffer.reset();

            while (buffer.hasRemaining()) {
                log.info(String.valueOf((char) buffer.get()));
            }
            // make it ready for writing again
            buffer.clear();
            // buffer.compact();
            byteRead = channel.read(buffer);
        }
        aFile.close();
    }

    static void scatterAndGather() {
        ByteBuffer bufHeader = ByteBuffer.allocate(128);
        ByteBuffer bufBody = ByteBuffer.allocate(1024);

        ByteBuffer[] buf = {bufHeader, bufBody};
        // channel.read(buf);
        // channel.write(buf);
    }

    public static void main(String[] args) throws IOException {

    }
}
