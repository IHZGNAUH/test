package com.HZ.MyLife.service;

import com.HZ.MyLife.entity.Blog;

import java.util.List;

/**
 * Created by xsjdn on 2020/1/9.
 */
public interface BlogService {
    /**
     * 统计博客总量(类型)
     * @return
     */
    int countBlogByCid(String cid);

    /**
     * 统计博客总量(用户)
     * @return
     */
    int countBlogByUser(String name);

    /**
     * 按页获取博客
     * @param cid
     * @param beginRow
     * @param pageSize
     * @return
     */
    List<Blog> pageBlogByCid(String cid,int beginRow,int pageSize);

    /**
     * 按页(用户)获取博客
     * @param name
     * @return
     */
    List<Blog> pageBlogByUser(String name,int beginRow,int pageSize);
    /**
     * 写新的博客
     * @param blog
     * @return
     */
    boolean writeBlog(Blog blog);
}
