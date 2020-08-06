package com.itheima.our;

/**
 * 自定义注解:
 *   定义类,关键字 class
 *   定义接口,关键字 interface
 *   定义注解,关键字 @interface  annotation
 *
 *  JDK5新增关键字  @interface
 *  版本兼容性, 产生新的关键字,以前程序不稳定
 *
 *  注解编译后class文件
 *
 *  注解成员定义:
 *    注解中成员,称为注解的属性
 *    固定格式:
 *      数据类型  属性名() [default 默认值];
 *
 *    数据类型要求:
 *       属性的数据类型,可以是基本类型(8个),String
 *       枚举类型(enum), Class类型,其他注解类型
 *       以上的数据类型是允许的,包含了以上类型的一维数组
 */
public @interface MyAnnotation {
    String name() ;

    int age();
}
