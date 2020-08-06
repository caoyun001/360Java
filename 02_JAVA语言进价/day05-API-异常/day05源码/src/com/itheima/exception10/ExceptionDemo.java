package com.itheima.exception10;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *  异常分类:
 *    编译异常:
 *      非RuntimeException,或者非他的子类
 *      都是编译异常
 *      特点: 调用了一个抛出编译异常的方法
 *       sdf.parse("");编译异常,调用者必须处理,否则编译失败
 *       处理: try catch , throws
 *
 *    运行异常:
 *     RuntimeException或者是他的子类
 *     都是运行异常:
 *     特点: 调用了一个抛出运行异常的方法,不能处理的
 *     一旦发生运行异常,程序人员修改代码
 *
 *     方法中手动抛出异常 throw new 运行异常()
 *     方法的定义上,可以不写throws
 *
 *     常见的四大运行异常:
 *       越界异常,空指针,类型转换,无效参数异常 IllegalArgumentException
 */
public class ExceptionDemo {
    public static void main(String[] args)   {
      int a =   Integer.parseInt("1a23");

    }

}
