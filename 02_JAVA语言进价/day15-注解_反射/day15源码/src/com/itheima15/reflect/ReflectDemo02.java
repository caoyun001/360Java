package com.itheima.reflect;

import java.lang.reflect.Constructor;

/**
 * 反射技术:
 *  1:  获取一个类class文件对象,获取到Class类的对象
 *  2:  Class类的对象中的方法,获取出类的成员(构造,变量,方法)
 *  3:  运行获取出来的成员
 *
 *  反射案例1:
 *    反射解剖,Student类,获取无参数构造方法
 *    运行无参数构造 (对象创建)
 *
 */
public class ReflectDemo02 {
    public static void main(String[] args) throws Exception{
       Class c = Class.forName("com.itheima.reflect.Student");
       //获取Student类中的构造方法 Class类的方法
        //方法   Constructor[] getConstructors() 获取类中的所有公共权限的构造方法
      /* Constructor[] cons =  c.getConstructors();
       for(Constructor con : cons){
           System.out.println(con);
       }*/

      //获取Student类中的无参数构造方法?
        //Class类的方法  Constructor getConstructor(传递?构造方法的参数列表...可变)
        //不传递参数,获取的是无参数构造
        Constructor con = c.getConstructor();
       //运行构造方法,创建对象,Constructor方法  Object  newInstance(Object...a)传递实际参数
        Object object =  con.newInstance();
        System.out.println(object);
    }
}
