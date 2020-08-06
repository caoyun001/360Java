package com.changgou.controller;

import com.changgou.order.feign.CartFeign;
import com.changgou.order.feign.OrderFeign;
import com.changgou.order.pojo.Order;
import com.changgou.user.feign.AddressFeign;
import com.changgou.user.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 订单controller
 */
@Controller
@RequestMapping("/worder")
public class WebOrderController {

    @Autowired
    private AddressFeign addressFeign;

    @Autowired
    private CartFeign cartFeign;

    @Autowired
    private OrderFeign orderFeign;

    /**
     * 跳转到结算页面
     * @return
     */
    @GetMapping("/ready")
    public String ready(Model model) {

        //1. 获取收货地址列表
        List<Address> addressList = addressFeign.findAddressListByUserName();
        model.addAttribute("addressList", addressList);

        //2. 获取默认收货地址
        Address deafAddress = null;
        if (addressList != null) {
            for (Address address : addressList) {
                if ("1".equals(address.getIsDefault())) {
                    deafAddress = address;
                }
            }
        }
        model.addAttribute("defaultAddress", deafAddress);

        //3. 获取购物车列表
        Map cartMap = cartFeign.list();
        model.addAttribute("cartMap", cartMap);
        return "order";
    }

    /**
     * 提交订单
     * @return
     */
    @PostMapping("/submit")
    public String submit(Order order) {
        //保存订单
        orderFeign.add(order);
        //跳转到预支付接口
        return "redirect:http://web.changgou.com:8001/api/wxpay/nativePay";
    }
}
