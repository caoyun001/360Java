package com.itheima.iterator;

import java.util.*;

/**
 * 迭代器 Iterator: 遍历集合的工具
 * 是所有Collection集合的通用遍历方式
 *
 * Collection接口:定义方法  Iterator iterator() 方法返回迭代器的对象
    * ArrayList实现接口Collection,重写此方法iterator()
    * 返回值是 Iterator接口, iterator()方法返回的是接口实现类的对象
    *  Iterator接口 = arrayList.iterator()
    *  Iterator接口 .方法()
    *  1: 返回的接口实现类,必然重写接口Iterator中的抽象方法
    *  2: 接口引用.重写方法()
 *
 * Iterator接口:
 *    boolean hasNext() 判断集合中是否有下一个元素,如果有返回true
 *    next() 取出集合中的下一个元素
 *    remove() 移除集合中的元素 (不常用)
 *
*/
public class IteratorDemo {
    public static void main(String[] args) {
        /**
         * 迭代器遍历集合
         * 步骤:
         *   1: 集合对象调用方法 iterator()获取迭代器接口Iterator对象
         *      获取的是接口实现类对象
         *
         *   2: Iterator对象调用方法hasNext()
         *      判断集合中是否有下一个元素,有返回true
         *
         *   3: Iterator对象调用方法next()
         *      取出下一个元素
         */
        Collection<String> coll = new ArrayList<String>();
        coll.add("i");
        coll.add("love");
        coll.add("java");


        //1: 集合对象调用方法 iterator()获取迭代器接口Iterator对象
        Iterator<String> it =  coll.iterator();
        //2: Iterator对象调用方法hasNext()
        //使用while循环,条件是集合中有下一个元素
        while (it.hasNext()){
            // 3: Iterator对象调用方法next()
            String s = it.next();
            System.out.println(s);
        }
    }
}
/**
 * boolean b = it.hasNext();
 System.out.println(b);
 //3: Iterator对象调用方法next()
 String s = it.next();
 System.out.println(s);
 */