package com.itheima.service;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * 账户业务接口
 */
public interface AccountService {

    /**
     * 转账
     */
    void transfer(String source, String target, double money);

    /**
     * 保存
     */
    void save(Account account);

    /**
     * 根据id删除
     */
    void delete(Integer id);

    /**
     * 更新账户
     */
    void update(Account account);

    /**
     * 根据id查询
     */
    Account findById(Integer id);

    /**
     * 根据名称查询账户
     */
    Account findByName(String name);

    /**
     * 查询所有
     */
    List<Account> findAll();
}
