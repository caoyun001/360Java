package com.itheima.framework.mvc;

import com.itheima.framework.HmConst;
import com.itheima.framework.annotation.HmMethod;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/9
 * @description ：请求转发控制器
 *  负责把所有客户端的请求路径，转发调用对应的控制器类实例的具体方法
 * @version: 1.0
 */
public class HmDispatherServlet extends HttpServlet {
	// 读取上下文信息
	HmApplicationContext applicationContext;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//获得上下文对象
		ServletContext servletContext = config.getServletContext();
		applicationContext = (HmApplicationContext) (HmApplicationContext) servletContext.getAttribute(HmConst.HM_APPLICATION_CONTEXT);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 解析请求地址
		String requestURI = req.getRequestURI(); //例如：/mm/xxx.do
		// 获得当前web应用的名称
		String contextPath = req.getContextPath();//例如：/mm
		// 截取我们需要的web资源的名称  即：去掉扩展名 和 web应用名称
		String mappingPath = requestURI.substring(contextPath.length(),requestURI.indexOf(".")); //例如：/xxx
		// 根据路径，找到HmMethod对象，并调用控制器的方法
		HmMethod hmMethod = applicationContext.getMethodMaps().get(mappingPath);
		if(hmMethod != null){
			//取出方法资源进行执行
			Method method = hmMethod.getMethod();
			try{
				method.invoke(hmMethod.getInstance(),req,resp);
			}catch(Exception e){
			    e.printStackTrace();
			    throw new ServletException(e.getMessage());
			}
		}else {
			throw new ServletException("访问路径错误或路径资源未实例化，mappingPath:"+mappingPath);
		}

	}


}
