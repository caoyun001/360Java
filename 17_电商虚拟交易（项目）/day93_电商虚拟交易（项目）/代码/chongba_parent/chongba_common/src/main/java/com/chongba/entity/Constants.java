package com.chongba.entity;

/**
 * Created by 传智播客*黑马程序员.
 */
public class Constants {

    //task状态
    public static final int SCHEDULED=0;	//初始化状态

    public static final int EXECUTED=1;		//已执行状态

    public static final int CANCELLED=2;	//已取消状态

    public static String DBCACHE="db_cache";

    public static String FUTURE="future_";

    public static String TOPIC="topic_";

    public static final String schedule_leaderPath="/chongba/schedule_master";
    
    public static final String job_leaderPath="/chongba/job_master";

    public static final String nextScheduleTime = "nextScheduleTime";
}
