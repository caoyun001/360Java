package com.itheima.jdbc;

import com.itheima.domain.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 需求:
 *   查询数据表users
 *   每一行存储到Users类的对象中
 *   4行数据,出现4个Users类的对象 --> 集合
 */
public class JdbcDemo03 {
    public static void main(String[] args) throws Exception{
        //1:注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2:获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day18_2","root","root");
        //3:获取执行对象
        Statement stat = con.createStatement();
        //查询的SQL
        String sql = "select * from users";
        //4:执行SQL语句,获取结果集
        ResultSet rs =  stat.executeQuery(sql);
        //创建集合,存储Users对象
        List<Users> list = new ArrayList<Users>();
        //5: 循环遍历结果集
        while (rs.next()){
            //进入循环,有一个结果集,有一个Users对象
            Users users = new Users();
            //结果集数据 ,存储Users对象
            users.setUid( rs.getInt("uid") );
            users.setUsername( rs.getString("username") );
            users.setPassword( rs.getString("password") );
            users.setNickname( rs.getString("nickname") );
            //Users对象,存储到集合中
            list.add(users);
        }
        //释放资源
        rs.close();
        stat.close();
        con.close();

        //集合遍历
        if(list != null && list.size() > 0){
            for(Users users : list){
                System.out.println(users);
            }
        }
    }
}
