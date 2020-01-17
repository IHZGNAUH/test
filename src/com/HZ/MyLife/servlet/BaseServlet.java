package com.HZ.MyLife.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xsjdn on 2019/3/19.
 */
public class BaseServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码方式
        req.setCharacterEncoding("utf-8");
        //获取参数method值
        String method = req.getParameter("method");
        //通过反射获得当前类
        Class<? extends BaseServlet> aClass = this.getClass();
        if(method!=null){
            try {
                System.out.println("寻找"+method);
                //同样通过反射获得当前类的相应方法
                Method m = aClass.getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
                //‘o’是方法的返回值
                Object o = m.invoke(this,req,resp);
                if(o!=null){
                    String s = o.toString();
                    if(s.contains("redirect:")){
                        //分割出后一部分
                        s = s.split(":")[1];
                        resp.sendRedirect(s);
                    }else{
                        req.getRequestDispatcher(s).forward(req,resp);
                        System.out.println("Base的转发");
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            resp.getWriter().write("你有问题");
        }
    }
}
