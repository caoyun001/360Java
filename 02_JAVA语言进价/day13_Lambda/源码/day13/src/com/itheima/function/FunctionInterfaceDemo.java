package com.itheima.function;

import java.util.function.Function;

/**
 *  java.util.function.Function<T,R>接口
 *  抽象方法 R apply(T t);  参数是T类型,返回值是R
 *  传递的参数是T,返回值是R
 *  Functions<String,Integer> 方法参数是String,返回值是Integer
 */
public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        int integer = getInteger( s-> Integer.parseInt(s),  "333");
        System.out.println(integer+333);
    }

    /**
     * 接口Functions实现功能
     * 传递字符串,转成基本类型int
     */
    public static Integer getInteger( Function<String,Integer> function,String str ){
       Integer integer =  function.apply(str);
       return integer;
    }
}
