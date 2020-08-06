package com.itheima.exception11;

/**
 * 自定义的,负数异常
 * 构造方法,接收异常的信息
 * 信息打印在控制台上
 *
 * Exception构造方法,可以传递字符串
 * 构建出新的异常对象
 *
 * FuShuException子类,Exception是父类
 */
public class FuShuException extends Exception{
    public FuShuException(String s){
        //子类构造方法,调用父类构造方法
        super(s);
    }
}
