package priv.kimking.base.designpattern.a2absfactory.service.factory.impl;

import priv.kimking.base.designpattern.a2absfactory.matter.EGM;
import priv.kimking.base.designpattern.a2absfactory.service.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * EGM 工厂
 *
 * @author kim
 * @date 2021/12/1
 */
public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }

}
