package com.itheima.factory;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;

//采用 对象调用普通方法的方式
public class InstanceFactory {

    public AccountService createAccountService(){
        return new AccountServiceImpl();
    }
}
