package com.HZ.MyLife.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**获取唯一（单例）sqlsessionFactory会话工厂
 * Created by xsjdn on 2019/12/28.
 */
public class MybatisUtil {
    //③私有并静态化变量
    private static SqlSessionFactory factory;

    //①私有构造函数
    private MybatisUtil() {
    }
    //②提供公有获取方法
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        //读取配置文件
        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");
        //保证单一，在非空时第一次构造
        if (null==factory){
            factory=new SqlSessionFactoryBuilder().build(in);
        }
        return factory;
    }
}
