package com.itheima.map;

import javafx.scene.media.SubtitleTrack;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Map集合，使用的都是线程不安全的集合
 * JDK1.5出现新的集合类 java.util.ConcurrentHashMap
 * 集合一部分线程安全的，一部分是线程不安全的
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<String,Integer> map = new ConcurrentHashMap<String, Integer>();
//        Map<String,Integer> map = new HashMap<String, Integer>();
        for(int x = 0 ; x < 2000; x++){
            map.put("count"+x,x);
        }
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 500;i++){
                    map.remove("count"+i);
                }
            }
        };


        //开启线程，删除1000-1500个
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i = 1000 ; i < 1500;i++){
                    map.remove("count"+i);
                }
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();

        Thread.sleep(2000);
        System.out.println(map.size());

    }
}

/**
 *    Map<String,String> map = new ConcurrentHashMap<String, String>();
 map.put("a","1");
 map.put("b","2");
 map.put("c","3");
 Set<String> set = map.keySet();
 Iterator<String> it = set.iterator();
 while (it.hasNext()){
 String key = it.next();
 if("a".equals(key)){
 map.put("d","4");
 }
 }
 System.out.println(map);
 */
