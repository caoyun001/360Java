package com.itheima.static06;

/**
 * 静态导入:
 *   导入包的基础之上进行改进
 *   目的是让我们减少代码的书写
 *   语法: import static 写到类的静态成员
 *   弊端: 同名的方法,静态导入失效
 */
import static java.lang.System.out;
import static com.itheima.util.PrintString.printString;
public class StaticDemo {
    public static void main(String[] args) {
        printString("hello");
    }

    public static void printString(String s){
        System.out.println(s+"===");
    }
}
