package com.HZ.MyLife.service.impl;

import com.HZ.MyLife.dao.UserDao;
import com.HZ.MyLife.entity.User;
import com.HZ.MyLife.service.UserService;
import com.HZ.MyLife.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by xsjdn on 2019/12/25.
 */
public class UserServiceImpl implements UserService {
    /**
     * 注册新用户
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        //注册是否成功的标识
        boolean result=false;
        SqlSession sqlSession=null;
        try {
            //获取会话对象
            sqlSession=MybatisUtil.getSqlSessionFactory().openSession();
            UserDao userDao=sqlSession.getMapper(UserDao.class);
            //用uuid自动生成用户id
            UUID uuid1=UUID.randomUUID();
            UUID uuid2=UUID.randomUUID();
            //转换成string格式
            String uid1=uuid1.toString().replaceAll("-","");
            String uid2=uuid2.toString().replaceAll("-","");
            //设置的id等
            user.setUserId(uid1);
            user.setRoleId(0);
            user.setState(0);
            user.setCode(uid2);
            userDao.addUser(user);
            sqlSession.commit();
            result=true;
        } catch (IOException e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        sqlSession.close();
        return result;
    }

    /**
     * 通过名字查找用户
     * @param username
     * @return
     */
    @Override
    public User findUserByName(String username) {
        User user=null;
        SqlSession sqlSession=null;
        try {
            sqlSession=MybatisUtil.getSqlSessionFactory().openSession();
            UserDao userDao=sqlSession.getMapper(UserDao.class);
            user=userDao.findByName(username);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    @Override
    public boolean activeUser(String code) {
        boolean b=false;
        SqlSession sqlSession=null;
        try {
            sqlSession=MybatisUtil.getSqlSessionFactory().openSession();
            UserDao userDao=sqlSession.getMapper(UserDao.class);
            userDao.updateState(code);
            sqlSession.commit();
            b=true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 用户登录
     * @param name
     * @param pass
     * @return
     */
    @Override
    public User loginByAccount(String name, String pass) {
        User user=null;
        SqlSession sqlSession=null;
        try {
            sqlSession=MybatisUtil.getSqlSessionFactory().openSession();
            UserDao userDao=sqlSession.getMapper(UserDao.class);
            User byName = userDao.findByName(name);
            if (null!=byName){
                String password = byName.getPassword();
                if (pass.equals(password)){
                    user=byName;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
