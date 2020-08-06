package com.itheima.interface04;

/**
 *  接口实现,是对继承的改良
 *  继承是单继承方式,一个类只能继承一个类
 *  一个类可以同时实现多个接口,接口的多实现
 *
 *  语法格式: class类  implements 接口1,接口2,接口3{
 *
 *  }
 *  实现类,重写所有接口的抽象方法
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        //创建的是接口A和B的实现类,C类的对象
        C c = new C();
        c.a();
        c.b();
    }
}
