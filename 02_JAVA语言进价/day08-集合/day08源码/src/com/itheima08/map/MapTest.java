package com.itheima.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map集合练习:
 *   已知一个字符串:
 *   计算出字符串中,每个字符出现的次数 (字母大写,小写,数字)
 *   结果输出:
 *     a出现1次
 *     b出现3次
 *     A出现5次
 */
public class MapTest {
    public static void main(String[] args) {
        String str = "aBsdAABB2123awqe";
        //创建Map集合,键是字符,值是整数
        //键表示字符串中的单个字符,值是出现次数
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        //字符串转成数组
        char[] chs =  str.toCharArray();
        //遍历
        for(char ch : chs){
            //ch就是数组中的每个字符
            //字符作为键,到Map集合中获取值
            Integer value =  map.get(ch);
            if(value == null){
                //值是null,集合中没有这个键,字符没有出现过
                map.put(ch,1);
            }else {
                //值不是null,集合中有这个键,字符出现过
                value++;
                map.put(ch,value);
            }
        }
        //数组遍历完成,集合中存储的就是字符出现的次数
        for(Character character : map.keySet()){
            System.out.println(character+"字符出现次数"+map.get(character));
        }
    }
}
