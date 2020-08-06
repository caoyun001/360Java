package com.itheima.noname01;

public interface MyInterface {
    public abstract void inter();
}

//定义出接口的实现类
class MyInterfaceImpl implements MyInterface{
    public void inter() {
        System.out.println("实现类重写方法");
    }
}