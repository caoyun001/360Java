package com.itheima.polymorphism07;

/**
 * 运动员类:
 *   姓名和年龄
 *   比赛的抽象方法
 */
public abstract class Sport {
    private String name;
    private int age;

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

    public abstract void sport();
}
