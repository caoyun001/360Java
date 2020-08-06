package com.itheima.polymorphism07;

/**
 * 乒乓球运动员,继承运动员
 * 出国交流,学习英语,实现英语接口
 */
public class PingPangSport extends Sport implements English {


    public void sport() {
        System.out.println("乒乓球运动员比赛");
    }

    @Override
    public void speakEnglish() {
        System.out.println("乒乓球运动员在学习英语");
    }
}
