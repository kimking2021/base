package priv.kimking.base.web.mybatis.service;

import priv.kimking.base.web.mybatis.entity.User;

import java.util.List;

/**
 * <p>
 *
 * @author kim
 * @date 2021/7/29
 */
public interface UserService {

    List<User> findAll();

}
