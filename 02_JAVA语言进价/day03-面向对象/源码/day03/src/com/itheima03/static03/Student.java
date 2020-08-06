package com.itheima.static03;

public class Student {
    private String name;
    private int age;
    private static String school = "黑马程序员";

    public static void eat(){
        System.out.println("学生在吃饭" );
    }

    public void sleep(){
        System.out.println("学生在睡觉"+name+school);
    }
}
