package priv.kimking.base.designpattern.a2absfactory.service.factory.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.kimking.base.designpattern.a2absfactory.matter.IIR;
import priv.kimking.base.designpattern.a2absfactory.service.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * IIR 工厂
 *
 * @author kim
 * @date 2021/12/1
 */
public class IIRCacheAdapter implements ICacheAdapter {

    private static final Logger log = LoggerFactory.getLogger(IIRCacheAdapter.class);

    private IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }

}
