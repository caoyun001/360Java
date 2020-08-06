package com.itheima.exception01;

/**
 * 异常:
 *   程序运行中出现的不正常现象,称为异常
 *   空指针,数组越界,类型转换
 *   面向对象的语言,任何事物都是对象,异常也是对象
 *   对象是类产生的,异常类
 *   出现异常导致JVM终止
 *
 *  异常的继承体系:
 *    java.lang.Throwable 是所有异常和错误的父类
 *      子类 : Error  所有错误的父类
 *        所有的错误的类名都是以Error结尾
 *        错误是程序中出现了严重问题,不修改源代码,不能执行
 *        人: 严重的疾病,不换器官就完了
 *
 *      子类 : Exception  所有异常的父类
 *        所有的异常的类名都是以Exception结尾
 *        程序中出现了一般性问题,处理掉,可以继续执行
 *
 *      Exception有2个孩子
 *        RuntimeException : 运行异常
 *        非RuntimeException : 编译异常
 *
 *    Throwable类的方法: 所有的子类都具备
 *    1: String getMessage() 返回异常信息,详细信息
 *    2: String toString() 返回异常信息,简短信息
 *    3: void printStackTrace() 异常信息,追踪到标准错误流 (日志)
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(args[5]);
    }

}
