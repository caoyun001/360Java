package com.itheima.static01;

/**
 * static修饰符,静态
 * 主方法就是静态修饰
 * 方法的定义,加上static
 *
 * 静态的成员,多了一种调用方式
 * 类名.静态成员
 *
 * 非静态成员只能被对象调用
 * 静态成员可以被类名调用,也能被对象调用
 * 强制使用类名调用
 */
public class StaticDemo {
    public static void main(String[] args) {
        //直接使用类名调用静态成员school
        System.out.println(Student.school);

        //创建Student对象
        Student s1 = new Student();
        s1.name = "张三";
        s1.age = 20;

        Student s2 = new Student();
        s2.name = "李四";
        s2.age = 21;
        s1.school = "白马程序员";
        System.out.println(s2.school);

    }
}
