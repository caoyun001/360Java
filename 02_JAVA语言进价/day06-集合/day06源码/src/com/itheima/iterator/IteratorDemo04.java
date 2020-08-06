package com.itheima.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *  public class ArrayList{
 *
 *      public Iterator iterator(){
 *          return new Itr();
 *      }
 *
 *      //内部类,实现了迭代器接口
 *      class Itr implements  Iterator{
 *          public boolean hasNext(){}
 *
 *          public E next(){}
 *
 *          public void remove();
 *      }
 *  }
 *
 *  集合中的有个内部类,实现了迭代器的接口,重写接口的方法
 *  变成了集合迭代的一致性
 */
public class IteratorDemo04 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<String>();
        Iterator<String> it =  coll.iterator();  // new Itr();
        System.out.println(it);//java.util.ArrayList$Itr@1b6d3586
    }
}
