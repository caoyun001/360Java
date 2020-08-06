package com.itheima.study.mvc.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;

/**
 * 获取SqlSession工具类
 */
public class SqlSessionUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "/mybatis-config.xml";
            InputStream inputStream = SqlSessionUtils.class.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
