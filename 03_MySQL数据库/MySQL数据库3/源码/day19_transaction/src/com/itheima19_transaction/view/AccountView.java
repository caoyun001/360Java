package com.itheima.view;

import com.itheima.service.AccountService;

/**
 * 用户交互的表现层,入口
 */
public class AccountView {
    public static void main(String[] args) {
        String fukuan = "tom";
        String shoukuan = "jerry";
        double money = 1000;

        new AccountService().transfer(fukuan,shoukuan,money);
    }
}
