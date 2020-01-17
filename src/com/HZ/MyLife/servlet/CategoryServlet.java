package com.HZ.MyLife.servlet;

import com.HZ.MyLife.entity.Category;
import com.HZ.MyLife.service.impl.CategoryServiceImpl;
import com.HZ.MyLife.utils.CacheUtil;
import com.alibaba.fastjson.JSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by xsjdn on 2020/1/13.
 */
@WebServlet("/categoryServlet")
public class CategoryServlet extends BaseServlet {
    //查询所有类型
    public String findAll(HttpServletRequest request, HttpServletResponse response){
        CategoryServiceImpl cs;
        List<Category> all;
        Object categories = CacheUtil.get("categories");
        if (null==categories){
            cs = new CategoryServiceImpl();
            all = cs.findAll();
            CacheUtil.put("categories",all);
        }else {
            all=(List<Category>)CacheUtil.get("categories");
        }
        response.setContentType("text/json;charset=utf-8");
        PrintWriter wr = null;
        try {
            wr=response.getWriter();
        }catch (IOException e){
            e.printStackTrace();
        }
        String s = JSON.toJSONString(all);
        wr.write(s);
        wr.flush();
        wr.close();
        return null;
    }
}
