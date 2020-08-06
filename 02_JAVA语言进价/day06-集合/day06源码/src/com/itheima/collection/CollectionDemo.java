package com.itheima.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 单列集合中的根接口: java.util.Collection
 * 一切单列集合都是他的子(子接口,实现类)!!
 * 接口中的抽象方法: 所有的子都具备的
 * 学习顶层接口,创建最底层的实现类对象
 */
public class CollectionDemo {
    public static void main(String[] args) {
        method_5();
    }
    /**
     * Collection接口方法
     * Object[]  toArray()
     * 集合中的元素转成数组
     */
    public static void method_5(){
        //创建集合对象,多态性
        Collection<String> coll = new ArrayList<String>();
        //集合方法add存储
        coll.add("love");
        coll.add("i");
        coll.add("love");
        coll.add("java");
        //集合中的元素转成数组
        Object[] objects =  coll.toArray();
        for(int i = 0 ; i < objects.length ; i++){
            System.out.println(objects[i]);
        }
    }

    /**
     * Collection接口方法
     * boolean remove(Object obj)
     * 移除集合中的元素,和参数相同的元素被移除
     * 移除成功,返回true
     * 出现相同的元素,删除最前遇到的
     *
     * E remove(int index)按照索引移除,返回被移除前的元素
     */
    public static void method_4(){
        //创建集合对象,多态性
        Collection<String> coll = new ArrayList<String>();
        //集合方法add存储
        coll.add("love");
        coll.add("i");
        coll.add("love");
        coll.add("java");
        System.out.println(coll);
        //移除元素love
        boolean b =  coll.remove("love");
        System.out.println(b);
        System.out.println(coll);
    }

    /**
     * Collection接口方法
     * boolean isEmpty()
     * 判断集合是不是空的,如果是空的,返回true
     * 空的,集合没元素,长度为0,就是true
     */
    public static void method_3(){
        //创建集合对象,多态性
        Collection<String> coll = new ArrayList<String>();
        //集合方法add存储
        coll.add("i");
        coll.add("love");
        coll.add("java");
        System.out.println(coll);
        //清空集合
        coll.clear();
        //判断集合是否是空的
        boolean b = coll.isEmpty();
        System.out.println(b);
    }

    /**
     * Collection接口的方法
     * boolean contains(Object obj)
     * 判断元素是否在集合中包含,如果存在返回true
     */
    public static void method_2(){
        //创建集合对象,多态性
        Collection<String> coll = new ArrayList<String>();
        //集合方法add存储
        coll.add("i");
        coll.add("love");
        coll.add("java");
        System.out.println(coll);
        //集合方法contains()判断love元素是否在集合中
        boolean b = coll.contains("love");
        System.out.println(b);
    }

    /**
     * Collection接口中的方法
     * void clear()清空集合中的元素
     * Collection是接口,创建实现类对象(ArrayList)
     */
    public static void method(){
        //创建集合对象,多态性
        Collection<String> coll = new ArrayList<String>();
        //集合方法add存储
        coll.add("i");
        coll.add("love");
        coll.add("java");
        System.out.println(coll);
        //集合方法clear()清空集合
        //集合中的元素,容器本身可以继续使用
        coll.clear();
        System.out.println(coll);
    }
}
