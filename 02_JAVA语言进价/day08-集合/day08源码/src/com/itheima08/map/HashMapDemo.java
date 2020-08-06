package com.itheima.map;

import com.itheima.domain.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.HashMap集合
 * 实现了Map接口
 *   底层是哈希表结构 数组+链表(单向)
 *   JDK1.8开始,当数组中的链表的节点到达8个,转成红黑树结构
 *   集合是无顺序
 *   允许存储null值,null键
 *   线程不安全,运行速度快
 *
 *   开发人员: 保证键对象的唯一性
 *   存储到哈希表中的对象,必须实现 hashCode,equals
 */
public class HashMapDemo {
    public static void main(String[] args) {
        method_2();
    }

    /**
     * 自定义对象存储到HashMap集合
     * 字符串作为值,Person对象作为键
     * 哈希表,保证键的唯一性: 重写方法hashCode,equals
     */
    public static void method_2(){
        Map<Person,String> map = new HashMap<Person, String>();
        map.put(new Person("张三",20),"北京市");
        map.put(new Person("李四",20),"北京市");
        map.put(new Person("李四",20),"北京市");
        map.put(new Person("王武",20),"北京市");
        map.put(new Person("赵柳",20),"北京市");
        for(Map.Entry<Person,String> entry : map.entrySet()){
            Person person = entry.getKey();
            String value = entry.getValue();
            System.out.println(person+"::"+value);
        }
    }

    /**
     * 自定义对象存储到HashMap集合
     * 字符串作为键,Person对象作为值
     * 补充:
     *   基本数据类型包装类,和String类
     *   全部重写hashCode()和equals()
     */
    public static void method(){
        Map<String,Person> map = new HashMap<String, Person>();
        map.put("北京市", new Person("张三",20));
        map.put("天津市", new Person("张四",22));
        map.put("天津市", new Person("张四",24));
        map.put("广州市", new Person("张五",21));
        map.put("深圳市", new Person("张六",23));

        for( Map.Entry<String,Person> entry : map.entrySet() ){
            String key = entry.getKey();
            Person person = entry.getValue();
            System.out.println(key+"::"+person);
        }
    }
}
