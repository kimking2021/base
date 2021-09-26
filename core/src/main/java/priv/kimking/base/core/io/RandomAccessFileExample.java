package priv.kimking.base.core.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/22
 */
public class RandomAccessFileExample {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("/path/to/file", "rw");

        file.seek(200);
    }
}
