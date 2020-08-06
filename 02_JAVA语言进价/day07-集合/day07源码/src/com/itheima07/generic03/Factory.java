package com.itheima.generic03;

public class Factory<Q> {
    /**
     *  静态不能直接访问非静态
     *  类上的泛型,new对象的时候才指定
     *  注意: 静态方法的泛型,不能和类上相同
     *  类名直接调用,传递什么类型都可以
     */
    public static <E> void function(E e){
        System.out.println(e);
    }

    /**
     *  方法中的泛型T,没有定义
     *  T在类上是没有定义过
     *  必须对泛型T 进行定义
     *  在方法的返回值前定义
     *  调用的时候,传递什么,就是什么
     */
    public <T> void show(T t){
        System.out.println(t);
    }

    public void add(Q q){

    }
}
