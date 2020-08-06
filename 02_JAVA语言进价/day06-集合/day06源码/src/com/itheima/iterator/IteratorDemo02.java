package com.itheima.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo02 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<String>();
        coll.add("i");
        coll.add("love");
        coll.add("java");
        //迭代器的代码,改造成for循环
        /**
         *  初始化变量
         *  条件
         *  增量
         */
        for(Iterator<String> it = coll.iterator();it.hasNext() ;){
            String s = it.next();
            System.out.println(s);
        }
    }
}
