package com.itheima.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  Map集合遍历: 不能直接使用迭代器,不能直接使用增强for
 *  遍历思想: 键找值
 *    Map集合中提供方法: Set<K> keySet() Map集合中的所有的键,存储到Set集合
 *    Set集合中存储的都是Map中的键
 *
 *   实现步骤:
 *     1: Map集合方法keySet(),获取到存储所有键的Set集合
 *     2: 遍历Set集合,取出了集合中的所有的键
 *     3: Map集合方法get()获取值
 */
public class MapDemo02 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("java",10000);
        map.put("c",11000);
        map.put("php",8000);
        map.put("python",9000);
        //1: Map集合方法keySet(),获取到存储所有键的Set集合
        Set<String> set = map.keySet();
        // 2: 遍历Set集合,取出了集合中的所有的键
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
           String key =  it.next();
           // 3: Map集合方法get()获取值
           Integer value =  map.get(key);
            System.out.println(key+"::"+value);
        }
    }
}
