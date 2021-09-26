package priv.kimking.base.core.io.pipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * <p>
 *
 * Pipes in Java IO provides the ability for two threads running in the same JVM to communicate.
 *
 * You cannot use a pipe to communicate with a thread in a different JVM (different process).
 * The pipe concept in Java is different from the pipe concept in Unix / Linux,
 * where two processes running in different address spaces can communicate via a pipe.
 *
 *
 * @author kim
 * @date 2021/9/22
 */
public class PipeExample {

    private static final Logger log = LoggerFactory.getLogger(PipeExample.class);

    public static void main(String[] args) throws IOException {
        final PipedOutputStream outputStream = new PipedOutputStream();
        final PipedInputStream inputStream = new PipedInputStream(outputStream);

        // inputStream.connect(outputStream);
        // outputStream.connect(inputStream);

        Thread threadOutput = new Thread(() -> {
            try {
                outputStream.write("Hello pipe".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread threadInput = new Thread(new Runnable() {
            @Override
            public void run() {
                int data = 0;
                try {
                    data = inputStream.read();
                    while (data != -1) {
                        System.out.print((char) data);
                        data = inputStream.read();
                    }
                } catch (IOException e) {
                }
            }
        });

        threadOutput.start();
        threadInput.start();
    }
}
