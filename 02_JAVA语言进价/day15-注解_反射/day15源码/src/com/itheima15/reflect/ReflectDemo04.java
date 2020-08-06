package com.itheima.reflect;

/**
 * 反射案例3:
 *   反射获取Student类的无参数构造方法执行
 *   使用简单的方式,减少代码量
 *
 *   但是前提:
 *     被反射的类,必须具有public权限的无参数构造
 */
public class ReflectDemo04 {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("com.itheima.reflect.Student");
        //Class类中,定义方法 Object newInstance() 运行无参数构造,创建对象
        Object object = c.newInstance();
        System.out.println(object);
    }
}
