package priv.kimking.base.web.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import priv.kimking.base.web.mybatis.entity.User;

import java.util.List;

/**
 * <p>
 *
 * @author kim
 * @date 2021/7/29
 */
@Mapper
public interface UserMapper {

    List<User> findAll();

}
