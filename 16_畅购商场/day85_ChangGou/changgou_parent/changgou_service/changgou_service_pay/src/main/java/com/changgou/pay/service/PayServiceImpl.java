package com.changgou.pay.service;

import com.changgou.entity.Constants;
import com.changgou.order.pojo.Order;
import com.github.wxpay.sdk.WXPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private WXPay wxPay;

    /**
     * 获取配置文件中的内网穿透服务器回调地址
     */
    @Value("${wxpay.notify_url}")
    private String notify_url;

    @Override
    public Map<String, String> nativePay(String userName) {
        //1. 根据用户名到redis中获取待支付订单对象
        List<Order> orderList = redisTemplate.boundHashOps(Constants.REDIS_ORDER_PAY + userName).values();
        //2. 调用微信统一下单接口, 返回支付链接
        if (orderList != null && orderList.size() > 0) {
            //默认去待支付订单列表中的第一个待支付订单, 让消费者支付
            Order order = orderList.get(0);

            //封装调用微信统一下单接口的参数
            Map<String,String> paramMap=new HashMap<>();
            paramMap.put("body","畅购");//商品描述
            paramMap.put("out_trade_no",order.getId());//订单号
            //String.valueOf(order.getPayMoney())
            paramMap.put("total_fee", "1");//金额, 微信中支付金额以分为单位
            paramMap.put("spbill_create_ip","127.0.0.1");//终端IP
            paramMap.put("notify_url", notify_url);//回调地址
            paramMap.put("trade_type","NATIVE");//交易类型

            //调用微信统一下单接口
            try {
                Map<String, String> resultMap = wxPay.unifiedOrder(paramMap);
                //订单id
                resultMap.put("orderId", order.getId());
                //支付总价钱
                resultMap.put("payMoney", String.valueOf(order.getPayMoney()));
                return resultMap;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public Map queryPayStatus(String orderId) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("out_trade_no", orderId);

        try {
            Map<String, String> resultMap = wxPay.orderQuery(paramMap);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Map closePay(String orderId) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("out_trade_no", orderId);

        try {
            Map<String, String> resultMap = wxPay.closeOrder(paramMap);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
