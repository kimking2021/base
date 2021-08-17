package priv.kimking.base.web.provider;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p> 分布式锁： Redisson 实现的分布式锁
 * 参考： https://mp.weixin.qq.com/s/1hlWzVpfoiRUhA9itDFeqw
 * 1. 加锁设置自动过期时间，避免因服务器宕机出现死锁
 * 2. 后台线程监听锁持有状态定时轮询延长过期时间，避免因业务耗时长而锁自动释放
 *
 * @author kim
 * @date 2021/7/19
 */
@Service
public class RedissonProvider {
    
    private static final Logger log = LoggerFactory.getLogger(RedissonProvider.class);

    private final RedissonClient redissonClient;

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedissonProvider(RedissonClient redissonClient, StringRedisTemplate stringRedisTemplate) {
        this.redissonClient = redissonClient;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void demoDistributeLockByRedis(String lockKey) throws InterruptedException {

        RLock redissonLock = redissonClient.getLock(lockKey);
        try {
            // 加锁，定时轮询给未完成业务而未释放的锁延长过期时间
            redissonLock.lock();
            Thread curtThread = Thread.currentThread();
            log.info("获取到锁：{}, {}", curtThread.getId(), curtThread.getName());

            Thread.sleep(500000L);
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                log.info("扣除库存，剩余库存：{}", realStock);
            } else {
                log.info("库存不足");
            }
        } finally {
            log.info("释放锁：{}", Thread.currentThread().getName());
            redissonLock.unlock();
        }

    }

}
