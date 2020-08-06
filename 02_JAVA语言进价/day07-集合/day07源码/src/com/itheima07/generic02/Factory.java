package com.itheima.generic02;

/**
 * 类似ArrayList定义,在类的右边加上<>
 *  定义泛型:Q 是什么数据类型
 *  在new对象的时候,才能指定
 */
public class Factory<Q> {

    private Q name;

    public Q getName() {
        return name;
    }

    public void setName(Q name) {
        this.name = name;
    }

    public void add(Q q){
        System.out.println(q);
    }
}
