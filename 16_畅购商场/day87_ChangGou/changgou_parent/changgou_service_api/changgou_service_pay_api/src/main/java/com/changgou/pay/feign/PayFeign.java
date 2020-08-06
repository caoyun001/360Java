package com.changgou.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 *
 */
@FeignClient(name = "pay")
public interface PayFeign {

    /**
     * 预支付接口
     * @return
     */
    @GetMapping("/wxpay/nativePay")
    public Map<String, String> nativePay();

    /**
     * 调用微信查询接口查询支付状态
     * @param orderId   查询的订单id
     * @return
     */
    @GetMapping("/wxpay/query/{orderId}")
    public Map queryPayStatus(@PathVariable("orderId") String orderId);

    /**
     * 调用微信关闭订单接口, 关闭支付通道
     * @param orderId   关闭通道的订单id
     * @return
     */
    @GetMapping("/wxpay/close/{orderId}")
    public Map closePay(@PathVariable("orderId") String orderId);
}
