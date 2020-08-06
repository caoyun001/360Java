package com.itheima.dao;

import com.itheima.pojo.User;

import java.util.List;

public interface UserDao {
    //查询User标签的全部数据
    List<User> queryUser();
}
