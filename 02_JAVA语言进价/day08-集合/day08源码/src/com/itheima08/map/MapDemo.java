package com.itheima.map;

import com.sun.javafx.collections.MappingChange;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Map集合
 *   Map是接口,所有键值对集合的顶层接口
 *   Map接口,和Collection没有关系
 *
 *  Map<K,V>  K 作为键的数据类型, V作为值的数据类型
 *
 *  Map是接口,实现类HashMap
 */
public class MapDemo {
    public static void main(String[] args) {
        method_4();
    }

    /**
     *   Collection<V> values()
     *   将Map集合中的所有的值,存储在Collection集合
     */
    public static void method_4(){
        //创建Map集合,键是整数,值是字符串
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        //将集合中的所有值,a b c ,存储到Collection集合
        Collection<String> coll =  map.values();
        for(String str : coll){
            System.out.println(str);
        }
    }

    /**
     *  boolean containsKey(K)   判断集合中是否包含此键,包含返回true
     *  boolean containsValue(V) 判断集合中是否包含此值,包含返回true
     */
    public static void method_3(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        //Map集合方法put,存储键值对
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        //判断集合中是否包含此键
        boolean b = map.containsKey("c");
        System.out.println(b);

        //判断集合中是否包含此值
        b = map.containsValue(2);
        System.out.println(b);
    }

    /**
     *  V get(K) 返回此键对应的值
     *  传递键,返回对应的值,集合中无此键,返回null
     */
    public static void method_2(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        //Map集合方法put,存储键值对
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        //get方法,获取c键对应的值
        Integer integer = map.get("c");
        System.out.println(integer);
    }

    /**
     *  V put(K,V)将键值对,存储在集合中
     *  返回作为值的对象
     *  put方法的返回值,一般情况下都返回null
     *  当向集合中存储了重复键的时候,将原有的值覆盖
     *  put方法,返回被覆盖之前的值
     */
    public static void method(){
        //创建Map集合,使用实现类HashMap集合
        //键是字符串类型,值是整数类型
        Map<String,Integer> map = new HashMap<String, Integer>();
        //Map集合方法put,存储键值对
        map.put("a",1);
        map.put("b",2);
        Integer i = map.put("b",5);
        map.put("c",3);
        System.out.println(map);
        System.out.println(i);
    }
}
