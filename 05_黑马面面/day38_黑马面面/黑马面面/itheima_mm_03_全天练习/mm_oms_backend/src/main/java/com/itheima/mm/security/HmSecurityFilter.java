package com.itheima.mm.security;

import com.itheima.framework.annotation.HmClassScanner;
import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.mm.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.itheima.mm.common.GlobalConst.SESSION_KEY_USER;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/7
 * @description ：权限控制过滤器
 * @version: 1.0
 */
@Slf4j
public class HmSecurityFilter implements Filter {

	// 资源权限容器
	private Map<String,String> authMaps = new HashMap<>();
	private String basePackage;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("HmSecurityFilter.init...");
		// 读取过滤器初始化参数
		String filePath = filterConfig.getInitParameter(HmSecurityConst.CONFIG_SECURITYCONFIGLOCATION);
		// 初始化工作，解析XML，提取资源权限映射关系
		parseSecurityXML(filePath);
		// 初始化工作，解析自定义组件，提取资源权限映射关系
		parseAnno();
		// log
		log.debug("所有资源权限列表：authMaps:{}",authMaps);
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		log.debug("HmSecurityFilter.doFilter...");
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String reqPath = request.getServletPath(); // /pages/questionClassicList.html
		String reqURI = request.getRequestURI();   // /mm/pages/questionClassicList.html
		String contextPath = request.getContextPath();
		if(reqPath.endsWith(".do")){
			reqPath = reqPath.replaceAll(".do","");
		}
		//  /mm/pages/questionClassicList.html
		log.debug("TestFilter doFilter...contextPath:{},reqPath:{}",contextPath,reqPath);
		// 授权认证流程
		// 判断当前访问资源是否在权限资源容器
		String accessAuth = authMaps.get(reqPath);
		if(accessAuth == null){
			// 不在容器，允许通过,继续执行
			log.debug("不在容器，允许通过,继续执行");
			filterChain.doFilter(request,response);
			return;
		}
		log.debug("当前访问资源:{},需要的权限:{}",reqPath,accessAuth);
		// 如果权限在容器，需要判断当前用户的权限与资源权限是否匹配
		// 先判断用户是否登录（通过Session）
		HttpSession httpSession = request.getSession(false);
		if(httpSession == null){
			// 会话已失效或未曾登录过，重定向到登录页
			log.debug(" 会话已失效或未曾登录过，重定向到登录页");
			response.sendRedirect("http://localhost:8080/mm/login.html");
			return;
		}
		// Session在，获取Session中的用户
		User user = (User) httpSession.getAttribute(SESSION_KEY_USER);
		// 获取当前用户的权限列表，与资源权限进行匹配
		log.debug("获取当前用户的权限列表，与资源权限进行匹配");
		final List<String> userAuthList = user.getAuthorityList();
		log.debug("获取当前用户的权限列表:userAuthList:{}",userAuthList);
		log.debug("当前访问资源:{},需要的权限:{}",reqPath,accessAuth);
		// accessAuth (ROLE_ADMIN,ROLE_QUESTION_RECORDER)
		String[] accessAuthArrays = accessAuth.split(",");
		boolean isAuthed = false;
		// 遍历资源的权限列表，每个与用户权限进行匹配
		for (String tmpAuth :accessAuthArrays){
			// ROLE_ADMIN
			if(userAuthList.contains(tmpAuth)){
				// 匹配
				isAuthed = true;
				break;
			}
		}
		if(isAuthed){
			// 放行
			log.debug("当前访问资源与用户权限匹配，放行....");
			filterChain.doFilter(request,response);
		}else{
			response.getWriter().write("权限不足，请切换用户！！！");
		}
	}

	@Override
	public void destroy() {
		log.debug("HmSecurityFilter.destroy...");
		// 释放资源
	}

	/**
	 * 解析XML
	 * @param filePath
	 */
	private void parseSecurityXML(String filePath){
		log.debug("HmSecurityFilter.init...解析XML:{}",filePath);
		// XML解析
		try{
			// 加载XML文件输入流
			InputStream resourceAsStream = this.getClass().getResourceAsStream(filePath);
			// 构建Document对象
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(resourceAsStream);
			// 利用XPath表达式搜索Node，通过Node获取元素(Element)
			// 获取页面中所有的Security节点
			List<Node> listNode = document.selectNodes("//" + HmSecurityConst.TAG_SECURITY);
			// 遍历节点
			for (Node node:listNode){
				Element element = (Element)node;
				// 元素，属性和值
				String accessPath = element.attribute(HmSecurityConst.TAG_SECURITY_ATTR_PATTERN).getStringValue();
				String accessRole = element.attribute(HmSecurityConst.TAG_SECURITY_ATTR_HAS_ROLE).getStringValue();
				log.debug("accessPath:{},accessRole:{}",accessPath,accessRole);
				// 把资源与权限关系存入容器
				authMaps.put(accessPath,accessRole);
			}
			// 解析包名
			Node node = document.selectSingleNode("//" + HmSecurityConst.TAG_SCAN);
			Element element = (Element)node;

			// 读取包名
			basePackage = element.attribute(HmSecurityConst.TAG_SCAN__PACKAGE).getStringValue();

		}catch(Exception e){
		    e.printStackTrace();
		}
	}

	/**
	 * 解析自定义注解
	 */
	private void parseAnno(){
		log.debug("HmSecurityFilter.init...解析注解,包:{}",basePackage);
		// 利用工具类扫包
		List<Class<?>> classsFromPackage = HmClassScanner.getClasssFromPackage(basePackage);
		// 遍历类
		for (Class clazz:classsFromPackage){
			// 判断类是否使用了HmComponent注解
			if(clazz.isAnnotationPresent(HmComponent.class)){
				// 获取类中所有的方法
				Method[] methods = clazz.getMethods();
				// 遍历方法，寻找注解
				for (Method method:methods){
					// 寻找权限注解
					if(method.isAnnotationPresent(Hmthority.class)){
						// 获取权限值
						// COURSE_LIST
						String accessAuth = method.getAnnotation(Hmthority.class).value();
						String accessPath = method.getAnnotation(HmRequestMapping.class).value();
						// 存入权限容器
						authMaps.put(accessPath,accessAuth);
					}
				}
			}
		}

	}
}
