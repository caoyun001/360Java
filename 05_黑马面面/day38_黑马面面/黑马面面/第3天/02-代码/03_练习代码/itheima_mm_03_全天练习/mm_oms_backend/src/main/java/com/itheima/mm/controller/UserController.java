package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.itheima.mm.common.GlobalConst.SESSION_KEY_USER;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/9
 * @description ：用户控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class UserController extends BaseController {

	@HmSetter("userService")
	private UserService userService;

	/**
	 * 登录接口
	 * 根据用户名获取用户对象
	 *   判断用户信息是否正确
	 *   登录成功，把用户信息存入session对象
	 * 返回JSON结果给前端
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/user/login")
	public void login (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("UserController save...");
		User loginForm = parseJSON2Object(request,User.class);
		log.debug("loginForm:{}",loginForm);
		User user = userService.findByUsername(loginForm.getUsername());
		if(user == null){
			printResult(response,new Result(false,"用户名不正确"));
			return;
		}
		if (user.getPassword().equals(loginForm.getPassword())){
			// 把用户对象放入session中
			request.getSession(true).setAttribute(SESSION_KEY_USER,user);
			// 登录成功，获取用户权限列表（通过UserService）
			List<String> authList = userService.getAuthList(user.getId());
			user.setAuthorityList(authList);

			printResult(response,new Result(true,"登录成功"));
		}else{
			printResult(response,new Result(false,"密码错误"));
		}
	}
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/user/logout")
	public void logout (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		if( request.getSession(false) != null){
			request.getSession(false).invalidate();
		}
		printResult(response,new Result(true,"退出成功"));
	}
}
