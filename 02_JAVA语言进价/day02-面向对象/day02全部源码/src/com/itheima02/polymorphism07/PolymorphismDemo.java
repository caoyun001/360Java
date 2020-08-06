package com.itheima.polymorphism07;

public class PolymorphismDemo {
    public static void main(String[] args) {
        //创建乒乓球教练对象,和运动员对象
        PingPangSport pingPangSport = new PingPangSport();
        //父类继承的方法,赋值
        pingPangSport.setName("张继科");
        pingPangSport.setAge(35);
        pingPangSport.sport();
        System.out.println(pingPangSport.getName());
        System.out.println(pingPangSport.getAge());

        PingPangCoach pingPangCoach = new PingPangCoach();
        pingPangCoach.setName("刘国梁");
        pingPangCoach.setAge(45);
        pingPangCoach.coach();
        System.out.println(pingPangCoach.getName());
        System.out.println(pingPangCoach.getAge());
        //乒乓球运动员学习英语
        pingPangSport.speakEnglish();
        //乒乓球教练员学习英语
        pingPangCoach.speakEnglish();
    }
}
