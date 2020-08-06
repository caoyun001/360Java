package com.itheima.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
/*
测试类
 */
//Spring框架中的Runner对象, 替换Junit中的Runner对象
@RunWith(SpringJUnit4ClassRunner.class)
//框架启动入口, xml配置文件启动(2选1)
@ContextConfiguration(locations ={"classpath:beans.xml"})
public class AccountServiceTest {

    //依赖注入
    @Autowired
    private AccountService accountService;

    @Test
    public void save() {
        accountService.save();
    }
}