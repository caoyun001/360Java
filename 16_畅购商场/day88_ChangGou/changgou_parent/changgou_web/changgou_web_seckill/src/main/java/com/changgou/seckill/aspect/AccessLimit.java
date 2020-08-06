package com.changgou.seckill.aspect;

import java.lang.annotation.*;

/**
 * 自定义限流注解
 */
@Inherited
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {}
