package com.itheima.service;

import com.itheima.dao.AccountDao;
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
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        //获取AccountService对象方式一
        //AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        //获取AccountService对象方式二(常用)
        //AccountService accountService2 = applicationContext.getBean(AccountService.class);
        //获取AccountSerViice对象方式三
        //AccountService accountService3 = applicationContext.getBean("accountService", AccountService.class);

        //获取AccountService对象, 采用类的静态方法的方式
        //AccountService accountService4 = applicationContext.getBean("accountService3", AccountService.class);
        //accountService4.save();
        //获取AccountService对象, 采用类的静态方法的方式
        AccountService accountService5 = applicationContext.getBean("accountService4", AccountService.class);
        accountService5.save();

        //accountService.save();
        //accountService2.save();
        //accountService3.save();

        //AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        //System.out.println("accountDao = " + accountDao);
        //AccountDao accountDao2 = applicationContext.getBean(AccountDao.class);
        //System.out.println("accountDao2 = " + accountDao2);

        //SPringIOC容器的关闭
        applicationContext.close();
    }
}