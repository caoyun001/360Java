package com.itheima.generic06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  需求:
 *    老师类:
 *      姓名,年龄,工作的方法
 *    班主任类:
 *      姓名,年龄,工作的方法
 *
 *    共性抽取: 老师类和班主任类的共性抽取到一个父类中 Employee
 */
public class GenericDemo {
    public static void main(String[] args) {
        //定义集合,存储老师对象和班主任对象
        List<Teacher> teacherList = new ArrayList<Teacher>();
        Teacher t1 = new Teacher();
        t1.setName("刚哥");
        t1.setAge(29);

        Teacher t2 = new Teacher();
        t2.setName("松哥");
        t2.setAge(35);

        teacherList.add(t1);
        teacherList.add(t2);

        List<Manager> managerList = new ArrayList<Manager>();
        Manager m1 = new Manager();
        m1.setName("丹姐");
        m1.setAge(30);

        Manager m2 = new Manager();
        m2.setName("琳姐");
        m2.setAge(40);

        managerList.add(m1);
        managerList.add(m2);

        iterator(teacherList);
        iterator(managerList);

    }
    /**
     * 定义一个方法,同时遍历2个集合
     * 老师集合和班主任集合
     * 迭代器遍历的同时,调用老师和班主任的方法work
     * 不能强制转换
     * 多态性: 父类和子类的多态性
     * Employee emp = new 老师()
     * Employee emp = new 班主任()
     * 迭代器的方法next()返回不能是Object,是Employee
     * 子类 extends 父类
     * 子类不确定是哪个,只能使用通配符号
     *
     * ? extends  Employee 上限限定
     *   可以传递Employee类型,和他的所有子类类型
     *
     * ? super Employee    下限限定
     *   可以传递Employee类型,和他的父类,爷爷类
     *
     * */
    public static void iterator(List<? extends    Employee> list ){
        Iterator<? extends   Employee> it = list.iterator();
        while (it.hasNext()){
            //取出元素, next()返回的是什么类型
           Employee employee =  it.next();
           employee.work();
        }
    }
}
