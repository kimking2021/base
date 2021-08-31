package priv.kimking.base.spring.hystrix.interfaces;

import kim.kimking.middleware.hystrix.annotation.DoHystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import priv.kimking.base.spring.whitelist.interfaces.UserInfo;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/30
 */
@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * 测试：http://localhost:8088/api/queryUserInfo?userId=aaa
     */
    @DoHystrix(timeoutValue = 350, returnJson = "{\"code\":\"1111\",\"info\":\"调用方法超过350毫秒，熔断返回！\"}")
    @RequestMapping(path = "/api/queryUserInfo", method = RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId) throws InterruptedException {
        log.info("查询用户信息，userId：{}", userId);
        Thread.sleep(1000);
        return new UserInfo("虫虫:" + userId, 19, "天津市东丽区万科赏溪苑14-0000");
    }



}
