package com.itheima.study.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itheima.study.mvc.entity.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/24
 * @description ：学科添加控制器
 * @version: 1.0
 */
@WebServlet("/course/add.do")
public class CourseAddController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取前端请求数据
		System.out.println("获取客户端请求...");
		System.out.println("调用Service...完成添加");
		System.out.println("响应客户端...");
		Result result = new Result(true,"添加学科成功");
		resp.setContentType("application/json;charset=utf-8");
		JSON.writeJSONString(resp.getWriter(),result);

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req,resp);
	}
}
