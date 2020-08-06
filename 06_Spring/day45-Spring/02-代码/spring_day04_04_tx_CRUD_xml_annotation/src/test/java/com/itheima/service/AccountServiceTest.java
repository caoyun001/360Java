package com.itheima.service;

import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class AccountServiceTest {

    //依赖注入
    @Autowired
    private AccountService accountService;

    @Test
    public void transfer() {
        accountService.transfer("aaa","bbb",1);
    }

    @Test
    public void save() {
        Account account = new Account();
        account.setName("张猛老师");
        account.setMoney(66666d);

        accountService.save(account);
    }

    @Test
    public void delete() {
        accountService.delete(3);
    }

    @Test
    public void update() {
        Account account = new Account();
        account.setId(6);
        account.setName("张猛老师888");
        account.setMoney(888d);

        accountService.update(account);
    }

    @Test
    public void findById() {
        Account account = accountService.findById(6);
        System.out.println("account = " + account);
    }

    @Test
    public void findByName() {
        Account account = accountService.findByName("张猛老师888");
        System.out.println("account = " + account);
    }

    @Test
    public void findAll() {
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
}