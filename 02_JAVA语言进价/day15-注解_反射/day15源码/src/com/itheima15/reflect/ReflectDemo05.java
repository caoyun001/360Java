package com.itheima.reflect;

import java.lang.reflect.Constructor;

/**
 *  暴力反射: 打破类的封装性
 *  反射私有执行, (不推荐使用)
 *
 *  Constructor构造方法对象
 *  Field 成员变量对象(字段)
 *  Method 成员方法对象
 *
 *  共同继承了父类 AccessibleObject
 *  父类定义方法 setAccessible(true)取消Java的运行时期的安全检查
 */
public class ReflectDemo05 {
    public static void main(String[] args)throws Exception {
        Class c = Class.forName("com.itheima.reflect.Student");
        //Class类的方法,获取Student类中的私有构造方法
        //方法名字: getDeclaredConstructor()
        Constructor con = c.getDeclaredConstructor(String.class);
        con.setAccessible(true);

        //System.out.println(con);
        Object o = con.newInstance("张三");
        System.out.println(o);
    }
}
