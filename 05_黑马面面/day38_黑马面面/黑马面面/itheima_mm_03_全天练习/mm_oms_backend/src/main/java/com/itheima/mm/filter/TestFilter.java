package com.itheima.mm.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/7
 * @description ：复习过滤器
 * @version: 1.0
 */
@Slf4j
public class TestFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("TestFilter init...");
		// 初始化工作，比如需要提前加载某些资源到内存
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		// 执行过滤
		log.debug("TestFilter doFilter...");
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String reqPath = request.getServletPath();
		String contextPath = request.getContextPath();
		//  /mm/pages/questionClassicList.html
		//log.debug("TestFilter doFilter...contextPath:{},reqPath:{}",contextPath,reqPath);
		// 允许通过,继续执行
		filterChain.doFilter(request,response);
		// 不允许通过
		//response.getWriter().write("no!!!");
		// 重定向登陆页
		//response.sendRedirect("http://localhost:8080/mm/login.html");
	}

	@Override
	public void destroy() {
		log.debug("TestFilter destroy...");
		// 释放资源
	}
}
