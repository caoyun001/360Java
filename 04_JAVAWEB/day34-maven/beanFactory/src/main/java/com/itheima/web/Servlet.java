package com.itheima.web;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.utils.BeanFactory;

public class Servlet {

    public void doGet(){
        /**
         * web层获取业务层接口实现类，不能new
         * 通过工具类 BeanFactor获取
         * 传递业务层的接口
         */
        UserService userService = BeanFactory.getInstance(UserService.class);
        userService.register();

        UserDao userDao = BeanFactory.getInstance(UserDao.class);
        userDao.register();
    }
}
