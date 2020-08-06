package com.itheima.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  JDBC: Java连接数据库技术
 *  Java语言和数据库取得连接,对数据进行CRUD
 *  Sun公司提供JDBC开发API,类库 (类,接口...) java.sql包中
 *    可以开发任意关系数据库, 我们程序人员写代码不会改变!!
 *
 *  JDBC API中的核心类和接口
 *  1: 接口Driver 数据库的驱动程序,实现此接口
 *      MySQL驱动程序jar包,提供实现类
 *
 *  2: 接口Connection 数据库的连接对象
 *     MySQL驱动程序jar包,提供实现类
 *
 *  3: 接口Statement 数据库SQL语句的执行对象
 *
 *  4: 接口ResultSet  数据的查询结果集对象
 *
 *  5: 类DriverManager 数据库驱动程序的管理类
 *
 *  JDBC开发步骤 ,固定步骤 6个 (模版)
 *   1: 注册驱动
 *     告知JVM,使用的数据库驱动是谁
 *
 *   2: 获取数据库的连接对象
 *     获取接口 Connection实现类对象
 *
 *   3: 连接对象来获取SQL语句执行对象
 *     获取接口 Statement实现类对象
 *
 *   4: 执行SQL语句,获取结果集对象 (select)
 *     获取接口 ResultSet实现类对象
 *
 *   5: 处理结果集 (打印控制台)
 *
 *   6: 释放资源
 *
 */
public class JdbcDemo {
    public static void main(String[] args) throws SQLException{
        //1: 注册驱动, DriverManager
        //静态方法 static void registerDriver(Driver接口实现类 driver)
        DriverManager.registerDriver(new Driver());

        //2: 获取数据库的连接对象,DriverManager
        //静态方法 static Connection getConnection(String url, String user, String password)
        /**
         *  方法参数 url,连接到MySQL数据库的地址
         *  连接方式:数据库厂商名://数据库IP地址:端口号/数据库名
         */
        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/day18_2","root","root");

        //3: 连接对象来获取SQL语句执行对象
        //连接对象Connection的方法 Statement createStatement()获取SQL语句执行对象
        Statement stat =  con.createStatement();

        //4: 执行SQL语句,获取结果集对象 (insert)
        String sql = "insert into users values(null,'zhaoliu','123456','赵六')";
        //stat对象,方法 executeUpdate(String sql);执行SQL语句
        //方法返回int类型的数据,表示操作成功的行数
        int row = stat.executeUpdate(sql);
        System.out.println(row);

        //6: 释放资源
        stat.close();
        con.close();
    }
}










