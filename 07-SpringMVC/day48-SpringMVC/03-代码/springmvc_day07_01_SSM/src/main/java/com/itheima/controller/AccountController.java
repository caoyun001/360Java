package com.itheima.controller;

import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 账户的控制层
 */
@RestController
@RequestMapping("account")
public class AccountController {

    //依赖注入AccountService对象
    @Autowired
    private AccountService accountService;

    //增
    @RequestMapping("save")
    public String save(@RequestBody Account account){
        //调用Service层的添加方法
        accountService.save(account);

        return "success";
    }

    //删
    @RequestMapping("deleteById")
    public String deleteById(Integer id){
        //调用Service层的删除方法
        accountService.deleteById(id);

        return "success";
    }

    //改
    @RequestMapping("update")
    public String update(@RequestBody Account account){
        //调用Service层的修改方法
        accountService.update(account);

        return "success";
    }

    //查(根据id 查询账户对象)
    @RequestMapping("findById")
    public Account findById(Integer id){
        //调用service, 获取指定id 对应的account对象
        Account account = accountService.findById(id);
        return account;
    }

    //查(查询所有账户对象)
    @RequestMapping("findAll")
    public List<Account> findAll(){
        System.out.println("findAll 执行了");
        //调用service, 获取所有的账户信息
        List<Account> accountList = accountService.findAll();

        return accountList;
    }

}
