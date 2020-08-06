package com.itheima.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * java.util.Set接口 (单列的集合)
 *   继承Collection接口
 *
 *  Set集合: 不包含重复的元素
 *  没有索引
 *  Set接口的实现类  HashSet, LinkedHashSet
 *
 *  Set接口中的抽象方法,和他的父接口Collection完全一样
 */
public class SetDemo {
    public static void main(String[] args) {
        //Set集合存储字符串,遍历
        Set<String> set = new HashSet<String>();
        set.add("i");
        set.add("love");
        set.add("you");
        set.add("java");
        set.add("money");

        //set集合遍历,迭代器
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(  it.next());
        }
        System.out.println("==========");
        //set集合遍历,增强for
        for(String s : set){
            System.out.println(s);
        }
    }
}













