package com.itheima.jdbc;

import com.itheima.utils.JdbcUtils;

import java.sql.Connection;

public class JdbcDemo05 {
    public static void main(String[] args) throws Exception {
        //调用静态方法,获取连接
       Connection con =  JdbcUtils.getConnection();
       System.out.println(con);

       //调用资源释放的方法
        JdbcUtils.close(null,null,con);
    }
}
