package com.itheima.enums;

/**
 *  Color枚举
 *  可以定义什么成员
 *  固定的修饰符 : public static final   成员名字
 *
 *  单例设计模式: 一个类对象唯一性
 *  枚举: 是一个类的多例 (多个)
 *
 *  RED 这个类Color的对象
 *
 *  枚举有构造方法,默认无参数的私有修饰
 *  如果手动定义构造方法,必须也是私有修饰,而且只能写在常量的后面
 *
 *  枚举也可以定义成员变量
 *
 *  成员变量 get/set操作
 *  构造方法传递参数,枚举的常量中传递参数
 */

public enum  Color {
    RED("红色"),GREEN("绿色"),YELLOW("黄色");

    private Color(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
