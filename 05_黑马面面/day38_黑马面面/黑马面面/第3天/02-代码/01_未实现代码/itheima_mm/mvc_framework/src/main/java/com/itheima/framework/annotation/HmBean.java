package com.itheima.framework.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/9
 * @description ：存储对象信息
 * @version: 1.0
 */
@Data
@AllArgsConstructor
public class HmBean {
	private String id;//Bean在容器中的id
	private String className;//Bean的全限定名称
	private Class clazz;//Bean的类的字节码对象信息
	private Object instance;//Bean的实例对象
}
