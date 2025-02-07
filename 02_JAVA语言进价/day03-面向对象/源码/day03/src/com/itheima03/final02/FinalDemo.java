package com.itheima.final02;

/**
 * final修饰成员变量
 *   成员变量具有默认值
 *   字符串,默认null
 *   int,默认是0
 *
 *   final修饰成员变量,固定的不是默认值
 *   固定的是我们自己赋的值
 *
 *   成员变量的赋值方式
 *     1: 直接=赋值
 *     2: 构造方法
 *     3: set方法
 *
 *    set方法,可以调多次,
 *    构造方法,在new的时候,只能调用一次
 *
 *    深入:
 *      成员变量属于对象, 内存跟随对象在堆中存储
 *      一旦对象创建完毕了,成员变量的值也要确定了
 *
 *      set方法是创建对象后的事情,用对象.set()
 */
public class FinalDemo {
}
