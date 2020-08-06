package com.itheima.interface03;

/**
 * 接口的使用方式:
 *   1. 接口不能实例化对象,不能new对象
 *   2. 需要定义类实现接口 (继承)
 *     实现接口的关键字 implements
 *   3. 重写接口中的抽象方法
 *   4. 创建实现类的对象
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        //创建接口实现类的对象
        MyInterfaceImpl my = new MyInterfaceImpl();
        my.inter();
    }
}
