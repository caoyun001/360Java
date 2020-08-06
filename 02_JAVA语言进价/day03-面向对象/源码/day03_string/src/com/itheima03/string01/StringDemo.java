package com.itheima.string01;

/**
 *  字符串,是日后使用频率最高一个对象
 *  java.lang.String 表示字符串对象
 *  程序中可以直接使用 "" 创建字符串的对象
 *
 *  字符串是一个常量,创建后不能改变 (字符串的不变性)
 *  字符串的实现底层是 字符数组 "abc"   char[] c = {'a','b','c'} 字符序列
 *
 *  private final char value[];
 */
public class StringDemo {
    public static void main(String[] args) {
        toCharArray();
    }
    /**
     * 字符串方法: char[] toCharArray()字符串转成字符数组
     */
    public static void toCharArray(){
        char[] ch = "abcdef".toCharArray();
        for(int i = 0; i < ch.length; i++){
            System.out.println(ch[i]);
        }
    }

    /**
     * 字符串方法 String substring(int begin)截取字符串,开始索引
     * 字符串方法 String substring(int begin,int end)截取字符串,开始索引,结束索引
     */
    public static void substring(){
        String str = "abcdefg";
        String s1 = str.substring(3);
        System.out.println(s1);

        String s2 = str.substring(1,4);
        System.out.println(s2);
    }

    /**
     * 字符串方法:String[] split(String s)按照传递的字符串进行切割
     * 结果是字符串数组
     */
    public static void split(){
        String str = "12 3 4 567 89";
        //空格进行切割
        String[] arr = str.split(" ");
        for(int i = 0 ; i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * 字符串方法: String replace(char oldChar,char newChar)
     * 字符串方法: String replace(String oldString,String newString)
     */
    public static void replace(){
        String str = "How do you do";
        //字符串中的do,全部换成haha
        str = str.replace("do","haha");
        System.out.println(str);
    }

    /**
     * 字符串方法: int indexOf(char c)
     * 查找字符在字符串中第一次出现的索引
     * 找不到字符,返回-1
     *
     * Java: 获取数据的时候,获取的是引用类型,没有返回null
     * Java: 获取数据的时候,获取的是基本类型,没有返回负数
     */
    public static void indexOf(){
        int index  = "How do you do".indexOf('D');
        System.out.println(index);
    }

    /**
     * 字符串的方法: byte[] getBytes()
     * 字符串转成字节数组,查询ASCII
     */
    public static void getBytes(){
        //String str = "abcd";
        byte[] bytes = "abcd".getBytes();
        for(int i = 0 ; i < bytes.length ;i++){
            System.out.println(bytes[i]);
        }
    }

    /**
     * 字符串方法:
     *   boolean startsWith(String s)判断一个字符串是否以另一个字符开头
     *   boolean endsWith(String s)判断一个字符串是否以另一个字符结尾
     */
    public static void with(){
        String str = "HelloWorld.java";
        //字符串是不是以Hello开头
        boolean b = str.startsWith("HEllo");
        System.out.println(b);

        //字符串是不是以java结尾
        b = str.endsWith("ava");
        System.out.println(b);
    }

    /**
     * 字符串方法:boolean equalsIgnoreCase(String s)
     * 比较字符串是否相同,忽略大小写
     */
    public static void equalsIgnoreCase(){
        String s1 = "Hello";
        boolean b = s1.equalsIgnoreCase("HELLO");
        System.out.println(b);
    }

    /**
     * 字符串方法: boolean contains(String s)
     * 判断一个字符串中是否包含另一个字符串,完全包含返回true
     */
    public static void contains(){
        String s1 = "HelloWorld";
        String s2 = "ol";
        //s1对象中是否包含s2
        boolean b =  s1.contains(s2);
        System.out.println(b);
    }

    /**
     * 字符串方法 int compareTo(String str)
     * 字符串的比较方法,比较后会有三种可能性
     * 我比你大,我比你小,我和你一样
     * 自然顺序进行比较 abcde
     *
     * compareTo()方法会返回三种结果
     * 正数 : 调用者对象大于参数
     * 负数 : 调用者对象小于参数
     * 零 : 两个对象相同
     *
     */
    public static void compareTo(){
        String s1 = "abbc";
        String s2 = "cbbc";
        //s1对象和s2对象进行比较
        int i =  s1.compareTo(s2);
        System.out.println(i);
    }


    /**
     * String类的构造方法  字节数组变成字符串
     * ASCII编码表
     */
    public static void constructor(){
        //构造方法的参数是byte[] 数组
        byte[] bytes = {97,98,99,100};
        //字节整数,查询ASCII编码表
        String str = new String(bytes);
        System.out.println(str);

        //构造方法参数是字节数组byte[] ,int 开始索引,int 个数
        //字节数组的一部分变成字符串
        String str2 = new String(bytes,1,2);
        System.out.println(str2);
    }
}
