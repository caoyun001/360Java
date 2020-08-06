package com.itheima_01;

import com.itheima.utils.DruidUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
JDBC 的事务操作
 */
public class TransactionDemo {

    /*
    1.获得连接
    2.开始事务
    3. 具体的sql操作(加钱, 减钱)
    4. 提交事务
    5.如果出现异常, 回滚事务
    6.释放资源
     */
    @Test
    public void test1() throws SQLException {


        Connection conn = null;
        try {
            // 1.获得连接
            conn = DruidUtils.getConnetion();
            //2.开始事务
            conn.setAutoCommit(false);
            //3. 具体的sql操作(加钱, 减钱)
            //减钱
            String sql = "update account set money=money-? where name=?";
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setDouble(1,1000);
            pstat.setString(2,"jack");
            pstat.executeUpdate();

            //模拟错误
            //int n = 1/0;

            //加钱
            sql = "update account set money=money+? where name=?";
            PreparedStatement pstat2 = conn.prepareStatement(sql);
            pstat2.setDouble(1,1000);
            pstat2.setString(2,"rose");
            pstat2.executeUpdate();
            // 4. 提交事务
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            //5.如果出现异常, 回滚事务
            conn.rollback();
        }
    }
}
