package com.itheima.jdbc;

import com.itheima.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *  原始的JDBC，对数据表user查询，结果集存储List集合
 *
 *  原始程序的问题： 维护性差，扩展性差，出现问题，修改源码
 *    代码量大
 *    频繁连接，释放数据库资源，降低系统性能
 *       解决办法： 连接池
 *
 *    数据库驱动类 ，连接四大信息
 *       解决办法： 写配置文件，读取
 *
 *    SQL语句硬编码，SQL语句写死了
 *    SQL语句中的？占位符
 *      解决办法：写配置文件，读取
 *
 *    封装数据表结果集代码，硬编码
 *
 *    引出连接池，Apache DBUtils
 *
 *    框架： 最基本的代码，整合起来
 *    连接数据库，执行SQL语句，封装结果集整合
 *    只要提供: SQL语句,写xml中
 */
public class JdbcDemo {
    public static void main(String[] args) throws Exception{
        //注册驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        Connection con =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis","root","root");
        //SQL语句执行对象
        PreparedStatement pst = con.prepareStatement("select * from user ");
        //执行查询，返回结果集
        ResultSet rs =  pst.executeQuery();
        List<User> userList = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            //取出表中的数据， rs对象的方法getXXX()
            user.setId( rs.getInt("id") );
            user.setUsername( rs.getString("username"));
            user.setSex(rs.getString("sex"));
            user.setBirthday( rs.getDate("birthday") );
            user.setAddress( rs.getString("address"));
            userList.add(user);
        }
        for(User user : userList){
            System.out.println(user);
        }

        rs.close();
        pst.close();
        con.close();
    }
}
