package com.HZ.MyLife.service.impl;

import com.HZ.MyLife.dao.BlogDao;
import com.HZ.MyLife.entity.Blog;
import com.HZ.MyLife.service.BlogService;
import com.HZ.MyLife.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by xsjdn on 2020/1/9.
 */
public class BlogServiceImpl implements BlogService {
    @Override
    public int countBlogByCid(String cid) {
        int i=0;
        SqlSession sqlSession=null;
        try {
            sqlSession=MybatisUtil.getSqlSessionFactory().openSession();
            BlogDao blogDao = sqlSession.getMapper(BlogDao.class);
            i= blogDao.countBlogByCid(cid);
        }catch (IOException e){
            e.printStackTrace();
        }
        sqlSession.close();
        return i;
    }

    @Override
    public int countBlogByUser(String name) {
        int i=0;
        SqlSession sqlSession=null;
        try {
            sqlSession=MybatisUtil.getSqlSessionFactory().openSession();
            BlogDao blogDao = sqlSession.getMapper(BlogDao.class);
            i= blogDao.countBlogByUser(name);
        }catch (IOException e){
            e.printStackTrace();
        }
        sqlSession.close();
        return i;
    }

    @Override
    public List<Blog> pageBlogByCid(String cid,int beginR,int pageSize) {
        List<Blog> blogs=null;
        SqlSession sqlSession=null;
        try {
            sqlSession= MybatisUtil.getSqlSessionFactory().openSession();
            BlogDao blogDao = sqlSession.getMapper(BlogDao.class);
            blogs = blogDao.pageFindBlog(cid, beginR, pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return blogs;
    }

    @Override
    public boolean writeBlog(Blog blog) {
        boolean b=false;
        SqlSession sqlSession=null;
        try{
            sqlSession=MybatisUtil.getSqlSessionFactory().openSession();
            BlogDao blogDao = sqlSession.getMapper(BlogDao.class);
            //用uuid自动生成博客id
            UUID uuid=UUID.randomUUID();
            //转换成string格式
            String bid=uuid.toString().replaceAll("-","");
            //设置id
            blog.setBlogId(bid);
            //获取当前时间
            Date date=new Date();
            //设置创建时间
            blog.setCreateTime(date);
            //添加博客
            blogDao.addBlog(blog);
            sqlSession.commit();
            b=true;
        }catch (IOException e){
            sqlSession.rollback();
            e.printStackTrace();
        }
        sqlSession.close();
        return b;
    }

    @Override
    public List<Blog> pageBlogByUser(String name,int beginRows,int pageSize) {
        List<Blog> blogs=null;
        SqlSession sqlSession=null;
        try {
            sqlSession=MybatisUtil.getSqlSessionFactory().openSession();
            BlogDao blogDao = sqlSession.getMapper(BlogDao.class);
            blogs = blogDao.pageBlogByUser(name, beginRows, pageSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        sqlSession.close();
        return blogs;
    }
}
