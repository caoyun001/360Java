package com.itheima.regex;

/**
 * 正则表达式(regex):
 *   是对字符串的一种处理技术
 *   String,StringBuilder 功能远远不够用
 *   处理更加复杂字符串
 */
public class RegexDemo {
    public static void main(String[] args) {
        /**
         * 字符串的技术,实现功能
         * String q = "12345689"
         * 检查这个字符串中内容是不是符合一个QQ号码的规则
         * QQ规则:
         *    是数字
         *    不能0开头
         *    长度6-10
         */String q = "12345689";

        if(q.length() < 6 || q.length() > 10){
            System.out.println("长度不对");
        }

        char[] chars = q.toCharArray();
        for(int i = 0 ; i < chars.length ;i++){
            if( !(chars[i] >=48 && chars[i] <= 57) ){
                System.out.println("不是数字");
            }
        }

        q.startsWith("0");
    }
}
