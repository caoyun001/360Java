package com.itheima.controller;

import com.itheima.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 向浏览器输出一个字符串：Hi,my name is SpringBoot!!!
 */
@RestController
public class HelloController {

    @Value("${message1}")
    private String message1;
    @Value("${message2}")
    private String message2;

    @Autowired
    private Person person;

    @Autowired
    private Environment environment;

    @RequestMapping("sayHello")
    public String sayHello(){
//        System.out.println(message1);
//        System.out.println(message2);
        System.out.println("person::"+person);
        System.out.println("message2::"+environment.getProperty("message2"));
        System.out.println("message1::"+environment.getProperty("message1"));
        return "Hi,my name is SpringBoot!!!person ："+person;
    }
}
