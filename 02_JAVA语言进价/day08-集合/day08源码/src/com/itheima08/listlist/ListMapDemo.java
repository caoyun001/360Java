package com.itheima.listlist;

import java.util.*;

/**
 * 集合嵌套: List集合中存储Map集合
 * 班级有第三名同学，学号和姓名分别为：001=张三，002=李四，003=王五，
 * 2班有三名同学，学号和姓名分别为：001=黄晓明，002=杨颖，003=刘德华，004=朱丽倩，
 * 班级中的同学信息存储在Map集合,出现2个Map集合
 * Map集合存储在List集合中
 */
public class ListMapDemo {
    public static void main(String[] args) {
        //创建班级集合1班
        Map<String,String> class1 = new HashMap<String, String>();
        //创建班级集合2班
        Map<String,String> class2 = new HashMap<String, String>();

        class1.put("001","张三");
        class1.put("002","李四");
        class1.put("003","王武");

        class2.put("001","黄晓明");
        class2.put("002","杨颖");
        class2.put("003","刘德华");
        class2.put("004","朱丽倩");

        //Map集合存储到List集合中,创建List集合
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        list.add(class1);
        list.add(class2);

       // keySet(list);
        entrySet(list);
    }
    /**
     * 定义方法,遍历List集合
     * 同时遍历Map集合,使用entrySet()
     */
    public static void entrySet(List<Map<String,String>> list){
        //迭代器遍历集合List
        Iterator<Map<String,String>> it =  list.iterator();
        while (it.hasNext()){
            //取出List集合的元素,是Map集合
            Map<String,String> map = it.next();
            //entrySet()方法,将Map集合中键值对的对应关系对象Entry,存储到Set集合
            Set<Map.Entry<String,String>> set =  map.entrySet();
           //迭代器遍历Set集合
            Iterator<Map.Entry<String,String>> setIt = set.iterator();
            while (setIt.hasNext()){
                //迭代器取出集合元素,取出的是Entry对象
                Map.Entry<String,String> entry = setIt.next();
                //Entry对象的方法getKey(),getValue()
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println(key+"::"+value);
            }
        }
    }

    /**
     * 定义方法,遍历List集合
     * 同时遍历Map集合,使用keySet()
     */
    public static void keySet(List<Map<String,String>> list){
        //迭代器遍历集合List
        Iterator<Map<String,String>> it =  list.iterator();
        while (it.hasNext()){
            //取出List集合的元素,是Map集合
            Map<String,String> map = it.next();
            //keySet()方法遍历Map集合,键存储到Set集合
            Set<String> set =  map.keySet();
            //迭代器遍历Set集合
            Iterator<String> setIt = set.iterator();
            while (setIt.hasNext()){
                //迭代器取出Set集合元素,是Map中的键
                String key = setIt.next();
                String value = map.get(key);
                System.out.println(key+"::"+value);
            }
        }
    }
}
