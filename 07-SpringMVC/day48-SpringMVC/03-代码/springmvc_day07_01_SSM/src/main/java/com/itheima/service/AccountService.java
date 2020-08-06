package com.itheima.service;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * 账户的service接口
 */
public interface AccountService {

    //增
    void save(Account account);

    //删
    void deleteById(Integer id);

    //改
    void update(Account account);

    //查(根据id 查询账户)
    Account findById(Integer id);

    //查(查询所有账户)
    List<Account> findAll();
}
