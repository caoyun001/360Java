package com.itheima.mm.security;


import com.itheima.framework.annotation.HmClassScanner;
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
 * @date ：Created in 2019/8/12
 * @description ：
 * @version: 1.0
 */
@Slf4j
public class HmSecurityFilter implements Filter {
	// 存储访问路径映射权限列表
	private Map<String, String> accessPathAuthMaps = new HashMap<>();
	// 注解解析扫描类根包
	private String basePackage = "";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 初始化配置
		log.info("security init....");
		String filePath = filterConfig.getInitParameter(HmSecurityConst.CONFIG_SECURITYCONFIGLOCATION);
		log.info("security parseConfig....{}",filePath);
		// 解析配置文件
		parseConfig(filePath);
		// 解析注解
		parseAnnotation();
	}
/*
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		log.info("security doFilter....");
		filterChain.doFilter(servletRequest,servletResponse);
		HttpServletRequest request = ((HttpServletRequest)servletRequest);
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// 解析请求地址
		String requestURI = request.getRequestURI(); //例如：/mm/pages/xxx.html
		// 获得当前web应用的名称
		String contextPath = request.getContextPath();//例如：/mm
		// 截取需要的Web资源名称
		String accessPath = requestURI.substring(contextPath.length()); // pages/xxx.html
		// 获取URL路径，比如http://localhost:8080/mm/course/findListAll.do，去掉访问路径和资源后缀
		// http://localhost:8080/mm/
		String accessUrl = request.getRequestURL().toString().replace(accessPath,"");
		// 如果是.do结尾，直接去.do
		if(accessPath.endsWith(".do")){
			accessPath = accessPath.replaceAll(".do","");
		}
		log.debug("accessPath:{},accessPathAuthMaps:{}",accessPath,accessPathAuthMaps);
		// 如果访问路径不在授权列表，直接放行通过
		if(!accessPathAuthMaps.containsKey(accessPath)){
			log.debug("该资源可以放行....{}",accessPath);
			filterChain.doFilter(servletRequest,servletResponse);
			return;
		}
		// 如果在授权访问列表，获取该资源的授权信息,然后与用户权限进行匹配
		// 获取资源权限信息
		String authString = accessPathAuthMaps.get(accessPath);
		// 如果授权信息可能包含多个，需要按","切割为字符串数组，后续与用户权限列表进行比对
		String[] authArray  = authString.split(",");

		// 获取当前用户的授权信息
		HttpSession httpSession = request.getSession(false);
		if (httpSession == null || httpSession.getAttribute(SESSION_KEY_USER) == null){
			// 会话不在或失效，即为认证失败,需重定向到登录页面
			log.debug("会话失效:{}",accessUrl+"/login.html");
			response.sendRedirect(accessUrl+"/login.html");
			return;
		}
		User user  = (User)httpSession.getAttribute(SESSION_KEY_USER);
		// 当前资源权限列表与用户权限列表进行匹配，如果匹配上，即为有权限，否则为无权限
		boolean isAuthed = false;
		for (String auth:authArray){
			if(user.getAuthorityList().contains(auth)){
				// 当前用户有权限访问
				isAuthed = true;
				break;
			}
		}
		log.debug("isAuthed:{}",isAuthed);
		if(isAuthed){
			// 有权访问，继续执行
			log.debug("有权访问，继续执行:{}",authArray);
			filterChain.doFilter(request,response);
		}else{
			// 无权权限访问，告知用户
			log.debug("无权权限访问:{}",authArray);
			response.getWriter().println("当前用户无权限，请切换用户！");
		}
	}
*/
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
		throws IOException, ServletException {
		// 权限验证
		log.info("security doFilter....");
		HttpServletRequest request = ((HttpServletRequest)servletRequest);
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// 解析请求地址
		String requestURI = request.getRequestURI(); //例如：/mm/pages/xxx.html
		// 获得当前web应用的名称
		String contextPath = request.getContextPath();//例如：/mm
		// 截取我们需要的web资源的名称  即：去掉扩展名 和 web应用名称
		String accessPath = requestURI.substring(contextPath.length()); //例如：/pages/xxx.html
		String accessUrl = request.getRequestURL().toString().replace(accessPath,"");
		// 如果是.do结尾，直接去.do
		if(accessPath.endsWith(".do")){
			accessPath = accessPath.replaceAll(".do","");
		}
		// 如果访问路径不在授权列表，直接放行通过
		if(!accessPathAuthMaps.containsKey(accessPath)){
			filterChain.doFilter(servletRequest,servletResponse);
			return;
		}
		// 如果在授权访问列表，获取该资源的授权信息
		String authString = accessPathAuthMaps.get(accessPath);
		// 获取当前用户的授权信息
		HttpSession httpSession = request.getSession(false);
		if (httpSession == null || httpSession.getAttribute(SESSION_KEY_USER) == null){
			// 登录失败
			response.sendRedirect(accessUrl+"/login.html");
			return;
		}
		// 判断session中的用户是否有权限访问资源
		// 获取访问当前资源的权限内容，如果有,说明有多个权限
		User user  = (User)httpSession.getAttribute(SESSION_KEY_USER);
		boolean isAuthed = false;
		if(authString.contains(",")){
			String[] auths = authString.split(",");
			for (String auth:auths){
				if(user.getAuthorityList().contains(auth)){
					// 当前用户有权限访问
					isAuthed = true;
					break;
				}
			}
		}else if(user.getAuthorityList().contains(authString)){
			// 当前用户有权限访问
			isAuthed = true;
		}
		if(isAuthed){
			// 有权访问，继续执行
			filterChain.doFilter(request,response);
		}else{
			// 授权失败
			response.getWriter().println("当前用户无权限，请切换用户！");
		}
	}
	@Override
	public void destroy() {
		log.info("security destroy....");
	}

	public void parseConfig(String filePath){
		//加载配置文件(约定配置文件存放在类加载路径下)
		if(!filePath.startsWith("/")){
			filePath = "/".concat(filePath);
		}
		// 获取文件输入流
		InputStream resourceAsStream =  HmSecurityFilter.class.getResourceAsStream(filePath);
		try{
			// 解析XML，获取资源访问权限路径
			SAXReader reader = new SAXReader();
			Document document = reader.read(resourceAsStream);
			// 获取security节点，通过XPath表达式语法获取元素
				List<Node> nodeList = document.selectNodes("//"+HmSecurityConst.TAG_SECURITY);
			// 读取当前标签pattern has_role 属性
			for (Node node:nodeList){
				Element element = (Element)node;
				String accessPath = element.attribute(HmSecurityConst.TAG_SECURITY_ATTR_PATTERN).getStringValue();
				String accessRole = element.attribute(HmSecurityConst.TAG_SECURITY_ATTR_HAS_ROLE).getStringValue();
				accessPathAuthMaps.put(accessPath,accessRole);
			}
			// 读取Scan
			Node nodeScan = document.selectSingleNode("//"+HmSecurityConst.TAG_SCAN);
			if (nodeScan != null){
				Element element = (Element)nodeScan;
				basePackage = element.attribute(HmSecurityConst.TAG_SCAN__PACKAGE).getStringValue();
			}
			log.debug("basePackage:{},accessPathAuthMaps:{}",basePackage,accessPathAuthMaps);
		}catch(Exception e){
		    e.printStackTrace();
		}
	}

	public void parseAnnotation(){
		List<Class<?>> classsFromPackage = HmClassScanner.getClasssFromPackage(basePackage);
		//遍历类，检查是否使用的@Component注解
		if(null == classsFromPackage || classsFromPackage.size() == 0){
			log.debug("parseBeans... basePackage:{} is null.",basePackage);
			return;
		}
		for (Class<?> aClass:classsFromPackage){
			Method[] methods = aClass.getMethods();
			for (Method method:methods){
				// 读取bean的HmRequestMapping注解
				// 读取bean的MmAuthority注解
				if(method.isAnnotationPresent(HmAuthority.class)){
					String accessPath = method.getAnnotation(HmRequestMapping.class).value();
					String authority = method.getAnnotation(HmAuthority.class).value();
					accessPathAuthMaps.put(accessPath,authority);
				}
			}
		}
		log.debug("accessPathAuthMaps:{}",accessPathAuthMaps);
	}
}
