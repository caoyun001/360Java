package com.itheima.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;
/*
测试类
 */
public class AccountServiceTest {

    @Test
    public void save() {

        //使用Spring框架IOC容器, 加载Beans.xml文件, 解析了Beans.xml文件, 并把所有的Bean标签的内容 存到Map集合中
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //获取AccountService对象
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");

        accountService.save();
    }
}