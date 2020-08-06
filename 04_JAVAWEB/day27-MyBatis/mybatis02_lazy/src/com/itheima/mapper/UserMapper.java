package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 用户对订单的一对多查询
     */
    List<User> queryUserOrders();
}
