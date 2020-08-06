package com.itheima.study.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.study.mvc.entity.Result;
import com.itheima.study.mvc.service.CourseService;
import com.itheima.study.mvc.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/24
 * @description ：新学科控制器
 * @version: 1.0
 */
@WebServlet("/new/course.do")
public class NewCourseController extends BaseServlet {

	// 添加学科
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("获取客户端请求...");
		System.out.println("调用Service...完成添加");
		System.out.println("响应客户端...");
		Result result = new Result(true,"添加学科成功");
		printResult(resp,result);
	}

	// 删除学科
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取前端请求数据
		System.out.println("获取客户端请求...");
		System.out.println("调用Service...完成删除");
		System.out.println("响应客户端...");
		Result result = new Result(true,"删除学科成功");
		printResult(resp,result);
	}

	// 更新学科
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取前端请求数据
		System.out.println("获取客户端请求...");
		System.out.println("调用Service...完成更新");
		System.out.println("响应客户端...");
		Result result = new Result(true,"更新学科成功");
		printResult(resp,result);
	}
	// 查询学科
	public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取前端请求数据
		System.out.println("获取客户端请求...");
		System.out.println("调用Service...完成查询");
		System.out.println("响应客户端...");
		CourseService courseService = new CourseServiceImpl();
		Result result = new Result(true,"查询学科成功",courseService.findAll());
		printResult(resp,result);
	}
}

