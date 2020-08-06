package com.itheima.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * 实现数据的查询
 *
 *  1: 注册驱动
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
public class JdbcDemo02 {
    public static void main(String[] args)throws Exception {
        // 1: 注册驱动
        //分析: MySQL驱动的源代码,重复注册
        //不要重复注册驱动
        //思想: Driver加入到内存方法区即可: 反射
        Class.forName("com.mysql.jdbc.Driver");

        // 2: 获取数据库的连接对象
       Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/day18_2","root","root");

       // 3: 连接对象来获取SQL语句执行对象
       Statement stat = con.createStatement();

       //拼写查询的SQL
        String sql = "select * from users";

        // 4: 执行SQL语句,获取结果集对象 (select)
        //stat对象的方法executeQuery(String sql)执行Select语句
        //返回值是ResultSet接口对象
       ResultSet rs =  stat.executeQuery(sql);

       // 5: 处理结果集 (打印控制台)
        //rs结果集对象方法 boolean next() 有数据,返回true
        while ( rs.next() ){
           //rs结果集对象方法 getXXX("列名")  XXX->数据类型
            System.out.println(rs.getInt("uid")+"  "+rs.getString("username")+"  "+rs.getString("password")+"  "+rs.getString("nickname"));
        }
        rs.close();
        stat.close();
        con.close();
    }
}
