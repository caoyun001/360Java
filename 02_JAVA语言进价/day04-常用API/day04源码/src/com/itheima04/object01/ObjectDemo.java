package com.itheima.object01;

/**
 *  java.lang包下的类Object
 *  所有类的父类,任何类都直接或者间接继承Object
 *  class A extends Object{}
 *
 *  class A extends B{}
 *
 *  class B extends Object{}
 *  Object类定义的成员方法,任何类都是直接使用
 *
 *  Object类有构造方法吗? 有
 *  构造方法的第一行是super()吗,肯定不是
 *
 *  Object类源码:
 *     private static native void registerNatives();
 *     native修饰符,本地
 *        方法的源代码根本就不是Java语言的编写,C++语言编写
 *        运行时期在一个特殊的内存区域,本地方法栈
 *        意义: 在和操作系统进行交互 (Windows)
 *     没有方法体
 *
 *     static {
            registerNatives();
        }
       JVM注册在本地的操作系统上
 */
public class ObjectDemo extends Object{
    public static void main(String[] args) {

    }
}