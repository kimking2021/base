package priv.kimking.base.spring.dbrouter.infrastructure.dao;

import kim.kimking.middleware.dbrouter.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;
import priv.kimking.base.spring.dbrouter.infrastructure.po.User;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/13
 */
@Mapper
public interface IUserDao {

    @DBRouter(key = "userId")
    User queryUserInfoByUserId(User req);

    @DBRouter(key = "userId")
    void insertUser(User req);


}
