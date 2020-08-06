package com.itheima.dao;

import com.itheima.pojo.User;
import com.itheima.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

    /**
     * 业务层传递关键词
     * 查询数据表,返回集合
     */
    public List<User> search(String keyWord) throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from user where name like ?";
        return qr.query(sql,new BeanListHandler<User>(User.class),"%"+keyWord+"%");
    }

    /**
     * 业务层传递用户名
     * 查询数据表,返回User对象
     */
    public User queryUserByName(String username) throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from user where name = ?";
        return qr.query(sql,new BeanHandler<User>(User.class),username);
    }
}
