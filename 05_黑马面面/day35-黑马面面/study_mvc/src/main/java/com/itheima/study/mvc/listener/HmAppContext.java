package com.itheima.study.mvc.listener;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/2
 * @description ：
 * @version: 1.0
 */
public class HmAppContext {
	// 存储方法映射与方法实例的容器
	public static Map<String, Method> mapMehthod = new HashMap();
}
