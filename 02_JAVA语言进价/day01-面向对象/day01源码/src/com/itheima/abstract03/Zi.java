package com.itheima.abstract03;

/**
 *  如果子类继承了一个抽象类,子类只重写了一部分抽象方法
 *  这个时候,子类依然还是一个抽象类
 */
public abstract   class Zi extends Fu {
    public void show(){
        System.out.println("重写方法show...");
    }
}
