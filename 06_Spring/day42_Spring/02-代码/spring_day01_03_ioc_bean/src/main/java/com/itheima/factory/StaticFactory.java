package com.itheima.factory;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * 采用类中静态方法的方式 进行Bean对象的创建
 */
public class StaticFactory {
    public static AccountService createAccountService(){
        return new AccountServiceImpl();
    }
}
