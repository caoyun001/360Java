package com.itheima.study.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.study.mvc.entity.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/2
 * @description ：所有子控制的基类
 * @version: 1.0
 */
public class BaseController {
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
