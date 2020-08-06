package com.itheima;

import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {
    public static void main(String[] args) {
        //1. 创建Spring容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2. 获取AccountService对象
        AccountService accountService = applicationContext.getBean(AccountService.class);
        //3. 调用方法
        accountService.save();
    }
}
