package com.itheima.abstract04;

/**
 * 测试员工案例
 */
public class AbstractDemo {
    public static void main(String[] args) {
        //创建子类对象
        JavaEE javaEE = new JavaEE();
        //javaEE对象调用set方法,工号和姓名赋值 (父类的继承方法)
        javaEE.setId("研发部001");
        javaEE.setName("翠花");
        //javaEE对象调用get方法,工号和姓名取值 (父类的继承方法)
        javaEE.work();
        System.out.println(javaEE.getId()+"==="+javaEE.getName());

        //创建子类对象
        Android android = new Android();
        android.setId("研发部002");
        android.setName("翠花plus");
        android.work();
        System.out.println(android.getId()+"==="+android.getName());
    }
}
