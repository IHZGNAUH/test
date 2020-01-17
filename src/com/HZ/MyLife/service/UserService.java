package com.HZ.MyLife.service;

import com.HZ.MyLife.entity.User;

/**
 * Created by xsjdn on 2019/12/25.
 */
public interface UserService {
    //注册新用户
    boolean register(User user);
    //通过名字查找用户
    User findUserByName(String username);
    //激活用户
    boolean activeUser(String code);
    //用户登录 账号
    User loginByAccount(String name,String pass);
}
