package com.itheima.test;

import com.itheima.utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 测试德鲁伊连接池
 */
public class TestDruid {
    public static void main(String[] args) throws SQLException {
        Connection connection = DruidUtils.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
