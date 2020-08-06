package com.itheima.reflect;

/**
 *  反射关键对象: class文件对象
 *  类加载器创建,获取使用
 *
 *  获取Student类class文件对象
 *  是java.lang.Class类产生的对象
 *
 *  三种方法:
 *    1: 对象的方法 getClass()获取   (  getClass()定义在Object类 )
 *    2: 使用类的静态属性class获取
 *    3: Class类静态方法 forName()获取
 *
 *    三个中谁最常用  3:forName()
 *    扩展性最好  Class.forName("com.itheima.reflect.Student");参数是字符串String对象
 *    字符串未必提前写好,数据源能不能外来获取, 类名写文件中,IO读
 */
public class ReflectDemo {
    public static void main(String[] args)throws ClassNotFoundException {
        //1: 对象的方法 getClass()获取
        Student student = new Student();
        Class c1 = student.getClass();
        System.out.println(c1);

        //2: 使用类的静态属性class获取
        //每一个数据类型,基本还是引用类型, JVM赋予这个类型一个静态属性,名字就是class
        Class c2 =  Student.class;
        System.out.println(c2);  // c1==c2
        //System.out.println(c1==c2);

        //3: Class类静态方法 forName("传递字符串的类名")获取
        //注意: 字符串形式的类名,必须是全限定名 包名.类名
        Class c3 = Class.forName("com.itheima.reflect.Student");
        System.out.println(c3);
    }
}
