package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();
    public List<User> findAll(){
        List<User> userList = null;
        try {
            userList = userDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
