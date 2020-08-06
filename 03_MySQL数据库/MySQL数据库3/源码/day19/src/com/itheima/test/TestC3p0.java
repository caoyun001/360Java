package com.itheima.test;

import com.itheima.utils.C3p0Utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestC3p0 {
    public static void main(String[] args) throws SQLException {
        //测试c3p0连接池,获取连接
        //工具类静态方法获取连接
        Connection con =  C3p0Utils.getConnection();
        System.out.println(con);

        //释放资源
        //注意: close()在连接池中,没有销毁此连接,连接放回连接池
        con.close();
    }
}
