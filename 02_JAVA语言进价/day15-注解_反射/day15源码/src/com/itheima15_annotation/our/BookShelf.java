package com.itheima.our;

/**
 * 使用注解,就是为注解的属性赋值
 * 格式:
 *   @注解名(属性名=值,属性名=值)
 *   如果注解的属性有默认值,可以不赋值
 *
 *   String[] author();作者是字符串的数组
 *   数组的赋值{}
 *
 *   如果注解中的属性只有一个,名字是value
 *   赋值的时候,可以省略value不写
 *   属性是数组,数组中只有一个元素,大括号可以不写
 */


//@Teacher("张三")
public class BookShelf {
    @Book(bookName = "红楼梦",price = 200.99, author = {"曹雪芹","高额"})
    public void sellBook(){

    }
}
