package com.itheima.mm.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.UserService;
import com.itheima.mm.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

/**
 * @author ：yangsong
 * @date ：Created in 2019/11/4
 * @description ：用户控制器(子控制器)
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class UserController extends BaseController {

	/**
	 * 用户登录
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServerException
	 */
	@HmRequestMapping("/user/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws
			IOException, ServerException{
	   // 接收前端数据(JSON格式)，并封装到ＰＯＪＯ对象
		User userFrom = JSON.parseObject(request.getInputStream(),User.class);
		log.debug("页面数据:userFrom:{}",userFrom);
		// 假设调用Service完成登录
		UserService userService = new UserServiceImpl();
		User daoUser = userService.findUserByUsername(userFrom.getUsername());
		// 判断用户是否为null
		if(daoUser == null){
			// 响应JSON
			Result result = new Result(false,"登录失败，用户不存在！！！");
			printResult(response,result);
			return;
		}
		// 用户存在，判断密码是否有一致
		if(daoUser.getPassword().equals(userFrom.getPassword())){
			printResult(response,new Result(true,"登录成功",daoUser.getUsername()));
		}else{
			printResult(response,new Result(false,"登录失败，密码错误"));
		}

	}
}
