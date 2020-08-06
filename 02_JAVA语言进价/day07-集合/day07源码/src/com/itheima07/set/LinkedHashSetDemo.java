package com.itheima.set;

import java.util.LinkedHashSet;

/**
 * Set接口实现类,HashSet的子类
 * java.util.LinkedHashSet
 * 特点:
 *   底层是哈希表,和父类不同的是,双向链表
 *   线程不安全集合,允许速度快
 *   具有可预知迭代顺序的 Set ,有序的
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("cc");
        linkedHashSet.add("java");
        linkedHashSet.add("a");
        linkedHashSet.add("love");
        System.out.println(linkedHashSet);
    }
}
