package com.itheima.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.study.dubbo.service.UserService;

/**
 * @author ：zhang
 * @date ：Created in 2019/11/25
 * @description ：
 * @version: 1.0
 */
@Service(interfaceClass = UserService.class,loadbalance = "roundrobin")
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String username, String password) {
        System.out.println("[登录]u:"+username+",p:"+password);
        return "admin".equals(username) && "123".equals(password);
    }
}
