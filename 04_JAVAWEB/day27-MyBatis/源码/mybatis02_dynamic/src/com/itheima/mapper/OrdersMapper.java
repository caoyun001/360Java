package com.itheima.mapper;

import com.itheima.pojo.Orders;

import java.util.List;

public interface OrdersMapper {
    /**
     * 一对一的查询,订单为基准查询用户
     */
   List<Orders> queryOrdersUser();
}
