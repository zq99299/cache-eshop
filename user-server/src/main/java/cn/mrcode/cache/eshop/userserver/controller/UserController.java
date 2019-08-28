package cn.mrcode.cache.eshop.userserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import cn.mrcode.cache.eshop.userserver.model.User;
import cn.mrcode.cache.eshop.userserver.service.UserService;


/**
 * ${todo}
 *
 * @author : zhuqiang
 * @date : 2019/4/1 22:11
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getUserInfo() {
        List<User> user = userService.getUserInfo();
        return user;
    }
}
