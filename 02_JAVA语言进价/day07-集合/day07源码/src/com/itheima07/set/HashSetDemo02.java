package com.itheima.set;

import com.itheima.domain.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet集合存储自定义对象 Person
 * 要求:
 *   Person对象中,姓名和年龄是相同的
 *   认为是同一个对象
 *
 *  实现要求:
 *    哈希表判断元素是否相同: hashCode()和equals()方法
 */
public class HashSetDemo02 {
    public static void main(String[] args) {

        System.out.println(1<<30);

        Set<Person> set = new HashSet<Person>();
        set.add(new Person("zhangsan",21));
        set.add(new Person("lisi",25));
        set.add(new Person("lisi",25));
        set.add(new Person("wangwu",22));
        set.add(new Person("zhaoliu",23));
        for(Person p : set){
            System.out.println(p);
        }

    }
}
