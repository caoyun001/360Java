package com.itheima_01;

import com.itheima.utils.DruidUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
DBUtils 的事务操作
 */
public class TransactionDemo2 {

    /*
    1.获得连接
    2.开始事务
    3.具体的sql操作(加钱, 减钱)
    4.提交事务 ,释放资源
    5.如果出现异常, 回滚事务释放资源
     */
    @Test
    public void test1() throws SQLException {
        Connection conn = null;
        try {
            //1.获得连接
            conn =  DruidUtils.getConnetion();
            // 2.开始事务
            conn.setAutoCommit(false);
            // 3.具体的sql操作(加钱, 减钱)
            QueryRunner qr = new QueryRunner();
            //减钱
            String sql = "update account set money=money-? where name=?";
            qr.update(conn, sql, 1000, "jack");
            //模拟错误
            int n =1/0;
            //加钱
            sql = "update account set money=money+? where name=?";
            qr.update(conn, sql, 1000, "rose");


            //4.提交事务 ,释放资源
            DbUtils.commitAndCloseQuietly(conn);
        } catch (Exception e) {
            e.printStackTrace();
            //5.如果出现异常, 回滚事务释放资源
            DbUtils.rollbackAndCloseQuietly(conn);
        }
    }
}
