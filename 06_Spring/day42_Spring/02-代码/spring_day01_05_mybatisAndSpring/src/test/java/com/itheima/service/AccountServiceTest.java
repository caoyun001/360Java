package com.itheima.service;

import com.itheima.pojo.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;
/*
测试类 : Mybatis与 Spring框架的整合
 */
public class AccountServiceTest {

    private AccountService accountService = null;

    @Before
    public void before(){
        //1. 创建SpringIOC容器, 加载Spring的核心配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicaitonContext.xml");
        //2. 从SpringIOC容器, 获取对象
        accountService = applicationContext.getBean(AccountService.class);
    }

    @Test
    public void update() {
        //3.对象调用方法
        Account account = new Account();
        account.setId(3);
        account.setName("隔壁老王666");
        account.setMoney(99999d);

        accountService.update(account);
    }

    @Test
    public void findByName() {
        Account account = accountService.findByName("隔壁老王666");
        System.out.println("account = " + account);
    }
}