package com.itheima.mapper;

import com.itheima.pojo.Orders;

import java.util.List;

public interface OrdersMapper {
    /**
     * 查询定的的全部数据
     */
    List<Orders> queryOrders();
}
