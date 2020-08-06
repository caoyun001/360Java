package com.chongba.recharge;

import com.chongba.entity.order.Result;
import com.chongba.recharge.entity.OrderTrade;
import com.chongba.recharge.inf.OrderProcessService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 订单控制器
 */
@Controller
@Slf4j
public class OrderController {

	
	@Autowired
	private OrderProcessService orderProcessService;
	
	@Autowired
	private RocketMQTemplate rocketMQTemplate;
	
	
	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView view =new ModelAndView("index");
		return view;
	}
	
	/**
	 * 充值操作（充值订单）
	 *            订单请求信息
	 * @return
	 */
	@RequestMapping(value = "/crtorder")
	public ModelAndView createRechargeOrder(RechargeRequest orRequest) {
		Result<RechargeResponse> result = null;
		ModelAndView view = null;
		try {
			//对接订单系统
			result = orderProcessService.recharge(orRequest);
		} catch (Exception e) {
			e.printStackTrace();
			view =new ModelAndView("recharge");
		}
		if(result.getCode()==200) {
			//成功
		   view =new ModelAndView("pay");
		   view.addObject("result",result);
		}else {
			//失败
		   view =new ModelAndView("recharge");
		}
		return view;
	}
	

	/**
	 * 选择订单支付方式
	 * @return
	 */
	@RequestMapping(value = "/payorder")
	public ModelAndView payorder(String orderNo) {
		OrderTrade orderTrade = null;
		try {
			//根据订单号查询待支付订单
	       orderTrade = orderProcessService.queryOrderByNo(orderNo);
	       // 调用支付服务完成支付,接收支付结果

			//支付后通知供应商对接模块----异步通知
		   RechargeRequest request =new RechargeRequest();
		   request.setOrderNo(orderNo);
		   request.setMobile(orderTrade.getMobile());
		   request.setPamt(orderTrade.getSalesPrice());
		   
		   rocketMQTemplate.convertAndSend("pay", request);
		} catch (Exception e) {
			ModelAndView view =new ModelAndView("payfail");
			return view;
		}
		ModelAndView view =new ModelAndView("paysuccess");
		view.addObject("orderTrade", orderTrade);
		return view;
	}
	
	@RequestMapping(value = "/orderList")
	public ModelAndView orderList(String userId) {
		List<OrderTrade> orderList = null;
		try {
			orderList = orderProcessService.queryAllOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView view =new ModelAndView("myOrder");
		view.addObject("orderList", orderList);
		//view.addObject("pamt",pay);
		return view;
	}
	
	@RequestMapping(value = "/remove")
	public String remove(String orderNo) {
		orderProcessService.removeOrderTrade(orderNo);
		return "redirect:orderList";
	}
}
