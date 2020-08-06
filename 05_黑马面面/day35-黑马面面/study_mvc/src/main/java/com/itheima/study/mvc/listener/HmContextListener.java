package com.itheima.study.mvc.listener;

import com.itheima.study.mvc.anno.HmComponet;
import com.itheima.study.mvc.anno.HmRequestMapping;
import com.itheima.study.mvc.utils.HmClassScanner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/2
 * @description ：上下文监听器
 * @version: 1.0
 */
public class HmContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("应用已启动...contextInitialized...");
		String scanPackage = servletContextEvent.getServletContext().getInitParameter("HmScanPackage");
		initHmAnno(scanPackage);
	}
	// 初始化黑马注解
	private void initHmAnno(String scanPackage){
		System.out.println("应用启动...扫描类扫描注解");
		List<Class<?>> classList = HmClassScanner.getClasssFromPackage(scanPackage);
		// 2.遍历集合，查找带有自定义注解的类
		for (Class clazz:classList){
			if(clazz.isAnnotationPresent(HmComponet.class)){
				System.out.println("带有HmComponet注解的类："+clazz.getSimpleName());
				// 获取类中的方法
				Method[] methods = clazz.getMethods();
				// 遍历类中方法，查找带有HmRequestMapping注解的方法
				for (Method method:methods){
					if(method.isAnnotationPresent(HmRequestMapping.class)){
						System.out.println("带有HmRequestMapping注解的方法："+method.getName());
						// 调用该方法,根据当前的访问路径，去匹配方法的注解路径
						// 读取注解方法的注解值
						String requestMapping = method.getAnnotation(HmRequestMapping.class).value();
						// 把映射和method存储起来
						// /course/add.do   ==> mehthod实例
						HmAppContext.mapMehthod.put(requestMapping,method);
					}
				}
			}
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("应用已关闭...contextDestroyed...");
	}
}
