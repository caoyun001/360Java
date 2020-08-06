package com.itheima.study.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.study.mvc.entity.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/24
 * @description ：控制器父类
 * @version: 1.0
 */

public class BaseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 获取请求参数action的值
			String action = request.getParameter("action");
			System.out.println("action:"+action);
			// 通过action值，反射当前对象调用以该值命名的方法
			if(action == null || action.length() == 0) {
				Result result = new Result(false,"缺少action参数");
				printResult(response,result);
				return;
			}
			Class clazz = this.getClass();
			Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		}catch (Exception ex){
			ex.printStackTrace();
			Result result = new Result(false,"action参数不正确，未匹配到web方法");
			printResult(response,result);
		}
	}

	/**
	 * 公共方法
	 * 输出JSON到客户端
	 * @param resp
	 * @param result
	 * @throws ServletException
	 * @throws IOException
	 */
	public void printResult(HttpServletResponse resp, Result result) throws ServletException, IOException{
		resp.setContentType("application/json;charset=utf-8");
		JSON.writeJSONString(resp.getWriter(),result);
	}
}
