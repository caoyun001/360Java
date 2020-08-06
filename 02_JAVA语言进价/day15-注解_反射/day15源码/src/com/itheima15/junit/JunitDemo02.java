package com.itheima.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  junit第三方的测试工具
 *
 *
 *  @Before 在...之前运行
 *  @Test运行方法
 *  @After 在....之后运行
 *
 *  IO对象
 *
 *  @Before 方法,创建流对象
 *  @Test 方法,写文件
 *  @After 方法释放资源
 */
public class JunitDemo02 {

    private FileWriter fw ;


    @Test
    public void test()throws IOException{
        fw.write("测试junit");
        fw.flush();
    }

    @After
    public void after()throws IOException{
        fw.close();
    }

    @Before
    public void before()throws IOException{
        //创建流对象
        fw = new FileWriter("e:/11.txt");
    }
}
