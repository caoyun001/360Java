package com.itheima.generic04;

/**
 *  实现接口,不明确泛型
 *  泛型指定全,交给调用者
 */
public class InterImpl<T> implements InterFace <T>{
    public void show(T t){
        System.out.println(t);
    }
}
