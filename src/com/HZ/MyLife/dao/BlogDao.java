package com.HZ.MyLife.dao;

import com.HZ.MyLife.entity.Blog;

import java.util.List;

/**
 * Created by xsjdn on 2020/1/8.
 */
public interface BlogDao {
    //统计博客总数(类型)
    int countBlogByCid(String cid);
    //统计博客总数(用户)
    int countBlogByUser(String name);
    //按页获取博客
    List<Blog> pageFindBlog(String cid,int beginR,int pageSize);
    //按页(用户)获取博客
    List<Blog> pageBlogByUser(String cid,int beginR,int pageSize);
    //新增博客
    int addBlog(Blog blog);
}
