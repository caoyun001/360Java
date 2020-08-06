package com.itheima.object01;

public class Person {
    private String name;
    private int age;

    public  Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    /**
     * 重写父类Object的方法toString()
     * 要求返回字符串
     * toString()价值: 返回类中的成员变量值
     */
    public String toString(){
        return  "Person "+name+"..."+age;
    }
}
