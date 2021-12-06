package priv.kimking.base.designpattern.a2absfactory.service.impl;

import priv.kimking.base.designpattern.a2absfactory.matter.RedisUtils;
import priv.kimking.base.designpattern.a2absfactory.service.CacheService;

import java.util.concurrent.TimeUnit;

/**
 * @author kim
 * @date 2021/12/1
 */
public class CacheServiceImpl implements CacheService {

    private RedisUtils redisUtils = new RedisUtils();

    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.del(key);
    }

}
