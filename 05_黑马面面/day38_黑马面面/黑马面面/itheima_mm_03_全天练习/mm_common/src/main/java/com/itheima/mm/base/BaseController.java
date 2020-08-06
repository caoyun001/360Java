package com.itheima.mm.base;

import com.alibaba.fastjson.JSON;
import com.itheima.mm.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.itheima.mm.common.GlobalConst.HEADER_AUTHORIZATION;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/11
 * @description ：控制器基类
 * 提供所有控制器类的公共方法
 * @version: 1.0
 */
public class BaseController {
	public void printResult(HttpServletResponse response,Object obj) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		JSON.writeJSONString(response.getWriter(),obj);
	}

	public <T> T parseJSON2Object(HttpServletRequest request, Class<T> tClass) throws IOException{
		// 把表单数据之间转对象
		return JSON.parseObject(request.getInputStream(),tClass);
	}

	public User getSessionUser(HttpServletRequest request,String userKey){
		if(request.getSession(false) != null){
			return (User)request.getSession(false).getAttribute(userKey);
		}
		return null;
	}

	public String getHeaderAuthorization(HttpServletRequest request){
		return request.getHeader(HEADER_AUTHORIZATION);
	}

}
