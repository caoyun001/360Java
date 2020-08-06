package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("ajax")
public class AjaxController {

    //测试Ajax的方法
    @RequestMapping("testAjax")
    //@ResponseBody
    public List<User> testAjax(@RequestBody User user){
        //打印接受的数据
        System.out.println("user = " + user);

        //准备给客户端浏览器返回的json数据
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("王五");
        user1.setSex("男");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("赵六");
        user2.setSex("女");

        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);

        return userList;
    }
}
