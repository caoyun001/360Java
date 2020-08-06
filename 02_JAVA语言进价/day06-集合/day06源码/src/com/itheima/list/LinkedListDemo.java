package com.itheima.list;

import java.util.LinkedList;

/**
 * List接口实现类LinkedList
 *   集合特点: 有序,索引,重复
 *   LinkedList集合自己特点:
 *     底层数据是双向链表
 *     查询速度慢,增删速度快
 *     线程不安全的集合,运行速度快
 *
 *  链表: 单独的操作集合的开头元素和结尾元素
 *  LinkedList集合有自己的特有功能,不能使用多态
 *
 *    addFirst()向集合的开头插入元素
 *    addLast()向集合的结尾插入元素
 *
 *    getFirst()获取集合的开头元素
 *    getLast()获取集合的结尾元素
 *
 *    removeFirst()移除并返回集合的开头元素
 *    removeLast()移除并返回集合的结尾元素
 *
 *    pop()弹出集合中的开头元素  == removeFirst();
 *    push()将元素推入集合 ==  addFirst();
 *
 *    补充:
 *      LinkedList集合添加元素,迭代器遍历, size()+get()方法遍历
 *      和ArrayList完全一样
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<String>();
        link.add("a");
        link.add("b");
        //向集合的结尾添加元素
        link.addLast("f");
        link.add("c");
        link.add("d");
        //向集合的开头添加元素
        link.addFirst("e");
        System.out.println(link);

        //获取集合的开头和结尾元素
        String first =  link.getFirst();
        String last = link.getLast();
        System.out.println(first);//e
        System.out.println(last);//d

        //移除集合的开头和结尾的元素
        //返回被移除的元素
        first =  link.removeFirst();
        last =  link.removeLast();
        System.out.println(first);
        System.out.println(last);
        System.out.println(link);
    }
}
