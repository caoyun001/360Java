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
import static com.itheima.mm.security.HmSecurityConst.CONFIG_SECURITYCONFIGLOCATION;

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
		// 读取配置文件的参数，调用配置文件解析
		String filePath = filterConfig.getInitParameter(CONFIG_SECURITYCONFIGLOCATION);
		parseConfig(filePath);
		// 读取类中的方法注解权限配置
		parseAnnotation();
		log.info("basePackage:{},accessPathAuthMaps:{}",basePackage,accessPathAuthMaps);
	}
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
			log.debug("ServletContextName:{},path:{} ",request.getServletContext().getServletContextName(),
				request.getContextPath());
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
	/**
	 * 读取解析配置文件
	 * @param filePath
	 */
	public void parseConfig(String filePath){
		//加载配置文件(约定配置文件存放在类加载路径下)
		if(!filePath.startsWith("/")){
			filePath = "/".concat(filePath);
		}
		InputStream resourceAsStream =  HmSecurityFilter.class.getResourceAsStream(filePath);
		try{
			// 解析XML，获取资源访问权限路径
			SAXReader reader = new SAXReader();
			Document document = reader.read(resourceAsStream);
			// 获取security节点
			List<Node> nodeList = document.selectNodes("//"+HmSecurityConst.TAG_SECURITY);
			// 读取当前标签pattern has_role 属性
			for (Node node:nodeList){
				Element element = (Element)node;
				String accessPath = element.attribute(HmSecurityConst.TAG_SECURITY_ATTR_PATTERN).getStringValue();
				String accessRole = element.attribute(HmSecurityConst.TAG_SECURITY_ATTR_HAS_ROLE).getStringValue();
				accessPathAuthMaps.put(accessPath,accessRole);
			}
			// 读取scan节点
			Node nodeScan = document.selectSingleNode("//"+HmSecurityConst.TAG_SCAN);
			if(nodeScan!=null){
				Element element = (Element)nodeScan;
				basePackage = element.attribute(HmSecurityConst.TAG_SCAN__PACKAGE).getStringValue();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 从注解实例中，获取注解的权限配置
	 */
	public void parseAnnotation(){
		List<Class<?>> classsFromPackage = HmClassScanner.getClasssFromPackage(basePackage);
		//遍历类，检查是否使用的@Component注解
		if(null == classsFromPackage || classsFromPackage.size() == 0){
			log.debug("parseBeans... basePackage:{} is null.",basePackage);
			return;
		}
		for (Class<?> aClass : classsFromPackage) {
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
	}
}
