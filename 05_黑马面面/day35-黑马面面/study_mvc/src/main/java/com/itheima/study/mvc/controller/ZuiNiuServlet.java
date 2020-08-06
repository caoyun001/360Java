package com.itheima.study.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.study.mvc.anno.HmComponet;
import com.itheima.study.mvc.anno.HmRequestMapping;
import com.itheima.study.mvc.entity.Result;
import com.itheima.study.mvc.listener.HmAppContext;
import com.itheima.study.mvc.utils.HmClassScanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/2
 * @description ：
 * @version: 1.0
 */
public class ZuiNiuServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqPath = req.getServletPath();
		String contextPath = req.getContextPath();
		System.out.println("ZuiNiuServlet...contextPath path:"+contextPath+" :"); // /studymvc
		System.out.println("ZuiNiuServlet...reqPath path:"+reqPath+" :"); // /course/add.do
		// 根据访问路径，从容器中寻找方法实例
		Method method = HmAppContext.mapMehthod.get(reqPath);
		try{
			if(method !=null){
				Object obj = method.getDeclaringClass().newInstance();
				method.invoke(obj,req,resp);
			}else{
				System.out.println("method==null ,未找到方法:"+reqPath);
			}
		}catch(Exception e){
		    e.printStackTrace();
			System.out.println("调用子控制器发送异常:"+e.getMessage());
			resp.getWriter().print(e.getMessage());
		}
		// 根据访问路径（reqPath），调用子控制器的Web方法（反射）
		// /test/courseAdd.do  ==> (/test/courseAdd.do)add()方法
		// 读取包中的类，查找有HmRequestMapping注解的方法，invoke调用
		//// 1.读取包中的类,返回字节码列的列表
		//List<Class<?>> classList = HmClassScanner.getClasssFromPackage("com.itheima.study.mvc.controller");
		//// 2.遍历集合，查找带有自定义注解的类
		//for (Class clazz:classList){
		//	if(clazz.isAnnotationPresent(HmComponet.class)){
		//		System.out.println("带有HmComponet注解的类："+clazz.getSimpleName());
		//		// 获取类中的方法
		//		Method[] methods = clazz.getMethods();
		//		// 遍历类中方法，查找带有HmRequestMapping注解的方法
		//		for (Method method:methods){
		//			if(method.isAnnotationPresent(HmRequestMapping.class)){
		//				System.out.println("带有HmRequestMapping注解的方法："+method.getName());
		//				// 调用该方法,根据当前的访问路径，去匹配方法的注解路径
		//				// 读取注解方法的注解值
		//				String requestMapping = method.getAnnotation(HmRequestMapping.class).value();
		//				// 注解路径与请求路径匹配，调用该方法
		//				if(requestMapping.equals(reqPath)){
		//					try{
		//						Object subController = clazz.newInstance();
		//						// 把客户请求与响应转交给子控制器处理
		//						method.invoke(subController,req,resp);
		//					}catch(Exception e){
		//						e.printStackTrace();
		//						System.out.println("调用子控制器发送异常:"+e.getMessage());
		//						resp.getWriter().print(e.getMessage());
		//					}
		//				}
		//			}
		//		}
		//	}
		//}
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
