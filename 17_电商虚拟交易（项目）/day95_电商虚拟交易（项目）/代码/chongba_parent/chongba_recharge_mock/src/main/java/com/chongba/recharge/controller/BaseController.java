package com.chongba.recharge.controller;

import com.alibaba.fastjson.JSON;
import com.chongba.recharge.mock.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

@Slf4j
@RestController
public class BaseController {
	
	@Value("${notify-url}")
	String notifyUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CacheService cacheSevice;
	
	protected static final ExecutorService notifyExecutor = Executors.newFixedThreadPool(50);
	
	/**
	 * 订单id
	 * 交易状态 state=1 成功 state=-1 失败
	 * @param orderNo
	 */
	public void rechargeNotify(String orderNo, String tradeNo, int orderStatus) {
		try {
			notifyExecutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						//充值
						Thread.sleep(5000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//充值结果回调
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("orderNo", orderNo);
					map.put("tradeNo", tradeNo);
					map.put("status", orderStatus);
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_JSON);
					HttpEntity<String> entity = new HttpEntity<String>(JSON.toJSONString(map), headers);
					log.warn("回调接口={}",notifyUrl);
					try {
						String result = restTemplate.postForEntity(notifyUrl, entity, String.class).getBody();
						log.warn("充值业务-通知：返回报文={}", result);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
		} catch (RejectedExecutionException e) {
			log.error("供货线程池达到限额", e);
		}
	}
	

}
