import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import priv.kimking.base.spring.mybatis.ApiTestApplication;
import priv.kimking.base.spring.mybatis.infrastructure.dao.IUserDao;
import priv.kimking.base.spring.mybatis.infrastructure.po.User;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApiTestApplication.class})
public class ApiTest {

    private static final Logger log = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private IUserDao userDao;

    @Test
    public void test_queryUserInfoById() {
        User user = userDao.queryUserInfoById(1L);
        log.info("测试结果：{}", user);
    }

}
