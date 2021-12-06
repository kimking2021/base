package priv.kimking.base.designpattern.a2absfactory.service.factory;

import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author kim
 * @date 2021/12/1
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
