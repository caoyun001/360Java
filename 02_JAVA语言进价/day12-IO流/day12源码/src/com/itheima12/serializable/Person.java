package com.itheima.serializable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  java.io.Serializable接口
 *  实现此接口,可以开启序列化和反序列化功能
 *
 *  关键字: 瞬态  transient  阻止变量被序列化
 *
 *  自定义序列号,如果自己定义了,javac编译的时候,不写了
 */
public class Person implements Serializable{
    private String name;
    public       int age;

    static final long serialVersionUID = 100L;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
