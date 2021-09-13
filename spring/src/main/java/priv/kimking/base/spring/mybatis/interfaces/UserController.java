package priv.kimking.base.spring.mybatis.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import priv.kimking.base.spring.mybatis.infrastructure.dao.IUserDao;
import priv.kimking.base.spring.mybatis.infrastructure.po.User;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/13
 */
@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    private IUserDao userDao;

    @RequestMapping(path = "/api/queryUserInfoById", method = RequestMethod.GET)
    public User queryUserInfoById(){
        return userDao.queryUserInfoById(1L);
    }

}
