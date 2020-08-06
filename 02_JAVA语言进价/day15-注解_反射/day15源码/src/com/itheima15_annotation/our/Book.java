package com.itheima.our;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义的注解 Book
 * 定义属性
 *
 * JDK的元注解,比喻注解的总管
 * 管理其他的注解
 *
 * 元注解对我们的注解进行控制
 * 1: 控制我们的注解,可以写在哪里,(类,方法,变量上,包...)
 * 2: 控制我们的注解的生命周期
 *
 * JDK的2个元注解
 *
 * @Target  指示其他注解,出现的位置
 *    ElementType[] value(); 数组,可以赋值多个
 *    ElementType是数据类型,是枚举
 *    枚举的属性,都是静态修饰,直接类名调用
 *      TYPE, 其他注解可以写在类上
 *      FIELD,其他注解可以写在成员变量
 *      METHOD,其他注解可以写在方法上
 *      PARAMETER,其他注解可以写在方法参数上
 *      CONSTRUCTOR,其他注解可以写在构造方法上
 *
 *  @Retention 指示其他注解的生命周期
 *     RetentionPolicy value(); 不是数组,赋值一个
 *     RetentionPolicy数据类型
 *     枚举的属性,都是静态修饰,直接类名调用
 *     CLASS  注解存在于编译后的class文件中
 *     SOURCE 注解仅存在于源码中java文件中
 *     RUNTIME 运行时期的内存中
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Book {
    //书名
    String bookName();
    //价格
    double price() ;
    //作者
    String[] author();
}
