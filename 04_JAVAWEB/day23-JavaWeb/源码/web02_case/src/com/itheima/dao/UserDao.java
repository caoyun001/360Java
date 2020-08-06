package com.itheima.dao;

import com.itheima.pojo.User;
import com.itheima.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * 处理用户数据的持久层
 */
public class UserDao {

    /**
     * 实现登录查询
     * 参数用户名密码
     * 查询结果集User对象
     */
    public User login(String username,String password)throws SQLException{
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        //拼写查询的select语句
        String sql = "select * from user where username=? and password=?";
        //执行查询,结果集处理使用BeanHandler
        return qr.query(sql,new BeanHandler<User>(User.class),username,password);
    }


    /**
     * 方法,实现注册
     * 新增数据: 业务层传递User对象
     */
    public void register(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        //拼写insert语句
        String sql = "insert into user values(?,?,?,?,?,?,?)";
        //定义数组,存储User对象中的参数
        Object[] params = {null,user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getGender(),user.getBirthday()};
        //执行新增
        qr.update(sql,params);
    }
}
