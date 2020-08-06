package com.changgou.controller;


import com.changgou.order.feign.CartFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/wcart")
public class CartController {
    
    @Autowired
    private CartFeign cartFeign;

    //没有对接网关时购物车列表的URL
    //private String cartUrl = "http://web.changgou.com:9111";

    //对接网关时购物车列表的URL
    private String cartUrl = "http://web.changgou.com:8001/api";

    @GetMapping("/list")
    public String list(Model model){
        Map result = cartFeign.list();
        model.addAttribute("result",  result);
        return "cart";
    }


    @GetMapping("/add")
    public String add(@RequestParam("skuId") String skuId, @RequestParam(value = "num",required = false, defaultValue = "1") Integer num){
        cartFeign.add(skuId,num );
        return "redirect:" + cartUrl + "/wcart/list";
    }

    @GetMapping("/updateChecked")
    public String updateChecked(@RequestParam("skuId") String skuId, @RequestParam("checked")  Boolean checked){
        cartFeign.updateChecked(skuId, checked);
        return "redirect:" + cartUrl + "/wcart/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("skuId") String skuId){
        cartFeign.delete(skuId);
        return "redirect:" + cartUrl + "/wcart/list";
    }
}
