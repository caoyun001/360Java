package com.itheima.mybatis;

import com.itheima.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * MyBatis框架的快速入门
 * SQL语句，连接信息，写在配置文件
 * SqlMapConfig.xml 配置的是连接信息
 * UserMapper.xml 配置的是数据表user的SQL语句
 */
public class QuickStart {

    @Test
    /**
     * 需求： 查询user表，数据存储到List集合
     * 实现步骤：
     *   1：创建对象 SqlSessionFactoryBuilder
     *     工厂的构建者对象，作用创建SQLSession对象工厂的
     *     读取配置文件
     *
     *   2： SqlSessionFactory工厂创建
     *      SqlSession接口实现类对象
     *
     *   3：  SqlSession接口实现类对象
     *     调用方法 select 查询数据表
     *
     *   4： 输出查询结果集
     *
     *   5： 释放资源
     */
    public void myBatisQuickStart(){
        //1：创建对象 SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //使用sqlSessionFactoryBuilder方法 build(),创建出SqlSessionFactory对象
        //build方法，读取配置文件，返回SqlSessionFactory对象，需要传递流对象，流对象绑定数据库配置文件
        InputStream inputStream =  QuickStart.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        // 2： SqlSessionFactory工厂创建
        SqlSessionFactory sqlSessionFactory =  sqlSessionFactoryBuilder.build(inputStream);
        //工厂对象，获取SqlSession接口实现类对象，工厂对象的方法 openSession
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        //3：  SqlSession接口实现类对象,调用方法 select 查询数据表
        //selectList方法参数不是SQL语句， namespace+"."+id 锁定SQL语句  test.queryList
        List<User> userList = sqlSession.selectList("test.queryList");
        for(User user :userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
}
