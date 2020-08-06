package com.chongba.schedule;

import com.alibaba.fastjson.JSON;
import com.chongba.cache.CacheService;
import com.chongba.entity.Constants;
import com.chongba.entity.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by 传智播客*黑马程序员.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScheduleApplication.class)
public class CacheServiceTest {
    
    @Autowired
    private CacheService cacheService;
    
    @Test
    public void test1(){
        cacheService.set("itcast","itcast1");
        String itcast = cacheService.get("itcast");
        System.out.println("获取的数据:"+itcast);
        cacheService.delete("itcast");
    }
    
    @Test
    public void test2(){
        cacheService.set("itheia","itheima");
        cacheService.expire("itheia",5, TimeUnit.SECONDS);

        cacheService.setEx("itheima1","itheima1",5,TimeUnit.SECONDS);
    }
    
    @Test
    public void test3(){
        cacheService.lRightPush("myList","猪八戒");
        cacheService.lRightPush("myList","齐天大圣孙悟空");
        cacheService.lRightPush("myList","沙悟净");

        cacheService.lLeftPush("myList","关老爷");
        cacheService.lLeftPush("myList","刘备");
        cacheService.lLeftPush("myList","张飞");
    }
    
    @Test
    public void test4(){
        String lLeftPop = cacheService.lLeftPop("myList");
        System.out.println(lLeftPop);
    }
    
    @Test
    public void test5(){
        cacheService.hPut("myHash","name","张三");
        cacheService.hPut("myHash","age","18");
        cacheService.hPut("myHash","sex","男");

        Map<String,String> map  = new HashMap<>();
        map.put("address","北京市昌平区");
        map.put("aaa","bbb");
        cacheService.hPutAll("myHash",map);

        // Object hGet = cacheService.hGet("myHash", "name");
    }
    
    @Test
     public void test6(){
        for(int i=0;i<100;i++){
            Task task = new Task();
            task.setTaskType(1001);
            task.setPriority(250);
            task.setParameters("CacheServiceTest".getBytes());
            task.setExecuteTime(System.currentTimeMillis());

            cacheService.zAdd("task", JSON.toJSONString(task),task.getExecuteTime());
        }
        cacheService.expire("task",5,TimeUnit.SECONDS);
        
        //获取数据

        /*Set<String> tasks = cacheService.zRange("task", 0, 10);
        for (String task : tasks) {
            System.out.println(task);
        }*/

       /* cacheService.zRange("task",0,-1);
        Set<String> tasks = cacheService.zRangeAll("task");
        for (String task : tasks) {
            System.out.println(task);
        }*/
       //获取当前需要执行的任务
       /* Set<String> tasks = cacheService.zRangeByScore("task", 0, System.currentTimeMillis());
        for (String task : tasks) {
            System.out.println(task);
        }*/


        Set<String> tasks = cacheService.zReverseRangeByScore("task", 0, System.currentTimeMillis());
        for (String task : tasks) {
            System.out.println(task);
        }
    }

    @Test
    public void testKeys(){
        Set<String> keys = cacheService.keys("future_*");
        System.out.println(keys);
        Set<String> scans = cacheService.scan("future_*");
        System.out.println(scans);
    }


    @Test
    public void testPiple2(){
        long start  = System.currentTimeMillis();
        for (int i=0;i<10000;i++) {
            cacheService.incrBy("pipelined",1);// stringRedisTemplate.opsForValue().increment(key, increment);
        }
        System.out.println("执行10000次自增操作共耗时:"+(System.currentTimeMillis()-start)+"毫秒");

        start  = System.currentTimeMillis();
        
        //使用管道技术
        List<Object> objectList = cacheService.getstringRedisTemplate().executePipelined(new RedisCallback<Object>() {
            @Nullable
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (int i = 0; i < 10000; i++) {
                    redisConnection.incrBy("pipelined".getBytes(), 1);
                }
                return null;
            }
        });
        System.out.println("使用管道技术执行10000次自增操作共耗时:"+(System.currentTimeMillis()-start)+"毫秒");
    }

    @Test
    public  void refreshPiplineTest(){
        List<String> list = new ArrayList<String>();
        long start=System.currentTimeMillis();
        for (int i = 0; i <10000 ; i++) {
            Task task = new Task();
            task.setExecuteTime(new Date().getTime());
            task.setTaskType(1001);
            task.setPriority(1);
            list.add(JSON.toJSONString(task));
            cacheService.lRightPush("1001_1",JSON.toJSONString(task));
        }
        
        System.out.println("未使用管道耗时" + (System.currentTimeMillis()-start));
        start=System.currentTimeMillis();
        String key="1000_1";
        cacheService.refreshWithPipeline(Constants.FUTURE+key, Constants.TOPIC+key, list);
        System.out.println("使用管道耗时" + (System.currentTimeMillis()-start));
    }
}
