package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    /**
     * 表现层传递关键词
     * 调用持久层查询用户数据
     * 结果是集合,返回表现层
     */
    public List<User> search(String keyWord){
        UserDao userDao = new UserDao();
        List<User> userList = null;

        try {
            userList = userDao.search(keyWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    /**
     * 表现层传递用户名
     * 调用持久层查询用户,
     * 查询的结果User对象,返回到表现层
     */
    public User queryUserByName(String username){
        UserDao userDao = new UserDao();
        User user = null;
        try {
            user = userDao.queryUserByName(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
