package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void register(String username, String password) {
        System.out.println("UserDaoImpl register执行了");
    }
}
