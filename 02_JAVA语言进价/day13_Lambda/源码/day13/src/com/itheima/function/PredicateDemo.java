package com.itheima.function;

import java.util.function.Predicate;

/**
 *  java.util.function.Predicate 接口
 *  抽象方法:
 *    Predicate<String>
 *    boolean test(String t);
 */
public class PredicateDemo {
    public static void main(String[] args) {
       boolean b =  getBoolean( (s)->s.length()>5  ,"Hello" );
        System.out.println(b);
    }
    /**
     * lambda表达式,判断字符串长度是否大于5,返回true
     */
    public static boolean getBoolean(Predicate<String> predicate,String str){
        return predicate.test(str);
    }
}
