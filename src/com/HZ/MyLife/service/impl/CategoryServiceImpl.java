package com.HZ.MyLife.service.impl;

import com.HZ.MyLife.dao.CategoryDao;
import com.HZ.MyLife.entity.Category;
import com.HZ.MyLife.service.CategoryService;
import com.HZ.MyLife.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * Created by xsjdn on 2020/1/13.
 */
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        SqlSession sqlSession=null;
        List<Category> categories=null;
        try {
            sqlSession= MybatisUtil.getSqlSessionFactory().openSession();
            CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
            categories= categoryDao.findAll();
        }catch (IOException e){
            e.printStackTrace();
        }
        sqlSession.close();
        return categories;
    }
}
