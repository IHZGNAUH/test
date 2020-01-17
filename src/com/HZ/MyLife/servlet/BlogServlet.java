package com.HZ.MyLife.servlet;

import com.HZ.MyLife.entity.Blog;
import com.HZ.MyLife.entity.PageBean;
import com.HZ.MyLife.entity.User;
import com.HZ.MyLife.service.impl.BlogServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by xsjdn on 2020/1/9.
 */
@WebServlet("/blogServlet")
public class BlogServlet extends BaseServlet {

    //按页(类型)查询博客
    public String pageBlogByCid(HttpServletRequest request, HttpServletResponse response){
        String cid = request.getParameter("cid");
        if (null==cid){
            cid="1";
        }
        String currPage = request.getParameter("currPage");
        //判断是否已经设置过page属性
        HttpSession session=request.getSession();
        PageBean page=(PageBean)session.getAttribute("page");
        if (null==page){
            System.out.println("新建page");
            page=new PageBean();
            page.setCurrentPage(1);
        }else {
            if (currPage!=null){
                page.setCurrentPage(Integer.parseInt(currPage));
            }else {
                page.setCurrentPage(1);
            }
        }
        BlogServiceImpl bs = new BlogServiceImpl();
        //每页数量
        page.setPageSize(10);
        //该类博客总数
        Integer i = bs.countBlogByCid(cid);
        page.setTotalCounts(i);
        //总页数
        page.setTotalPage();
        //当前页开始行
        page.setBeginRows();
        //当前页展示博客
        System.out.println("当前页"+page.getCurrentPage()+"开始行"+page.getBeginRows());
        List<Blog> blogs = bs.pageBlogByCid(cid, page.getBeginRows(), page.getPageSize());
        for (Blog b:
             blogs) {
            System.out.println(b.getBlogName()+b.getBlogContent());
        }
        page.setList(blogs);
        //存进session
        session.setAttribute("page",page);
        return "blog/home.jsp";
    }

    //写博客
    public String writeBlog(HttpServletRequest request,HttpServletResponse response){
        Map<String, String[]> pm = request.getParameterMap();
        Blog blog = new Blog();
        String s=null;
        try {
            BeanUtils.populate(blog,pm);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        blog.setPostUser(user.getUsername());
        BlogServiceImpl blogService = new BlogServiceImpl();
        boolean b = blogService.writeBlog(blog);
        if (b){
            System.out.println("写博成功");
            s = pageBlogByUser(request, response);
        }else {
            System.out.println("写博失败");
        }
        return s;
    }

    //按页(用户)查询博客
    public String pageBlogByUser(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        //获取当前登录用户名
        User user = (User) session.getAttribute("user");
        String name=null;
        if (null!=user){
            name=user.getUsername();
        }else {
            return "login.jsp";
        }
        String currPage = request.getParameter("currPage");
        //判断是否已经设置过page属性
        PageBean page=(PageBean)session.getAttribute("Page");
        if (null==page){
            System.out.println("也是新建page");
            page=new PageBean();
            page.setCurrentPage(1);
        }else {
            if (currPage!=null){
                page.setCurrentPage(Integer.parseInt(currPage));
            }else {
                page.setCurrentPage(1);
            }
        }
        BlogServiceImpl blogService = new BlogServiceImpl();
        //每页数量
        page.setPageSize(10);
        //该类博客总数
        Integer i = blogService.countBlogByUser(name);
        page.setTotalCounts(i);
        //总页数
        page.setTotalPage();
        //当前页开始行
        page.setBeginRows();
        //当前页展示博客
        List<Blog> blogs = blogService.pageBlogByUser(user.getUsername(),page.getBeginRows(),page.getPageSize());
        page.setList(blogs);
        //存进session
        session.setAttribute("page",page);
        return "blog/home.jsp";
    }
}
