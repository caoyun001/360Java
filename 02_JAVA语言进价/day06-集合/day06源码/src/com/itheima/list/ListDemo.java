package com.itheima.list;

import java.util.ArrayList;
import java.util.List;

/**
 *  Collection接口的子接口List接口
 *  List接口的特点:
 *    1: 有序的集合
 *      有序,不是1,2,3 a,b,c
 *      有序,元素存储的顺序,和取出的顺序一致
 *
 *    2: 所有元素带有索引
 *
 *    3: 允许存储重复元素
 *
 *  List接口的所有实现类,都具有以上的三个特点
 *  总结六个字:
 *     有序,索引,重复
 *
 *   List接口的方法,带有索引的方法
 */
public class ListDemo {
    public static void main(String[] args) {
        method_2();
    }
    /**
     * List接口方法
     * set(int index, E element)
     * 修改集合中指定索引上的元素
     */
    public static void method_2(){
        List<String> list = new ArrayList<String>();
        list.add("i");
        list.add("love");
        list.add("java");
        list.add("money");
        System.out.println(list);
        //修改2索引上的元素,改成大写JAVA
        list.set(2,"JAVA");
        System.out.println(list);
    }

    /**
     * List接口方法
     * add(int index, E element )
     * 在List集合的指定索引上添加元素
     */
    public static void method(){
        List<String> list = new ArrayList<String>();
        list.add("i");
        list.add("love");
        list.add("java");
        list.add("money");
        System.out.println(list);
        //在集合的2索引上,添加大写JAVA
        list.add(2,"JAVA");
        System.out.println(list);
    }
}
