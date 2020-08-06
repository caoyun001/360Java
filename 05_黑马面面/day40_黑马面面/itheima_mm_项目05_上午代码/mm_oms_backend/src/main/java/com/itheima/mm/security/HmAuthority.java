package com.itheima.mm.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description ：方法注解，声明方法具体权限内容
 * @version: 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HmAuthority {
	String value();
}
