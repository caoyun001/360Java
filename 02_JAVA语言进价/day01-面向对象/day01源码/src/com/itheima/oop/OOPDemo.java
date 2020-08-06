package com.itheima.oop;

/**
 *  面向对象技术：
 *    类： 是生活中具有共性的事物抽象（说不清）描述
 *      描述人： Person类
 *        共性属性： name,age
 *    对象： 确实存在的事物
 *      描述的人存在了，name确定，age确定
 */
public class OOPDemo {
    public static void main(String[] args) {
        //创建Person对象，无参数构造方法
        Person p1 = new Person();
        //p1对象的方法set，变量赋值
        p1.setName("张三");
        p1.setAge(20);
        //p1对象的方法get，变量获取值
        System.out.println(p1.getName());
        System.out.println(p1.getAge());

        //创建Person对象，有参数构造方法
        Person p2 = new Person("李四",22);
        //p2对象的方法get，变量获取值
        System.out.println(p2.getName());
        System.out.println(p2.getAge());
    }
}
