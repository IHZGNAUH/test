package com.HZ.MyLife.service;

import com.HZ.MyLife.entity.Category;

import java.util.List;

/**
 * Created by xsjdn on 2020/1/13.
 */
public interface CategoryService {
    //查询所有类型
    List<Category> findAll();
}
