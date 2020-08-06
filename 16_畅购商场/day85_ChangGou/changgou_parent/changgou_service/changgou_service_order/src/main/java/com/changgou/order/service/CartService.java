package com.changgou.order.service;

import java.util.Map;

public interface CartService  {

    /**
     * 添加商品到购物车中
     * @param username 用户
     * @param skuId 商品ID
     * @param num 商品数量
     */
    void add(String username,String skuId, Integer num);


    /**
     * 查询当前用户购物车里所有商品条目列表
     * @param username
     * @return
     */
    Map list(String username);

    /**
     * 删除购物车中的商品条目
     * @param username
     * @param skuId
     */
    void delete(String username,String skuId);


    /**
     * 更新商品的选中状态
     * @param username
     * @param skuId
     */
    void updateChecked(String username, String skuId, Boolean checked);
}
