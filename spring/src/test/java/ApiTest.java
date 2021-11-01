import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import priv.kimking.base.spring.dbrouter.DBRouterTestApplication;
import priv.kimking.base.spring.dbrouter.infrastructure.dao.IUserDao;
import priv.kimking.base.spring.dbrouter.infrastructure.po.User;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DBRouterTestApplication.class})
public class ApiTest {

    private static final Logger log = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private IUserDao userDao;

    @Test
    public void test_insertUser() {
        User user = new User();
        user.setUserId("980765512");
        user.setUserNickName("金木");
        user.setUserHead("01_50");
        user.setUserPassword("123456");
        userDao.insertUser(user);
    }

    @Test
    public void test_queryUserInfoByUserId() {
        User user = userDao.queryUserInfoByUserId(new User("980765512"));
        log.info("测试结果：{}", user);
    }


}
