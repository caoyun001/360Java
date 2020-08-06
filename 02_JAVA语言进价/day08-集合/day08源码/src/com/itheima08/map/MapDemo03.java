package com.itheima.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的遍历
 *   遍历的思想是依靠键值对的映射关系遍历
 *   键和值,一一对应
 *
 *   接口Entry:定义了每个键值对的对应关系(结婚证)
 *   Map集合中定义方法:
 *      entrySet() 意义,将集合中的所有键值对的对应关系,存储到Set集合中
 *      方法返回值   Set< Entry<K,V> >
 *
 *   实现步骤:
 *     1: Map集合的方法 entrySet()
 *       获得每个键值对的对应关系对象 Entry, 存储在Set集合中
 *
 *     2: 遍历Set集合
 *       取出的是 键值对的对应关系对象
 *
 *     3: 对应关系对象,获取键和值
 *       Entry接口方法 getKey()  getValue()
 *
 */
public class MapDemo03 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("java",10000);
        map.put("c",11000);
        map.put("php",8000);
        map.put("python",9000);
        // 1: Map集合的方法 entrySet()
        Set<Map.Entry<String,Integer>> set =  map.entrySet();
        //2: 遍历Set集合
        Iterator<Map.Entry<String,Integer>> it = set.iterator();
        while (it.hasNext()){
            // 3: 对应关系对象,获取键和值
            // set集合中,存储的元素是Entry对象, it.next()取出的也是Entry对象
            Map.Entry<String,Integer> entry =  it.next();
            //Entry对象的方法 getKey() getValue()
            String key =  entry.getKey();
            Integer value =  entry.getValue();
            System.out.println(key+"::"+value);
        }
    }
}
