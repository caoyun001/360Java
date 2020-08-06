package com.itheima.extends02;

/**
 *  上一个例子：
 *    子类继承父类，子类可以直接使用父类的成员（变量，方法）
 *    理解为： 子类拥有了父类成员
 *    但是：不是所有的成员都能拥有 private修饰
 *
 *   继承的好处： 减少代码量，导致了另一个 多态性的产生
 *   继承的弊端： 依赖，耦合性强
 */
public class ExtendsDemo {
    public static void main(String[] args) {
        //创建Teacher类的对象，Person的子类的对象
        Teacher teacher = new Teacher();
       //teacher对象调方法get/set (方法是从父类继承的)
        teacher.setName("张三");
        teacher.setAge(40);
        System.out.println(teacher.getName());
        System.out.println(teacher.getAge());

        //创建Student类的对象，Person的子类的对象
        Student student = new Student();
        //student对象，调方法get/set (方法是从父类继承的)
        student.setName("李四");
        student.setAge(20);
        System.out.println(student.getName());
        System.out.println(student.getAge());
    }
}
