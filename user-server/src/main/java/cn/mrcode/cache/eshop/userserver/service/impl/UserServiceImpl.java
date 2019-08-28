package cn.mrcode.cache.eshop.userserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.mrcode.cache.eshop.userserver.mappter.UserMapper;
import cn.mrcode.cache.eshop.userserver.model.User;
import cn.mrcode.cache.eshop.userserver.service.UserService;

/**
 * ${todo}
 *
 * @author : zhuqiang
 * @date : 2019/4/1 22:11
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserInfo() {
        return userMapper.selectAll();
    }
}
