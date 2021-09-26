package priv.kimking.base.core.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * <p>
 *
 * Reference: http://tutorials.jenkov.com/java-io/inputstream.html
 *
 * @author kim
 * @date 2021/9/22
 */
public class IOStream {


    public static void main(String[] args) throws IOException {
        int bufferSize = 8 * 1024;
        // InputStream convert to InputStreamReader
        // file.encoding or default charset UTF-8
        InputStream is = new FileInputStream("/path/to/file");
        Reader reader = new InputStreamReader(is);


        // buffer
        InputStream isBuffer = new BufferedInputStream(new FileInputStream("/path/to/file"), bufferSize);
        isBuffer.mark(1024);
        isBuffer.reset();
        long skipBuffer = isBuffer.skip(20);


        OutputStream osBuffer = new BufferedOutputStream(new FileOutputStream("/path/to/file"), bufferSize);
        Writer writer = new OutputStreamWriter(osBuffer, Charset.defaultCharset());
        writer.flush();

        byte[] bytes = "Hello Bytes".getBytes();
        ByteArrayInputStream isBytes = new ByteArrayInputStream(bytes);
        int available = isBytes.available();
        isBytes.mark(1024);
        long skip = isBytes.skip(10);

    }
}
