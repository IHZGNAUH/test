package com.HZ.MyLife.dao;

import com.HZ.MyLife.entity.Category;

import java.util.List;

/**
 * Created by xsjdn on 2020/1/13.
 */
public interface CategoryDao {
    //查询所有类型
    List<Category> findAll();
}
