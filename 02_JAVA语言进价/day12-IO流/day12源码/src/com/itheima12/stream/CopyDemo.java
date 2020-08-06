package com.itheima.stream;

/**
 * 字符流: 文本文件
 *   Writer  方法write写入数据,字符,数组,字符串
 *     OutputStreamWriter 指定编码表写入数据
 *       FileWriter 默认编码表
 *
 *
 *   Reader 方法read读取数据,字符,数组
 *     InputStreamReader 指定编码表读取文件
 *     FileReader 默认编码表
 *
 *  字符流复制文本文件 ,用法是错误的
 *  前提: 必须知道复制的文件的编码
 *
 *
 *  需要文件的复制,使用字节流 (专门)
 */
public class CopyDemo {
}
