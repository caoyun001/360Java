package com.itheima.utils;

import java.util.UUID;

/**
 *  java.util.UUID 随机字符串对象‘
 *  类静态方法  static UUID randomUUID()
 *  UUID对象调用方法 toString()
 */
public class UUIDUtils {
    public static void main(String[] args) {
        for(int x = 0 ; x < 10 ; x++) {
            UUID uuid = UUID.randomUUID();
            String string = uuid.toString();
            System.out.println(string.replace("-",""));
        }
    }
}
