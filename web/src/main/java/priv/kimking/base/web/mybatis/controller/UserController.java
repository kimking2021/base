package priv.kimking.base.web.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.kimking.base.web.mybatis.entity.User;
import priv.kimking.base.web.mybatis.service.UserService;

import java.util.List;

/**
 * <p>
 *
 * @author kim
 * @date 2021/7/29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> listUser() {
        return userService.findAll();
    }
}
