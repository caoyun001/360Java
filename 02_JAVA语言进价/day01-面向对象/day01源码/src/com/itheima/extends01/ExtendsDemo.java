package com.itheima.extends01;

/**
 * 继承： 类和类之间产生关系，继承关系
 * 一个类去继承另一个类，关键字 extends (延伸，扩展)
 * 语法： class 类名 extends 类
 */
public class ExtendsDemo {
    public static void main(String[] args) {
        //创建Teacher对象，创建Person的子类的对象
        Teacher teacher = new Teacher();
        //teacher对象，调研成员变量（属性）
        teacher.name = "张三";
        teacher.age = 40;
        System.out.println(teacher.name);
        System.out.println(teacher.age);
        teacher.eat();


        //创建Student对象，创建Person的子类对象
        Student student = new Student();
        student.name = "李四";
        student.age = 20;
        System.out.println(student.name);
        System.out.println(student.age);
        student.eat();
    }
}
