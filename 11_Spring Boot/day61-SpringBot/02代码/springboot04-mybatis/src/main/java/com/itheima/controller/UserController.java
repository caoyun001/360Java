package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: hero brother
 * @date: Created in 2019/12/16
 * @description:
 * @version: 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    //查询所有用户信息
    @RequestMapping("/user/findAll")
    public List<User> findAll(){
        /**
         * 首先从redis缓存取数据：key，service接口的全限定名称+方法名称
         * 如果有呢？返回给用户
         * 如果没有：从数据库中查询，然后返回给用户，并存储到redis缓存中
         */
        //首先从redis缓存取数据
        //service接口的全限定名称+方法名称
        String key = userService.getClass().getName() + "findAll";
        List<User> users = (List<User>) redisTemplate.boundValueOps(key).get();
        //判断用户数据是否存在
        if (users == null){
            //如果没有：从数据库中查询，然后返回给用户，并存储到redis缓存中
            users = userService.findAll();
            //并存储到redis缓存中
            redisTemplate.boundValueOps(key).set(users);
            System.out.println("----------从数据库中取数据----------");
        }else {
            System.out.println("----------从Redis缓存中取数据----------");
        }
        //有，直接返回给用户
        return users;
    }
}
