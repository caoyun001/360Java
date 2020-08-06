package com.itheima.lambda;

import com.itheima.domain.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * lambda表达式的好处和弊端
 *
 *   弊端: 使用场景局限太大
 *     适用于接口,接口中只能有一个抽象方法
 *     Runnable接口,只有一个抽象方法run
 *     Comparator接口,只有一个抽象方法 compare
 *
 *   好处: 减少代码量
 *     可推导可省略
 *       1: 方法体: 只有1行代码,{} 可以省略
 *       2: 方法依赖接口,明确返回int类型  return int;  可以省略return
 *       3: 方法参数
 *         sort(ist)集合排序 , list集合明确了存储的数据类型泛型  <Person>
 *             比较器接口Comparator,比较的对象也是Person
 *             参数类型可以省略
 */


public class LambdaDemo04 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("杨幂",30));
        list.add(new Person("杨紫",32));
        System.out.println(list);

        /* Collections.sort(list, new Comparator<Person>(){
            public int compare(Person p1,Person p2){
                return  p2.getAge() - p1.getAge();
            }
        } );*/

        Collections.sort(list,  ( p1, p2)->  p2.getAge()-p1.getAge() );

        System.out.println(list);
    }
}
