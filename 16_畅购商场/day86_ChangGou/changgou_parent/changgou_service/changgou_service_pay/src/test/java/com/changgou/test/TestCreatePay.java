package com.changgou.test;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WeChatPayConfig;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class TestCreatePay {

    public static void main(String[] args) throws Exception {
        //1.调用微信初始化类, 获取传智的app平台唯一标识, 商户号, 商户秘钥等信息
        WeChatPayConfig config = new WeChatPayConfig();
        //2. 调用微信支付工具包
        WXPay wxPay = new WXPay(config);

        //3. 封装传给微信统一下单接口的参数
        Map<String,String> map=new HashMap<>();
        map.put("body","畅购");//商品描述
        map.put("out_trade_no","wwww453451211111");//订单号
        map.put("total_fee","1");//金额, 微信中支付金额以分为单位
        map.put("spbill_create_ip","127.0.0.1");//终端IP
        map.put("notify_url","http://www.baidu.com");//回调地址
        map.put("trade_type","NATIVE");//交易类型

        //4. 调用微信统一下单接口
        Map<String, String> resultMap = wxPay.unifiedOrder(map);
        System.out.println(resultMap);
    }
}
