package com.itheima.jdbc;

import com.itheima.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  使用工具类,实现数据的操作
 *  查询和更新
 */
public class JdbcDemo06 {
    public static void main(String[] args) {
        select();
    }
    /**
     * 实现数据查询
     */
    public static void select(){
        //声明变量
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            //工具类,获取连接
            con = JdbcUtils.getConnection();
            //查询语句
            String sql = "select * from users";
            //获取执行对象
            pst = con.prepareStatement(sql);
            //SQL语句中,没有问号占位符,不需要setObject设置参数
            //执行语句返回结果集对象
            rs = pst.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("uid")+"\t"+rs.getString("username")+"\t"+rs.getString("password")+"\t"+rs.getString("nickname"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pst,con);
        }
    }

    /**
     * 实现数据的更新
     */
    public static void update(){
        //声明变量
        Connection con = null;
        PreparedStatement pst = null;
        try{
            //工具类,获取连接
            con = JdbcUtils.getConnection();
            //update语句
            String sql = "update users set username = ?,password = ? where uid = ?";
            //连接对象,获取SQL语句的执行对象
            pst = con.prepareStatement(sql);
            //方法setObject设置参数
            pst.setObject(1,"sili");
            pst.setObject(2,"333");
            pst.setObject(3,2);
            //执行SQL
            int i = pst.executeUpdate();
            System.out.println(i);
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            JdbcUtils.close(null,pst,con);
        }
    }

}
