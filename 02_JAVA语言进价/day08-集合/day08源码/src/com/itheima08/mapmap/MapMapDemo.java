package com.itheima.mapmap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * - java基础班  集合 存储的是 学号 键，值学生姓名
     - 001  张三
     - 002  李四
  *- java就业班
     - 001  王五
     - 002  赵柳

   小的Map集合,存储学号和姓名
   两个小Map集合
   存储到一个大的Map集合 <班名, 存储学生的小Map集合 >
 */
public class MapMapDemo {
    public static void main(String[] args) {
        //创建基础班的Map集合
        Map<String,String> javase = new HashMap<String, String>();
        //创建就业班的Map集合
        Map<String,String> javaee = new HashMap<String, String>();

        //基础班集合存储数据
        javase.put("001","张三");
        javase.put("002","李四");

        //就业班集合存储数据
        javaee.put("001","王武");
        javaee.put("002","赵柳");

        //创建大集合,键是班级名,值是班级的Map集合
        Map<String, Map<String,String>> big = new HashMap<String, Map<String,String>>();
        big.put("基础班",javase);
        big.put("就业班",javaee);

        //keySet(big);
        entrySet(big);
    }
    /**
     * 定义方法,遍历Map集合
     * entrySet()
     */
    public static void entrySet(Map<String, Map<String,String>> big){
        //大集合Map调用方法entrySet(),键值对的对应关系对象Entry,存储Set集合
        Set<Map.Entry<String,Map<String,String>>> set = big.entrySet();
        Iterator<Map.Entry<String,Map<String,String>>> it =  set.iterator();
        while (it.hasNext()){
            //迭代器next()取出Set集合元素,取出是Map集合的键值对关系对象Entry
            Map.Entry<String,Map<String,String>> bigEntry =  it.next();
            //大集合entry取出,大集合的键,和值
            String key = bigEntry.getKey();
            Map<String,String> smallMap =  bigEntry.getValue();
            System.out.println(key);
            //遍历小集合smallMap,方法entrySet()获取小集合的键值对关系对象
            Set<Map.Entry<String,String>> smallSet =  smallMap.entrySet();
            Iterator<Map.Entry<String,String>> smallIt =  smallSet.iterator();
            while (smallIt.hasNext()){
                //迭代器next()方法,取出元素是小集合的对应关系对象
                Map.Entry<String,String> smallEntry = smallIt.next();
                //取出小集合Map的键和值
                String smallKey = smallEntry.getKey();
                String smallValue = smallEntry.getValue();
                System.out.println(smallKey+"::"+smallValue);
            }
        }
    }

    /**
     * 定义方法,遍历Map集合
     * keySet()
     */
    public static void keySet(Map<String, Map<String,String>> big){
        //使用大集合方法keySet()键,存储到Set集合
        Set<String> bigSet =  big.keySet();
        Iterator<String> bigIt =  bigSet.iterator();
        while (bigIt.hasNext()){
            //迭代器next()取出的是Set集合元素,是大Map集合的键
            String key = bigIt.next();
            //取出大集合Map的值
            Map<String,String> smallMap = big.get(key);
            System.out.println(key);
            //小集合调用方法keySet()键,存储到Set集合
            Set<String> smallSet = smallMap.keySet();
            Iterator<String> smallIt =  smallSet.iterator();
            while (smallIt.hasNext()){
                //迭代器next()取出的是Set集合元素,小Map集合的键
                String smallKey = smallIt.next();
                //获取小集合Map的值
                String smallValue = smallMap.get(smallKey);
                System.out.println(smallKey+"::"+smallValue);
            }
        }
    }
}
