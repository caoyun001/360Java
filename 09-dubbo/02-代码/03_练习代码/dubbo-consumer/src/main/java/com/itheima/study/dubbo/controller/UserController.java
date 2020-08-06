package com.itheima.study.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.study.dubbo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：zhang
 * @date ：Created in 2019/11/25
 * @description ：用户控制器
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/login")
    public String login(String username,String password){

        System.out.println("[登录]u:"+username+",p:"+password);

        boolean success = userService.login(username, password);
        if(success){
            return "login success";
        }
        return "login fail";
    }

}
