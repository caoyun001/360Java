package com.changgou.order.controller;

import com.changgou.config.TokenDecode;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private TokenDecode tokenDecode;

    @GetMapping("/add")
    public Result add(@RequestParam("skuId") String skuId, @RequestParam(value = "num",required = false, defaultValue = "1") Integer num){
        String username = tokenDecode.getUserInfo().get("username");

        cartService.add(username, skuId, num);

        return new Result(true, StatusCode.OK, "添加购物车成功");
    }

    @GetMapping("/list")
    public Map list(){
        String username = tokenDecode.getUserInfo().get("username");
        Map result = cartService.list(username);
        return result;
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam("skuId") String skuId){
        String username = tokenDecode.getUserInfo().get("username");
        cartService.delete(username, skuId);
        return new Result(true, StatusCode.OK, "删除购物车商品成功");
    }

    @GetMapping("/updateChecked")
    public Result updateChecked(@RequestParam("skuId") String skuId,@RequestParam("checked")  Boolean checked){
        String username = tokenDecode.getUserInfo().get("username");
        cartService.updateChecked(username, skuId, checked);
        return new Result(true, StatusCode.OK, "更新购物车商品选中状态成功");
    }
}
