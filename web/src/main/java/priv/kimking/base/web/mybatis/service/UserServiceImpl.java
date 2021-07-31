package priv.kimking.base.web.mybatis.service;

import org.springframework.stereotype.Service;
import priv.kimking.base.web.mybatis.entity.User;
import priv.kimking.base.web.mybatis.mapper.UserMapper;

import java.util.List;

/**
 * <p>
 *
 * @author kim
 * @date 2021/7/29
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

}
