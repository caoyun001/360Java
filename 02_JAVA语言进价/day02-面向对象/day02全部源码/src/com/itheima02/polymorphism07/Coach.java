package com.itheima.polymorphism07;

/**
 * 教练员类:
 *   姓名年龄
 *   教学方法
 */
public abstract class Coach {
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

    public abstract void coach();
}
