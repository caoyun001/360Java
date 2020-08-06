package com.itheima.oop;

public class Person {
    //人的共性属性
    private String name;
    private int age;

    //构造方法，创建对象的时候，进行赋值
    public Person(){}

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    //提供get/set方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
