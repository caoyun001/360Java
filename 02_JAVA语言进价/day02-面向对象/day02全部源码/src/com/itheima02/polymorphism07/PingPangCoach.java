package com.itheima.polymorphism07;
/**
 * 乒乓球教练员,继承教练员类
 * 出国交流,学习英语,实现英语接口
 */
public class PingPangCoach extends Coach implements English{
    @Override
    public void coach() {
        System.out.println("乒乓球教练员指导发球");
    }

    @Override
    public void speakEnglish() {
        System.out.println("乒乓球教练员学习英语");
    }
}
