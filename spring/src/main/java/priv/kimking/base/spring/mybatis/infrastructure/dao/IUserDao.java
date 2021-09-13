package priv.kimking.base.spring.mybatis.infrastructure.dao;

import priv.kimking.base.spring.mybatis.infrastructure.po.User;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/13
 */
public interface IUserDao {

    User queryUserInfoById(Long id);

}
