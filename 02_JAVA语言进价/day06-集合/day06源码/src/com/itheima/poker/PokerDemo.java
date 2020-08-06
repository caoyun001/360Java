package com.itheima.poker;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  模拟斗地主案例 : 练习集合对象的使用
 *  斗地主功能:
 *     准备扑克牌
 *       介绍:54张, 4个花色,每个花色13张 + 两个王牌
 *       游戏中,54个图片,54个字符串替代
 *       54个字符串,存储集合 (牌盒子)
 *
 *       实现:
 *         每个花色具有13张,4个花色
 *         拿出一个花色来,根13张进行组合
 *         外循环4次,内存循环13次
 *         花色存储在容器中: 数组
 *         13个点数存储在容器: 数组

 *     洗牌:
 *        本质上,是将集合poker中的字符串的顺序打乱,随机性
 *        Collections类
 *        static void shuffle(List 集合) 将集合中的元素位置,随机排列
 *
 *     发牌:
 *        斗地主游戏,三个人
 *        每个人手中17张牌,预留3张底牌
 *
 *    遍历牌盒集合,取出里面每个字符串 get
 *        字符串存储在玩家集合 add
 *        利用集合的索引%3的方式,对玩家进行发牌操作
 *
 *     看牌:
 *       将玩家的集合,底牌集合遍历
 *       4个集合,我要写4个for (重复代码,抽取成方法)
 */
public class PokerDemo {
    public static void main(String[] args) {
        //定义数组,存储4个花色
        String[] colors ={"♠","♥","♣","♦"};
        //定义数组,存储13个点数
        String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        //创建集合,作为牌盒使用,存储54个字符串
        ArrayList<String> poker = new ArrayList<String>();
        //外循环遍历花色数组
        for(int i = 0 ; i < colors.length; i++){
            //内循环遍历点数数组
            for(int j = 0 ; j < numbers.length ;j++){
                //花色和点数,字符串的拼接
               poker.add(colors[i]+numbers[j]);
            }
        }
        //单独存储小王和大王
        poker.add("大王");
        poker.add("小王");
        System.out.println(poker);

        //Collections静态方法shuffle,集合元素随机排列
        Collections.shuffle(poker);
        System.out.println(poker);

        //发牌:创建出4个集合,3个玩家,1个底牌
        ArrayList<String> p1 = new ArrayList<String>();
        ArrayList<String> p2 = new ArrayList<String>();
        ArrayList<String> p3 = new ArrayList<String>();
        ArrayList<String> bottom = new ArrayList<String>();
        //循环,遍历牌盒集合
        for(int i = 0 ; i < poker.size(); i++){
            //判断,将前3个字符串存储到底牌
            if(i < 3){
                bottom.add(poker.get(i));
            }
            //对象索引进行%3 余数
            //取出集合中的元素,存储到玩家集合
            else if(i % 3 == 0){
                //牌发给玩家1
               p1.add (poker.get(i));
            }
            else if ( i % 3 == 1){
                //牌发给玩家2
                p2.add(poker.get(i));
            }
            else {
                //牌发给玩家3
                p3.add(poker.get(i));
            }
        }
        //看牌:调用4次看牌的方法,传递4个集合
        look(p1);
        look(p2);
        look(p3);
        look(bottom);
    }

    /**
     * 定义方法,实现遍历集合
     */
    public static void look(ArrayList<String> arrayList){
        for(int i = 0 ; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.println();
    }
}
