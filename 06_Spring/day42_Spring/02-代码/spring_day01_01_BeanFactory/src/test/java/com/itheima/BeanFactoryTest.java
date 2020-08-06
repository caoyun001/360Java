package com.itheima;

import com.itheima.factory.BeanFactory;
import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test(){
        //AccountService accountService = new AccountServiceImpl();
        AccountService accountService = (AccountService) BeanFactory.getBean("AccountService");
        accountService.save();
    }
}
