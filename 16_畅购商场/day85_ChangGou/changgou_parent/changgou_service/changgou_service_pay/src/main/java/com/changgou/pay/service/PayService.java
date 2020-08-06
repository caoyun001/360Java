package com.changgou.pay.service;

import java.util.Map;

/**
 *
 */
public interface PayService {

    /**
     * 预支付接口, 调用微信统一下单接口返回支付链接
     * @param userName  当前登录用户的用户名
     * @return
     */
    public Map<String, String> nativePay(String userName);

    /**
     * 调用微信查询支付状态接口
     * @param orderId
     * @return
     */
    public Map queryPayStatus(String orderId);

    /**
     * 关闭微信支付通道
     * @param orderId
     * @return
     */
    public Map closePay(String orderId);
}
