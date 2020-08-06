package com.itheima.properties;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *  重要的集合 java.util.Properties
 *  Properties类继承Hashtable, 实现Map接口
 *  Hashtable类是Map接口的实现类
 *    底层数据是哈希表
 *    是线程安全的集合,运行速度慢
 *    禁止存储null值,null键
 *
 *   被更先进的HashMap取代
 *   Properties: 对于Map的一切操作都是OK
 *
 *  掌握: Properties集合自己的特性
 *  集合能和IO流技术结合使用,实现数据的持久化
 *
 *
 *   Properties集合自己的特性,键值对集合
 *   键值对的数据类型,被锁定为String
 *
 *   Map集合存储元素的方法put
 *   Properties存储元素的方法 setProperty(String key,String value)
 *
 *   Map集合取出值的方法get
 *   Properties取出元素的方法 getProperty(String key)
 *
 *   Map集合将键存储到Set集合,方法 keySet()
 *   Properties键存储到Set集合,方法 stringPropertyNames()
 */
public class PropertiesDemo {
    public static void main(String[] args) {
        method_2();
    }
    /**
     * Properties集合的遍历
     */
    public static void method_2(){
        Properties pro = new Properties();
        pro.setProperty("张三","20");
        pro.setProperty("李四","21");
        pro.setProperty("王武","22");
        //键,存储到Set集合
        Set<String> set = pro.stringPropertyNames();
        for(String key : set){
            System.out.println(key+"::"+pro.getProperty(key));
        }
    }

    /**
     * Properties集合存储和取出元素的方法
     * setProperty
     * getProperty
     */
    public static void method(){
        Properties pro = new Properties();
        pro.setProperty("张三","20");
        pro.setProperty("李四","21");
        pro.setProperty("王武","22");
        System.out.println(pro);

        String value = pro.getProperty("李四1");
        System.out.println(value);
    }
}
