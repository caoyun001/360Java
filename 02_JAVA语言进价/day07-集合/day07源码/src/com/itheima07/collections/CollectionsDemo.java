package com.itheima.collections;

import com.itheima.domain.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * java.util.Collections集合操作的工具类
 * 主要对Collection集合操作(单列集合)
 * 方法:
 *   static shuffle(List list)元素随机的排列
 *   static sort(List list)对List集合进行排序,升序
 *   static sort(List list,Comparator c)对List集合进行排序,升序
 *                         第二个参数比较器,根据比较器的结果,进行排序
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        method_2();
    }
    /**
     * 使用工具类Collections方法sort对集合排序
     * 集合存储了自定义的对象,Person
     * sort:
     *   对集合中的元素排序
     *   对象Person无法排序导致
     *   自定义Person的顺序
     *   sort方法的第二个参数 Comparator类型的对象
     *   传递 Comparator接口的实现类对象
     */
    public static void method_2(){
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("张三",20));
        list.add(new Person("李四",28));
        list.add(new Person("李四",21));
        list.add(new Person("李四",22));
        list.add(new Person("李四",25));
        //Collections.静态方法sort(list)
        Collections.sort(list, new MyComparator());
        System.out.println(list);
    }


    /**
     * 使用工具类Collections方法sort对集合排序
     */
    public static void method(){
        List<String> list = new ArrayList<String>();
        list.add("i");
        list.add("love");
        list.add("you");
        list.add("java");
        list.add("money");
        System.out.println(list);
        //Collections.静态方法sort(list)
        Collections.sort(list);
        System.out.println(list);
    }
}
