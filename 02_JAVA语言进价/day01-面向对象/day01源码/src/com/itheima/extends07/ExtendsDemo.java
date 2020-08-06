package com.itheima.extends07;
/**
 *  super()调用父类的构造方法演示
 *
 *  Student是Person的子类
 */
public class ExtendsDemo {
    public static void main(String[] args) {
        Student student = new Student("王五");
        //student.setName("张三");
        System.out.println(student.getName());
    }
}
