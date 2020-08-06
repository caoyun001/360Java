package com.itheima.poker;

import java.util.*;

/**
 * 实现斗地主功能
 *   准备牌:
 *     牌存储在集合中
 *     Map集合,键存储牌编号
 *     List集合,存储编号
 *
 *     利用的是字符串数组
 *     一个存储花色,一个存储点数
 *
 *   洗牌
 *     存储编号集合,元素随机排列
 *
 *   发牌
 *     发出去的是编号
 *     编号集合中获取一个元素,存储在玩家的集合中
 *
 *   排序
 *     对玩家的集合中的元素进行排序
 *     元素是整数,直接排序
 *
 *   看牌
 *     用玩家集合中的元素,作为键
 *     到Map集合汇总获取值
 *
 */
public class Poker {
    public static void main(String[] args) {
        //定义Map集合,键是编号,值是牌
        Map<Integer,String> map = new HashMap<Integer, String>();
        //定义List集合,存储编号
        List<Integer> list = new ArrayList<Integer>();
        //定义变量,保存编号
        int i = 0;
        //定义数组,存储4个花色
        String[] colors ={"♠","♥","♣","♦"};
            //定义数组,存储13个点数
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //嵌套循环,遍历数组,花色+点数
        for(String number : numbers){
            for(String color : colors){
               //存储Map集合
                map.put(i,color+number);
                //存储List集合
                list.add(i);
                i++;
            }
        }
        //存储王牌
        map.put(52,"小王");
        map.put(53,"大王");
        list.add(52);
        list.add(53);

        //随机排列集合元素(集合存储的是编号)
        Collections.shuffle(list);

        //定义四个集合
        List<Integer> p1 = new ArrayList<Integer>();
        List<Integer> p2 = new ArrayList<Integer>();
        List<Integer> p3 = new ArrayList<Integer>();
        List<Integer> bottom = new ArrayList<Integer>();

        //循环,遍历牌盒集合
        for(int j = 0 ; j < list.size(); j++){
            //判断,将前3个字符串存储到底牌
            if(j < 3){
                bottom.add(list.get(j));
            }
            //对象索引进行%3 余数
            //取出集合中的元素,存储到玩家集合
            else if(j % 3 == 0){
                //牌发给玩家1
                p1.add (list.get(j));
            }
            else if ( j % 3 == 1){
                //牌发给玩家2
                p2.add(list.get(j));
            }
            else {
                //牌发给玩家3
                p3.add(list.get(j));
            }
        }
        //对玩家集合中元素排序
        Collections.sort(p1);
        Collections.sort(p2);
        Collections.sort(p3);
        Collections.sort(bottom);

        //调用4次看牌方法
        look("令狐冲",p1,map);
        look("莹莹",p2,map);
        look("东方不败",p3,map);
        look("底牌",bottom,map);
    }

    /**
     * 定义方法,实现看牌
     * 玩家名,玩家编号集合,Map集合
     */
    private static void look(String name,List<Integer> list,Map<Integer,String> map){
        System.out.print(name+"::");
        //遍历List集合
        for(Integer integer : list){
            //integer是编号,是Map中的键
            String value = map.get(integer);
            System.out.print(value+" ");
        }
        System.out.println();
    }
}

