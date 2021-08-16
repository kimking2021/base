package priv.kimking.base.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import priv.kimking.base.web.provider.RedissonProvider;

/**
 * <p> 分布式锁
 *
 * @author kim
 * @date 2021/7/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedissonTest {

    @Autowired
    private RedissonProvider redissonProvider;

    /**
     * Redisson分布式锁测试
     */
    @Test
    public void testDistributeLockByRedis() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new DistributeLockThread(redissonProvider);
            thread.start();
        }
        Thread.sleep(10000000L);
    }
}
