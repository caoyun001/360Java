package com.itheima.stream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  练习: 文本排序
 *  已知文本,每个段落前面都有序号
 *  Java技术,对文本进行序号排序
 *
 *  实现步骤:
 *    1: 字符输入流,读取文本数据,行读
 *       每行就是一个段落
 *    2: 读取到的每个段落存储在集合中 ArrayList
 *
 *    3: 集合排序 : Collections.sort()按照序号排
 *      每段的第一个字符排序
 *
 *    4: 遍历集合,集合中排序后的写回文件去
 */
public class Test {
    public static void main(String[] args) throws IOException{
        //字符输入流,读取文本,读取行,BufferedReader缓冲流方法 readLine()
        BufferedReader bfr = new BufferedReader( new FileReader("day12/1.txt"));

        //创建List集合,存储读取到的文本内容
        List<String> list = new ArrayList<String>();

        String line = null;
        //读取文本一行
        while ( (line = bfr.readLine())!=null ){
            //字符串存储集合
            list.add(line);
        }

        //Collections工具类,对集合进行排序
        //方法sort可以传递比较器,自定义顺序
        //比较器是接口的实现类对象 Comparator
        Collections.sort(list,new Comparator<String>(){
            public int compare(String o1,String o2) {
                //取出字符串中第一个字符,序号,
                return o1.charAt(0) - o2.charAt(0);
            }
        });

      //  Collections.sort(list,(o1,o2)->o1.charAt(0)-o2.charAt(0));

        //字符输出流缓冲流
        BufferedWriter bfw = new BufferedWriter(new FileWriter("day12/2.txt"));
        for(String s : list){
            bfw.write(s);
            bfw.newLine();
            bfw.flush();
        }
        bfw.close();

        bfr.close();
    }
}
class StringSort implements Comparator<String>{
    /**
     *  o2-o1 降序
     *  o1-o2 升序
     *
     *  'a'-'b'
     */
    public int compare(String o1,String o2){
        //取出字符串中第一个字符,序号,
       return o1.charAt(0) - o2.charAt(0);
    }

}