package cn.mrcode.cache.eshop.userserver.mappter;


import org.apache.ibatis.annotations.Select;

import java.util.List;

import cn.mrcode.cache.eshop.userserver.model.User;

/**
 * ${todo}
 *
 * @author : zhuqiang
 * @date : 2019/4/1 22:04
 */
public interface UserMapper {
    List<User> findUserInfo();

    @Select("select * from user;")
    List<User> selectAll();
}
