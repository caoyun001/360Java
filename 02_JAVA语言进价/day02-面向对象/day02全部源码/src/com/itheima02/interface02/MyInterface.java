package com.itheima.interface02;

/**
 *  JDK1.7及以前版本的接口定义
 *  接口成员:
 *    成员变量 : 固定修饰符  public static final  数据类型 变量名 = 值; (常量)
 *    成员方法 : 固定修饰符  public abstract 返回值 方法名(参数列表);
 *
 *  接口中成员固定修饰符, 可以不写,但是你写和不写没有区别
 *  javac编译,检测成员修饰符,如果不写, javac帮你写
 */
public interface MyInterface {
    //定义成员变量,常量
    //常量的命名规则:全部大写字母
    public static final  int A = 1;

    //定义成员方法
    public abstract void inter();
}
