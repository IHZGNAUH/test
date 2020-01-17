package com.HZ.MyLife.dao;

import com.HZ.MyLife.entity.User;

/**
 * Created by xsjdn on 2019/12/23.
 */
public interface UserDao {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByName(String username);

    /**
     * 新增用户
     * @param user
     * @return 影响行数
     */
    int addUser(User user);

    /**
     * 修改用户状态和清空激活码
     * @param code
     * @return 影响行数
     */
    int updateState(String code);



}
