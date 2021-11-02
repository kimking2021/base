import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import priv.kimking.base.spring.redis.RedisSpringBootstrap;
import priv.kimking.base.spring.redis.service.IRedisService;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author kim
 * @date 2021/11/2
 */
@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = {RedisSpringBootstrap.class})
public class RedisTest {

    private static final Logger log = LoggerFactory.getLogger(RedisTest.class);

    @Resource
    private IRedisService redisService;

    @Test
    public void test_set() {
        redisService.set("key_info_user", "金木，一个并不简单的男人！");
    }

    @Test
    public void test_get() {
        String result = redisService.get("key_info_user");
        log.info("获取 Redis key：{} 信息：{}", "b_info_user", result);
    }

}
