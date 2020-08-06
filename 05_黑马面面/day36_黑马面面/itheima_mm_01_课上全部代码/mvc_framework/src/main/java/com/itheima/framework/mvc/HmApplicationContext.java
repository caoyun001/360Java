package com.itheima.framework.mvc;

import com.itheima.framework.HmException;
import com.itheima.framework.annotation.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.itheima.framework.HmConst.HM_XML_COMPONENT_SCAN_TAG;
import static com.itheima.framework.HmConst.HM_XML_SCOMPONENT_SCAN_ATTR;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/9
 * @description ：应用上下文
 *  存储注解类的实例
 *  存储注解方法的实例
 * @version: 1.0
 */
@Getter
@Slf4j
public class HmApplicationContext {

	// 定义容器，解析方法注解，存储映射地址与方法实例
	private Map<String, HmMethod> methodMaps = new HashMap<>();

	// 定义容器，解析类注解，存储bean实例
	private Map<String, HmBean> beanMaps;

	public HmApplicationContext(String path) throws HmException {
		log.debug("path:{}",path);
		if(!path.startsWith("/")){
			path = "/".concat(path);
		}
		//创建容器对象
		beanMaps = new HashMap<>();
		//加载配置文件(约定配置文件存放在类加载路径下)
		SAXReader reader = new SAXReader();
		InputStream resourceAsStream =  HmApplicationContext.class.getResourceAsStream(path);
		try{
			Document document = reader.read(resourceAsStream);
			// 自动扫包，加载类注解，并实例对象
			initBean(document);
			// 加载类中的成员数据的注解，并初始化注解内容
			this.initBeanField();
		}catch(Exception e){
		    e.printStackTrace();
		    throw new HmException("初始化上下文失败,"+e.getMessage());
		}

	}

	/**
	 * 自动扫包，加载类注解，并实例对象
	 * @param document
	 * @throws Exception
	 */
	private  void  initBean(Document document) throws Exception{
			//获得component-scan标签的基本包名称
			Node node = document.selectSingleNode("//"+HM_XML_COMPONENT_SCAN_TAG);
			if(node!=null){

				String basePackage = ((Element)node).attributeValue(HM_XML_SCOMPONENT_SCAN_ATTR);
				//调用工具ClassScanner获得该包及其子包下的字节码对象
				List<Class<?>> classsFromPackage = HmClassScanner.getClasssFromPackage(basePackage);
				//遍历看类上是否使用的@Component注解
				if(null!=classsFromPackage&&classsFromPackage.size()>0){
					for (Class<?> aClass : classsFromPackage) {
						//判断是否使用的@HmComponent注解
						if(aClass.isAnnotationPresent(HmComponent.class)){
							//获得该类上的注解对象
							HmComponent component = aClass.getAnnotation(HmComponent.class);
							//判断属性是否赋值 如果Component没有值 就赋值为当前类名
							String beanId = component.value().equals("") ? aClass.getSimpleName():component.value();
							// 创建BeanProperty存储到beanMaps中
							HmBean bean = new HmBean(beanId,aClass.getName(),aClass,aClass.newInstance());

							this.beanMaps.put(beanId,bean);
						}
					}
				}
			}
	}
	/**
	 * 读取类成员属性注解，并初始化注解
	 * @throws Exception
	 */
	private  void initBeanField() throws Exception {
		if (this.beanMaps == null || this.beanMaps.size() == 0) {
			return;
		}

		for (Map.Entry<String, HmBean> entry : this.beanMaps.entrySet()) {
			//获得HmBean对象
			HmBean hmBean = entry.getValue();
			//获得容器中Bean实例
			Object instance = hmBean.getInstance();

			//获得容器中Bean实例类的字节码对象
			Class clazz = hmBean.getClazz();
			//通过字节码对象，获取所有字段信息
			Field[] declaredFields = clazz.getDeclaredFields();
			if (declaredFields != null && declaredFields.length > 0) {
				for (Field declaredField : declaredFields) {
					//遍历使用了@HmSetter的字段
					if (declaredField.isAnnotationPresent(HmSetter.class)) {
						//获得@HmSetter注解的属性值
						String injectionBeanId = declaredField.getAnnotation(HmSetter.class).value();
						//获得容器中要被注入的Bean实例
						Object injectionBean = this.beanMaps.get(injectionBeanId).getInstance();
						//使用反射给字段复制
						//打开访问权限
						declaredField.setAccessible(true);
						declaredField.set(instance, injectionBean);
					}
				}
			}
			//通过字节码对象，获得所有的方法
			Method[] methods = clazz.getMethods();
			//判断方法上是否有@RequestMapping注解
			for (Method method : methods) {
				if(method.isAnnotationPresent(HmRequestMapping.class)){
					//获得注解属性值，即请求资源名称
					String requestPath = method.getAnnotation(HmRequestMapping.class).value();
					//创建MethodProperty实体
					HmMethod hmMethod = new HmMethod(method,clazz, instance);
					//存储到请求资源容器中
					methodMaps.put(requestPath,hmMethod);
				}
			}
		}
	}
}
