package com.itheima.collections;

import com.itheima.domain.Person;

import java.util.Comparator;

/**
 * 自定义接口Comparator的实现类
 * 实现接口,重写抽象方法,创建Person对象的比较器
 */
public class MyComparator implements Comparator<Person>{
    /**
     * 重写接口中的抽象方法
     * 返回值是int,方法的参数是 Person o1, Person o2
     * o2对象-o1对象,如果是正数,大的在前面
     */
    public int compare(Person o1,Person o2){
        //o1是李四,o2是张三
        //张三的年龄-李四的年龄
        // 谁的年龄大,谁在前面
        return  o2.getAge() - o1.getAge();// 正数
    }
}
