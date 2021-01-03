package priv.kimking.base.spring.ioc.customizeioc.resource;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/23
 */
public class CustResourceUrl implements CustResource {

    private final URL url;

    public CustResourceUrl(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws Exception {
        URLConnection connection = url.openConnection();
        connection.connect();
        return connection.getInputStream();
    }
}
