package com.itheima.listlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  集合嵌套:
 *   在一个List集合中,存储了另一个List集合
 *   要求:
 *     定义三个List集合,分别存储字符串
 *     再定义一个List集合,存储其他List集合
 */
public class ListListDemo {
    public static void main(String[] args) {
        //定义三个List集合,分别存储字符串
        List<String> small1 = new ArrayList<String>();
        List<String> small2 = new ArrayList<String>();
        List<String> small3 = new ArrayList<String>();

        small1.add("java");
        small1.add("javac");

        small2.add("c");
        small2.add("c++");

        small3.add("php");
        small3.add("python");

        //再定义一个List集合,存储其他List集合
        List<List<String>> bigList = new ArrayList();
        //向大集合,存储小集合
        bigList.add(small1);
        bigList.add(small2);
        bigList.add(small3);

        iterator(bigList);
    }

    public static void iterator( List<List<String>> bigList ){
        //遍历外面的大集合
        Iterator<List<String>> it =  bigList.iterator();
        while (it.hasNext()){
            //迭代器方法next()取出大集合的元素, 存储的是小集合List
            List<String> small =  it.next();
            //迭代器,遍历小集合
            Iterator<String> smallIt =  small.iterator();
            while (smallIt.hasNext()){
                //迭代器方法next()取出,小集合的元素
                String str = smallIt.next();
                System.out.println(str);
            }
        }
    }
}
