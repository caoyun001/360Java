package com.itheima.service;

import com.itheima.pojo.Account;

/**
 * 账户的业务层接口
 */
public interface AccountService {
    //更新账户
    public void update(Account account);

    //根据name 查询 账户
    public Account findByName(String name);
}
