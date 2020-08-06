package com.itheima.study.dubbo.service;

/**
 * @author ：zhang
 * @date ：Created in 2019/11/25
 * @description ：用户服务
 * @version: 1.0
 */
public interface UserService {

    /**
     * 用户名密码登录
     * @param username 用户名
     * @param password 密码
     * @return 是成功
     */
    boolean login(String username,String password);
}
