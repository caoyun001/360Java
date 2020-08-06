package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
//加载的xml配置文件
//@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
//加载的注解形式的java文件
@ContextConfiguration(classes = {SpringConfig.class})
public class AccountServiceTest {

    //依赖注入
    @Autowired
    private AccountService accountService;

    @Test
    public void save() {
        Account account = new Account();
        account.setName("测试");
        account.setMoney(999d);

        accountService.save(account);
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findByName() {
        Account account = accountService.findByName("隔壁老王666");
        System.out.println("account = " + account);
    }

    @Test
    public void findAll() {
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }

    //测试转账
    @Test
    public void transfer() {
       accountService.transfer("aaa", "bbb", 100d);
    }
}