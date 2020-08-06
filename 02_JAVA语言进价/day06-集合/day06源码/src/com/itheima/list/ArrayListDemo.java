package com.itheima.list;
import com.itheima.array.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List接口实现类ArrayList集合
 * ArrayList: 有序,索引,重复
 * ArrayList集合:
 *    底层实现是数组
 *    查询速度快,增删速度慢
 *    此集合是线程不安全集合,运行的速度快
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        //使用ArrayList集合存储自定义对象Person,遍历(迭代器)
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("李四",26));
        list.add(new Person("王五",25));
        list.add(new Person("张三",22));
        list.add(new Person("赵六",21));
        //迭代器进行遍历
        Iterator<Person> it =  list.iterator();
        while (it.hasNext()){
            Person person = it.next();
            System.out.println(person);
        }

        System.out.println("=============");
        for(int i = 0 ; i < list.size() ; i++){
            Person person  = list.get(i);
            System.out.println(person);
        }
    }
}
