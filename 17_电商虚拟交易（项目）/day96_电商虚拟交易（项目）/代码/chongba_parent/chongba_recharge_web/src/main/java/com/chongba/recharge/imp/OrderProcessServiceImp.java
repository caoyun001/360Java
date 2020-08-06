package com.chongba.recharge.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.chongba.entity.order.Result;
import com.chongba.enums.OrderStatusEnum;
import com.chongba.recharge.RechargeRequest;
import com.chongba.recharge.RechargeResponse;
import com.chongba.recharge.inf.OrderProcessService;
import com.chongba.recharge.entity.OrderTrade;
import com.chongba.recharge.mapper.OrderTradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 对接订单系统
 */
@Service
public class OrderProcessServiceImp implements OrderProcessService {
	
	@Autowired
	protected OrderTradeMapper orderTradeMapper;
	
	@Override
	public Result<RechargeResponse> recharge(RechargeRequest request) throws Exception {
		//去调用订单微服务
		//订单trade
		 OrderTrade orderTrade = createTrade(request);
		 Result<RechargeResponse> result = new Result<RechargeResponse>();
		 RechargeResponse reponse = new RechargeResponse();
		 reponse.setMoblie(request.getMobile());
		 reponse.setOrderNo(orderTrade.getOrderNo());
		 reponse.setPamt(request.getPamt());
		 result.setData(reponse);
		 return result;
	}
	
	private OrderTrade createTrade(RechargeRequest request) {
		//模拟订单系统 ，放到trade
		String orderId = IdWorker.get32UUID();
		OrderTrade orderTrade = new OrderTrade();
		orderTrade.setOrderNo(orderId);
		orderTrade.setOrderStatus(OrderStatusEnum.WARTING.getCode());
		orderTrade.setFacePrice(request.getFactPrice());
		orderTrade.setMobile(request.getMobile());
		orderTrade.setSalesPrice(request.getPamt());
		orderTrade.setOrderTime(new Date());
		orderTrade.setBrandId(request.getBrandId());
		orderTrade.setCategoryId(request.getCategoryId());
		orderTradeMapper.insert(orderTrade);
		return orderTrade;
	}

	@Override
	public OrderTrade queryOrderByNo(String orderNo) throws Exception {
		QueryWrapper<OrderTrade> queryWrapper = new QueryWrapper<>();
	    queryWrapper.eq("order_no", orderNo);
	    return orderTradeMapper.selectOne(queryWrapper);
	}

	
	@Override
	public List<OrderTrade> queryAllOrder() throws Exception {
		QueryWrapper<OrderTrade> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("order_time");
		return orderTradeMapper.selectList(queryWrapper);
	}

	@Override
	public void removeOrderTrade(String orderNo) {
		QueryWrapper<OrderTrade> wrapper = new QueryWrapper<>();
		wrapper.eq("order_no", orderNo);
		orderTradeMapper.delete(wrapper);
	}
	
}
