package com.itheima.set;

import java.util.HashSet;

/**
 *  new HashSet(int 初始化容量, float 加载因子)默认16, 0.75
 *
 *  public HashMap(int 10, 0.1) {
         if (initialCapacity < 0)
             throw new IllegalArgumentException("Illegal initial capacity: " +initialCapacity);
         if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
         if (loadFactor <= 0 || Float.isNaN(loadFactor))
           throw new IllegalArgumentException("Illegal load factor: " +loadFactor);
         this.loadFactor = loadFactor;
         this.threshold = tableSizeFor(10);
         }

     static final int tableSizeFor(int 10) {
     int n = cap - 1;
     n |= n >>> 1;
     n |= n >>> 2;
     n |= n >>> 4;
     n |= n >>> 8;
     n |= n >>> 16;
     return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
     }
     16  8 4 2 1编码  传递整数,都会计算为大于他的8421码

    public V put(a, V value) {
        return putVal(hash(a), a, value, false, true);
 }

 final V putVal(a对象的哈希值, a, V value, boolean onlyIfAbsent,boolean evict) {
      if ((p = tab[i = (15) & hash]) == null) 确定该元素,存储在数组的哪个索引中
                      15&97 = 索引,a元素,存储在这个索引上 = 1
 *
 */
public class HashSetDemo03 {

    private static int MAXIMUM_CAPACITY = 1<<30;

    public static void main(String[] args) {
       HashSet<String> set =  new HashSet<>(10,0.1F);
       set.add("a");
       set.add("a");

        int i = tableSizeFor(128);
        System.out.println(i);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
