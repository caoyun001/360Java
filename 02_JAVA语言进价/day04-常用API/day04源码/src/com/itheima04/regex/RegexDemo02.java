package com.itheima.regex;

import java.util.Arrays;

/**
 * QQ号码验证案例,字符串处理复杂
 * 引入正则表达式简化字符串处理
 * 正则表达式本质是一种规则
 *
 * 1: 字符规则
 *  [abc]        字符必须是abc
 *  [a-z]        字符必须是小写字母
 *  [a-zA-Z]     字符必须是字母
 *  [0-9]        字符必须是数字
 *  [a-zA-Z0-9_] 字符必须是数字,字母,或者是下划线
 *  [^0-9]       字符不能是数字
 *  [^a-z]       字符不能是小写字母
 *
 * 2: 预定义字符
 *  [\d]          等同于[0-9]
 *  [\D]          等同于[^0-9]
 *  [\w]          等同于[a-zA-Z0-9_]
 *  [\W]          等同于[^a-zA-Z0-9_]
 *  .             匹配任意字符
 *
 *  3: 长度字符
 *   X?         X字符出现的次数,一次或者是一次也没有
 *   X*         X字符出现的次数,是零次或者多次
 *   X+         X字符出现的次数,一次或者多次
 *   X{m}       X字符出现的次数,必须是m次
 *   X{m,}      X字符出现的次数,至少m次
 *   X{m,n}     X字符出现的次数,至少m次,不超过n次
 *
 *   API: java.util.regex.Pattern
 */
public class RegexDemo02 {
    public static void main(String[] args) {
        method_4();
    }
    /**
     *  正则表达式的切割方法
     *  split()
     */
    public static void method_4(){
        String str = "192......168..........120..188";
        String[] arr = str.split("\\.+");
        for(int i = 0 ; i < arr.length ;i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * 正则表达式的匹配方法
     * String类方法boolean matches("规则")
     * 字符串是否和规则匹配,完全匹配返回true
     * 邮件地址:
     *   abcd@sina.com
     *   1234567890@qq.com
     *   abcde123@126.com
     *   123_ew@gmail.com
     *
     *   规则:
     *     @前:  数字字母下划线 +
     *     @后:  字母,数字 +
     *     . 后面字母 +
     *
     *    转义字符 \  转义后面的字符
     */
    public static void method_3(){

        //System.out.println("\"Hello\"");


        String email = "12356@qq.com.cn";
        String reg = "[a-zA-Z0-9_]+@[a-z0-9]+(\\.[a-z]+)+";
        boolean b = email.matches(reg);
        System.out.println(b);
    }

    /**
     * 正则表达式的匹配方法
     * String类方法boolean matches("规则")
     * 字符串是否和规则匹配,完全匹配返回true
     * 验证手机号
     *  规则:
     *    11位
     *    全数字
     *    1开头
     *    第二位可以是 34578
     */
    public static void method_2(){
        String tel = "13800138000";
        String reg = "1[37458][0-9]{9}";
        boolean b = tel.matches(reg);
        System.out.println(b);
    }
    /**
     * 正则表达式的匹配方法
     * String类方法boolean matches("规则")
     * 字符串是否和规则匹配,完全匹配返回true
     */
    public static void method(){
        String q = "12345678901";
        //定义规则,验证QQ号码
        String reg = "[1-9][0-9]{5,9}";
        //字符串对象,调用方法matches(规则)
        boolean b = q.matches(reg);
        System.out.println(b);
    }
}
