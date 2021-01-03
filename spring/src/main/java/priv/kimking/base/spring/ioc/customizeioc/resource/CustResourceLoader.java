package priv.kimking.base.spring.ioc.customizeioc.resource;

import java.net.URL;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/23
 */
public class CustResourceLoader {

    public CustResource getResource(String location) throws Exception {
        URL url = new URL(location);
        return new CustResourceUrl(url);
    }

}
