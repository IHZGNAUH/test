package com.HZ.MyLife.servlet;

import com.HZ.MyLife.entity.User;
import com.HZ.MyLife.service.impl.UserServiceImpl;
import com.HZ.MyLife.utils.MailUtil;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xsjdn on 2019/12/25.
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    //1.检查用户名
    public String checkUsername(HttpServletRequest request,HttpServletResponse response){
        //获取用户输入的用户名
        String username= request.getParameter("name");
        //向jsp返回数据的方式
        PrintWriter wr=null;
        try {
            wr= response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s;
        //根据用户名查找用户，判断用户是否已经存在
        UserServiceImpl us = new UserServiceImpl();
        User uf=us.findUserByName(username);
        if(uf!=null){
            s="{\"valid\":false}";
        }else{
            s="{\"valid\":true}";
        }
        wr.write(s);
        wr.flush();
        wr.close();
        return null;
    }
    //2.用户注册
    public String registerByMail(HttpServletRequest req,HttpServletResponse rep){
        //接收所有参数
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        try {
            //这个方法会遍历map<key, value>中的key，
            // 如果bean中有这个属性，就把这个key对应的value值赋给bean的属性
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserServiceImpl userService = new UserServiceImpl();
        Boolean b=userService.register(user);
        if (b){
            System.out.println("恭喜注册成功");
            //发送邮件，等待激活
            MailUtil.sendMail(user.getEmail(),user.getCode());
            return "login.jsp";
        }else{
            System.out.println("注册失败");
            return "redirect:register.jsp";
        }
    }
    //3.用户激活
    public String activeUser(HttpServletRequest request,HttpServletResponse response){
        String code = request.getParameter("code");
        UserServiceImpl userService = new UserServiceImpl();
        boolean b = userService.activeUser(code);
        if (b){
            System.out.println("激活成功");
        }else {
            System.out.println("激活失败");
        }
        return "login.jsp";
    }
    //4.用户登录
    public String loginByAccount(HttpServletRequest request,HttpServletResponse response){
        UserServiceImpl userService = new UserServiceImpl();
        String username=request.getParameter("name");
        String password = request.getParameter("pass");
        //先核对验证码
        String code =(String) request.getSession().getAttribute("code");
        String verify = request.getParameter("verify");
        if (code.equals(verify)) {
            //判断用户名和密码是否匹配
            User user = userService.loginByAccount(username, password);
            if (null!=user){
                //判断是否激活
                int state = user.getState();
                if (state==1){
                    //用户已激活
                    System.out.println("登录成功");
                    HttpSession session=request.getSession();
                    session.setAttribute("user",user);
                    return "home.jsp";
                }else {
                    //用户未激活
                    System.out.println("登录失败");
                    return "redirect:login.jsp";
                }
            }else {
                System.out.println("用户不存在");
                return  "login.jsp";
            }
        }else {
            request.setAttribute("error","验证码错误");
            return "login.jsp";
        }
    }
}
