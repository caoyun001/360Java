package com.changgou.controller;

import com.changgou.pay.feign.PayFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 *  支付业务
 */
@Controller
@RequestMapping("/wxpay")
public class WebPayController {

    @Autowired
    private PayFeign payFeign;

    /**
     * 预支付接口
     * @return
     */
    @GetMapping("/nativePay")
    public String nativePay(Model model) {

        //调用支付业务微服务的预支付接口
        Map<String, String> wxResultMap = payFeign.nativePay();

        model.addAttribute("orderId", wxResultMap.get("orderId"));
        model.addAttribute("payMoney", Float.parseFloat(wxResultMap.get("payMoney")));
        model.addAttribute("code_url", wxResultMap.get("code_url"));
        return "wxpay";
    }
}
