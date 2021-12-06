package priv.kimking.base.designpattern.a2absfactory.matter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author kim
 * @date 2021/12/1
 */
public class IIR {

    private static final Logger log = LoggerFactory.getLogger(IIR.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<String, String>();

    public String get(String key) {
        log.info("IIR获取数据 key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        log.info("IIR写入数据 key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        log.info("IIR写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void del(String key) {
        log.info("IIR删除数据 key：{}", key);
        dataMap.remove(key);
    }

}
