package com.itheima.map;

import java.util.LinkedHashMap;

/**
 * java.util.LinkedHashMap集合
 * 继承HashMap实现接口Map
 *   底层是哈希表实现, 数组+链表(双向)
 *   有序集合
 *   和父类HashMap一致
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String,String> link = new LinkedHashMap<String, String>();
        link.put("b","1");
        link.put("a","1");
        link.put("d","1");
        link.put("c","1");
        System.out.println(link);
    }
}
