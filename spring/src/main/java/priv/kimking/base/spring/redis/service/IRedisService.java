package priv.kimking.base.spring.redis.service;

import kim.kimking.middleware.redis.annotation.RedisMapper;

/**
 * <p>
 *
 * @author kim
 * @date 2021/11/2
 */
@RedisMapper
public interface IRedisService {

    String get(String key);

    void set(String key, String val);

}
