package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *  SQL语句执行对象
 *  Statement接口,有一个子接口
 *   java.sql.PreparedStatement接口
 *   特点: 可以将SQL 语句存储在对象中,多次反复高效执行
 *
 *   获取接口对象Statement,使用的方法是连接对象 con.createStatement()
 *   获取子接口PreparedStatement对象,使用的方法是连接对象  con.prepareStatement(String sql)
 */
public class JdbcDemo04 {
    public static void main(String[] args) throws Exception{
        //1:注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2:获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day18_2","root","root");
        //使用连接对象con的方法 prepareStatement()获取子接口PreparedStatement对象
        //拼写修改数据的SQL,凡是参数部分不要直接写出,使用问号占位符
        String sql = "update users set username = ?,password = ?,nickname = ? where uid = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        //指定?的实际参数了,使用pst对象的方法 setXXX,setObject(int 参数, Object obj)
        //int参数,第几个问号,  obj参数,问号的实际数据
        pst.setObject(1,"zhaoliu2");
        pst.setObject(2,"654321");
        pst.setObject(3,"赵六2");
        pst.setObject(4,4);

        //执行SQL语句
        int row =  pst.executeUpdate();
        System.out.println(row);

        pst.close();
        con.close();
    }
}
