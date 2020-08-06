package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *  C3p0连接池的使用
 *    开发人员来说: 从连接池中,拿连接使用
 *    肯定实现接口 DataSource
 *
 *  使用步骤:
 *    1: 导入jar包
 *    2: 连接数据库的4大信息为必须有
 *       配置文件中
 *       A: 文件名字 c3p0-config.xml
 *       B: 文件放在src下
 *
 *   3: 创建出DataSource接口实现类
 *     实现类方法Connection getConnection()  获取连接使用
 */
public class C3p0Utils {
    //3: 创建出DataSource接口实现类
    /**
     *  类C3p0Utils只要进入内存,加载静态成员
     *  创建接口DataSource的实现类对象new ComboPooledDataSource()
     *  实现类对象,会自动读取配置文件!!
     */
    private static DataSource dataSource = new ComboPooledDataSource();

    //提供方法,返回连接对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //定义方法,获取DataSource接口实现类
    public static DataSource getDataSource(){
        return dataSource;
    }
}













