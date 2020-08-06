package com.itheima.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *  增强for遍历Map,不能直接遍历
 *  但是能间接遍历,Map集合遍历依靠Set集合
 */
public class MapDemo04 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("java",10000);
        map.put("c",11000);
        map.put("php",8000);
        map.put("python",9000);

        //for间接遍历Map
        //Set<String> set =  map.keySet();
        for(String key : map.keySet()){
           // Integer value = map.get(key);
            System.out.println(key+"::"+map.get(key));
        }
        System.out.println("=====================");

        //for间接遍历Map
       // Set<Map.Entry<String,Integer>> set =   map.entrySet();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+"::"+entry.getValue());
        }
    }
}
