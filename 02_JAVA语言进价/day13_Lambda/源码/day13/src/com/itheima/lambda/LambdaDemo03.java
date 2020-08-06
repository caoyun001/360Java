package com.itheima.lambda;

import com.itheima.domain.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 带有返回值和参数的 lambda表达式
 * 分析:
 *   目的是集合排序,自定义比较器
 *   不得意,实现接口Comparator,重写方法compare
 *   sort方法,传递接口实现类
 *
 *   lambda 去掉面向对象束缚
 *
 *   实现接口,重写方法
 */
public class LambdaDemo03 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("杨幂",30));
        list.add(new Person("杨紫",32));
        System.out.println(list);

        //集合排序
        //Collections.sort(list, new MyComparator());

       /* Collections.sort(list, new Comparator<Person>(){
            public int compare(Person p1,Person p2){
                return  p2.getAge() - p1.getAge();
            }
        } );*/

        /**
         * Lambda表达式,简化匿名内部类
         * (参数Person对象)-> 参数传递到方法体
         * {方法体,可以直接使用参数}
         *
         * return 的结果,直接到达sort方法
         */
        Collections.sort(list  ,(Person p1,Person p2)->{ return p2.getAge()-p1.getAge(); }  );

        System.out.println(list);
    }
}

//定义比较器接口实现类
/*
class MyComparator implements Comparator<Person>{
    //p2-p1 降序 大到小
    public int compare(Person p1,Person p2){
        return  p2.getAge() - p1.getAge();
    }

}
*/
