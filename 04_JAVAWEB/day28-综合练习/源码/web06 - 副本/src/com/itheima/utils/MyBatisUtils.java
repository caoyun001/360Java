package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义MyBatis框架的工具类
 * 返回SqlSessionFactory对象
 * 读取主配置文件SqlMapConfig.xml
 */
public class MyBatisUtils {

    //定义静态成员
    private static SqlSessionFactory sqlSessionFactory;

    static {
        //读取配置文件
        try {
            InputStream inputStream =  Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //静态方法,返回SqlSessionFactory对象
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    /**
     * 提交事务,并释放资源
     */
    public static void commitAndClose(SqlSession sqlSession){
        sqlSession.commit();
        close(sqlSession);
    }

    /**
     * 定义方法,释放资源
     */
    public static void close(SqlSession sqlSession){
        sqlSession.close();
    }

}
