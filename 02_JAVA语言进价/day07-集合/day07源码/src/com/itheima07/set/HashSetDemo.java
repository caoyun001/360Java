package com.itheima.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * java.util.HashSet 集合
 * 是Set接口的实现类
 *   元素不能重复
 *   无序的集合 (存储和取出的顺序,不一致)
 *   底层数据结果是哈希表实现
 *   增删,查询速度都很快
 *   线程不安全的集合,运行速度快
 *
 *
 * HashSet集合:
 *   底层数据结果是哈希表实现
 *   HashSet集合本身没有功能,依靠另一个集合HashMap实现的功能
 *
 *
 */
public class HashSetDemo {
    public static void main(String[] args) {
     //   System.out.println("bbc".hashCode());
        Set<String> set = new HashSet<String>();
        set.add("abc");
        set.add("bbc");
        set.add(new String("abc"));
        set.add("重地");
        set.add("通话");
        //set集合遍历,增强for
        for(String s : set){
            System.out.println(s);
        }
    }
}
