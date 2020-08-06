package com.itheima.dao;

import com.itheima.pojo.User;
import com.itheima.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

    private QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
    public List<User> findAll() throws SQLException {
        String sql = "select * from user";
        return qr.query(sql,new BeanListHandler<User>(User.class));
    }
}
