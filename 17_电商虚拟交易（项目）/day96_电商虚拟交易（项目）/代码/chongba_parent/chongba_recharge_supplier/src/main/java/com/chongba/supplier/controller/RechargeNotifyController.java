package com.chongba.supplier.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chongba.cache.CacheService;
import com.chongba.entity.Constants;
import com.chongba.recharge.entity.OrderTrade;
import com.chongba.recharge.mapper.OrderTradeMapper;
import com.chongba.supplier.inf.SupplierTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by 传智播客*黑马程序员.
 */
@RestController
@Slf4j
public class RechargeNotifyController {



    @Autowired
    private CacheService cacheService;

    @RequestMapping("/recovery")
    public String recovery(String supply){
        Set<String> excluedes = cacheService.setMembers(Constants.exclude_supplier);
        if(excluedes.contains(supply)){
            cacheService.sRemove(Constants.exclude_supplier,supply);
            return "恢复成功!";
        }else {
            return "供应商编号不存在!";
        }
    }


    @Autowired
    protected OrderTradeMapper orderTradeMapper;

    @Autowired
    private SupplierTask supplierTask;
    
    @RequestMapping(value = "/order/notify")
    public String notify(@RequestBody String result) {
        JSONObject jsonObject = (JSONObject) JSON.parse(result);
        String orderNo= (String) jsonObject.get("orderNo");
        int status= Integer.parseInt(jsonObject.get("status").toString());
        log.info("充值回调成功修改订单{}的状态为{}",orderNo,status);
        updateTrade(orderNo, status);
        //取消订单状态查询的任务
        log.info("回调成功后取消状态检查任务");
        supplierTask.cancelCheckTask(orderNo);
        return "sucess";
    }

    private void updateTrade(String  orderNo, int orderStatus) {
        //修改订单状态
        QueryWrapper<OrderTrade> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_no", orderNo);
        OrderTrade orderTrade = orderTradeMapper.selectOne(queryWrapper);
        if(orderTrade!=null) {
            orderTrade.setOrderStatus(orderStatus);
            orderTradeMapper.update(orderTrade, queryWrapper);
        }
    }
}
