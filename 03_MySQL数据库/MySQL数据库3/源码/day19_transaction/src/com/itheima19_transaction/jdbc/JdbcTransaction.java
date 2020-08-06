package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  JDBC实现转账,保证数据安全
 *  使用事务技术
 *  需求: tom -1000   , jerry+1000
 *
 *  Connection连接对象方法:
 *    void setAutoCommit(false)设置事务的提交方式,传false阻止自动提交
 *
 *    commit() 提交事务
 *
 *    rollback() 回滚
 */
public class JdbcTransaction {
    public static void main(String[] args)  {
        Connection con = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day19", "root", "root");

            //阻止事务自动提交,开启事务
            con.setAutoCommit(false);

            //获取SQL语句执行对象
            Statement stat = con.createStatement();
            //拼写tom-1000的SQL语句
            String sqlOut = "update account set money = money - 1000 where name = 'tom'";
            //执行SQL
            stat.executeUpdate(sqlOut);
            //int a = 1 / 0;
            //拼写jerry+1000的SQL语句
            String sqlIn = "update account set money = money + 1000 where name = 'jerry'";
            stat.executeUpdate(sqlIn);

            //提交事务
            con.commit();
        }catch (Exception ex){
            //程序执行catch,出现异常,SQL语句执行失败,回滚
            ex.printStackTrace();
            try {
                //回滚
                con.rollback();
            }catch (Exception e){e.printStackTrace();}
        }finally {
            //释放资源
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}














