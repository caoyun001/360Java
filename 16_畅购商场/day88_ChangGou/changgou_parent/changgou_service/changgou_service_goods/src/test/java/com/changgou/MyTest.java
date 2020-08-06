package com.changgou;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MyTest {

    @Test
    public void test(){
        try {
            String result = URLEncoder.encode("手机", "UTF-8");
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
