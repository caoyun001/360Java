package com.itheima.generic01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 泛型: JDK5出现的新特性
 *
 * 泛型出现之前: 程序存在安全的问题 (类型转换上,出现异常)
 *
 * 泛型: 是程序中的安全机制,保证程序安全性
 *    增加新功能,改善用户体验
 *    提升安全性,提升性能,修复已知的bug
 *
 *  集合类<要存储的数据类型> 变量名 = new 集合类<要存储的数据类型>();
 *
 *  安全:
 *    编译时期,检测集合中存储的数据类型,如果和泛型不一致,编译失败
 *    安全问题,由运行时期,提前到编译时期
 *
 *   好处: 避免了数据类型的强制转换
 *         增强for
 *
 *   泛型,只在编译的时候有效,编译成功的class文件中,没有泛型 (伪泛型)
 */
public class GenericDemo {
    public static void main(String[] args) {
        //创建集合,不写泛型 <>
        List<String> list = new ArrayList<String> ();
        //存储元素,不写泛型,这样的集合可以存储任意的引用数据类型
        list.add("hello");
        list.add("world");
        //list.add(100);// new Integer()
        list.add("java");

        //迭代器遍历集合
        //取出元素,输出元素的长度
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            //字符串的长度,强转
            String str = it.next();
            System.out.println(str.length());
        }
    }
}
