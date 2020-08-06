package com.itheima.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/9
 * @description ：类注解，实例化类对象
 * @version: 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HmComponent {
    String value() default "";
}
