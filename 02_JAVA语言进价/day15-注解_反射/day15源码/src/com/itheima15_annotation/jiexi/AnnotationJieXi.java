package com.itheima.jiexi;

import com.itheima.our.Book;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *  注解解析:
 *    获取注解上的属性值
 *    @Book(bookName = "红楼梦",price = 200.99, author = {"曹雪芹","高额"})
 *
 *    接口 AnnotatedElement 方法:
 *       boolean isAnnotationPresent(Class<? extends Annotation> annotationClass)
 *       解释:
 *         返回值是布尔值: 返回的true,该对象上有注解,返回的是false,该对象没有注解
 *
 *         Class<? extends Annotation> annotationClass
 *         传递class文件对象  ?不知道, 肯定?继承Annotation
 *         Annotation接口,是所有注解的顶级接口,可以传递任意的注解!!
 *
 *
 *       <T extends Annotation> getAnnotation(Class<T> annotationClass)
 *       返回注解
 *       解释:
 *         参数传递是任意注解的class文件对象
 *
 *         传递什么类型,返回什么类型
 *
 *      实现类: Class类, Constructor构造方法, Field成员变量, Method成员方法,
 *      结论: 注解解析,和哪个技术密切相关  反射
 *
 *      需求:
 *        获取BookShelf类上,注解Book的属性值
 *
 *    注解的解析思想:
 *      1: 反射带有注解的类
 *      2: 反射方法
 *      3: 判断方法上是否有注解
 *      4: 获取这个注解
 *      5: 获取注解的属性值
 */
public class AnnotationJieXi {
    @Test
    public void test()throws Exception{
        //反射BookShelf
        Class c = Class.forName("com.itheima.our.BookShelf");
        //反射获取方法sellBook
        Method method = c.getMethod("sellBook");
        System.out.println(method);
        //方法判断是否有注解
        //参数,传递注解的class文件对象
        boolean b = method.isAnnotationPresent(Book.class);
        //method对象调用方法,获取直接
        Book book = method.getAnnotation(Book.class);
        //获取出Book注解的属性
        String bookName = book.bookName();
        double price = book.price();
        String[] strings = book.author();
        System.out.println(bookName+price+ Arrays.toString(strings));

    }
}
