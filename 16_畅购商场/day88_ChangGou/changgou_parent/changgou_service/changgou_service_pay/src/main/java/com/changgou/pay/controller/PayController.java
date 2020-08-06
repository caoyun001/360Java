package com.changgou.pay.controller;

import com.changgou.pay.config.TokenDecode;
import com.changgou.pay.service.PayService;
import com.github.wxpay.sdk.WXPayUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *  支付业务
 */
@RestController
@RequestMapping("/wxpay")
public class PayController {

    @Autowired
    private TokenDecode tokenDecode;

    @Autowired
    private PayService payService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 预支付接口
     * @return
     */
    @GetMapping("/nativePay")
    public Map<String, String> nativePay() {
        //1. 获取当前登录用户的用户名
        Map<String, String> userInfo = tokenDecode.getUserInfo();
        String username = userInfo.get("username");

        //2. 调用service
        Map<String, String> resultMap = payService.nativePay(username);
        return resultMap;
    }

    /**
     * 接收支付回调结果
     */
    @RequestMapping("/notify")
    public Map notify(HttpServletRequest request) throws Exception {

        //System.out.println("======已经收到回调结果===========");
        /**
         * 1. 将接收到的回调结果转换为Map格式
         */
        //从请求中获取输入流
        ServletInputStream inputStream = request.getInputStream();
        //将输入流借助工具包转换成字符串
        String wxResultstr = IOUtils.toString(inputStream, "utf-8");
        //借助微信工具类, 将xml格式字符串转换成Map格式
        Map<String, String> wxResultMap = WXPayUtil.xmlToMap(wxResultstr);


        /**
         * 2. 将支付成功的订单号和交易流水号发送到rabbitMq的order_pay做后续订单业务处理
         */
        rabbitTemplate.convertAndSend("", "order_pay", wxResultMap);

        /**
         * 3. 将支付成功的订单号发送到rabbitMq的paynotify交换器中, 从而推送到消费者页面
         *  让消费者页面跳转到支付成功页面
         */
        rabbitTemplate.convertAndSend("paynotify", "", wxResultMap.get("out_trade_no"));

        /**
         * 给微信服务器返回成功信息
         * 告诉微信服务器别再给我发回调结果了, 我已经接收到了
         */
        Map map = new HashMap();
        map.put("return_code", "SUCCESS");
        map.put("return_msg", "OK");
        return map;
    }

    /**
     * 调用微信查询接口查询支付状态
     * @param orderId   查询的订单id
     * @return
     */
    @GetMapping("/query/{orderId}")
    public Map queryPayStatus(@PathVariable("orderId") String orderId) {
        Map map = payService.queryPayStatus(orderId);
        return map;
    }

    /**
     * 调用微信关闭订单接口, 关闭支付通道
     * @param orderId   关闭通道的订单id
     * @return
     */
    @GetMapping("/close/{orderId}")
    public Map closePay(@PathVariable("orderId") String orderId) {
        Map map = payService.closePay(orderId);
        return map;
    }
}
