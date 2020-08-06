package com.itheima.dao;

import com.itheima.pojo.Account;

/**
 * 账户的dao接口
 */
public interface AccountDao {

    //更新账户
    public void update(Account account);

    //根据name 查询 账户
    public Account findByName(String name);
}
