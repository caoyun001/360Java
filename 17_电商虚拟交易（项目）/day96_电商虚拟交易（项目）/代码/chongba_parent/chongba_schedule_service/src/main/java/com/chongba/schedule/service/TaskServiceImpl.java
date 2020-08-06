package com.chongba.schedule.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chongba.cache.CacheService;
import com.chongba.entity.Constants;
import com.chongba.entity.Task;
import com.chongba.exception.ScheduleSystemException;
import com.chongba.exception.TaskNotExistException;
import com.chongba.schedule.conf.SystemParams;
import com.chongba.schedule.inf.TaskService;
import com.chongba.schedule.mapper.TaskInfoLogsMapper;
import com.chongba.schedule.mapper.TaskInfoMapper;
import com.chongba.schedule.pojo.TaskInfoEntity;
import com.chongba.schedule.pojo.TaskInfoLogsEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by 传智播客*黑马程序员.
 */
@Service
@Slf4j
public class TaskServiceImpl implements TaskService {
    
    
    private static final Logger threadLogger = LoggerFactory.getLogger("thread");
    
    @Autowired
    private TaskInfoMapper infoMapper;
    
    @Autowired
    private TaskInfoLogsMapper logsMapper;
    
    @Autowired
    private CacheService cacheService;
    
    @Resource(name = "visiableThreadPool")
    private ThreadPoolTaskExecutor threadPool;
    
    private long nextScheduleTime;
    
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    
    @Autowired
    private SystemParams systemParams;
    
    @Autowired
    private SelectMaster selectMaster;
    
    @PostConstruct
    public  void syncData(){
        /**
         * 清除缓存原有数据：编写：clearCache()
         查询所有任务数据：调用 taskMapper.selectAll()
         将任务数据放入缓存：封装Task，调用addTaskToCache(task);
         */
        // 选主----
        selectMaster.selectMaster(Constants.schedule_leaderPath);

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPoolTaskScheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                //只有主节点才能去进行数据的恢复
                boolean master = selectMaster.checkMaster(Constants.schedule_leaderPath);
                if(master){
                    //是主节点
                    threadLogger.info("schedule-service的主节点进行数据恢复---reloadData");
                    reloadData();
                }else {
                    //从节点
                    threadLogger.info("schedule-service的从节点进行备份");
                }
            }
        },TimeUnit.MINUTES.toMillis(systemParams.getPreLoad()));//硬编码
        
    }
    
    private void reloadData(){
        System.out.println("init");
        clearCache();
        //查询所有任务类型和优先级的分组
        QueryWrapper<TaskInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.select("task_type","priority");
        wrapper.groupBy("task_type","priority");
        List<Map<String, Object>> maps = infoMapper.selectMaps(wrapper);
        long start = System.currentTimeMillis();

        CountDownLatch latch = new CountDownLatch(maps.size());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,systemParams.getPreLoad());
        nextScheduleTime = calendar.getTimeInMillis();
        cacheService.set(Constants.nextScheduleTime,nextScheduleTime+"");
        for (Map<String, Object> map : maps) {

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String task_type = String.valueOf(map.get("task_type"));
                    String priority = String.valueOf(map.get("priority"));
                    //根据任务类型和优先级去查询该组下的任务数据
                    //List<TaskInfoEntity> allTasks = infoMapper.queryAll(Integer.parseInt(task_type), Integer.parseInt(priority));
                    List<TaskInfoEntity> allTasks = infoMapper.queryFuture(Integer.parseInt(task_type), Integer.parseInt(priority),calendar.getTime());
                    if(allTasks!=null && ! allTasks.isEmpty()){
                        for (TaskInfoEntity taskInfoEntity : allTasks) {
                            Task task = new Task();
                            BeanUtils.copyProperties(taskInfoEntity,task);
                            task.setExecuteTime(taskInfoEntity.getExecuteTime().getTime());
                            addTaskToCache(task);
                        }
                    }

                    latch.countDown();
                    threadLogger.info("当前线程名称{},计数器的值{},当前分组数据恢复的时间{}",
                            Thread.currentThread().getName(),latch.getCount(),System.currentTimeMillis()-start);
                }
            });
        }

        try {
            //阻塞当前线程 当latch=0结束阻塞
            latch.await(5,TimeUnit.MINUTES);
            threadLogger.info("数据恢复完成，耗时{}",System.currentTimeMillis()-start);
        } catch (InterruptedException e) {
            threadLogger.error("数据恢复出现异常，异常信息{}",e.getMessage());
        }
    }
    
    private void clearCache(){
        //  cacheService.delete(Constants.DBCACHE);
        // 删除缓存中未来数据集合和当前消费者队列的所有key
        Set<String> futurekeys = cacheService.scan(Constants.FUTURE + "*");// future_
        Set<String> topickeys = cacheService.scan(Constants.TOPIC + "*");// topic_
        cacheService.delete(futurekeys);
        cacheService.delete(topickeys);
    }
    
    
    @Override
    @Transactional
    public long addTask(Task task) throws ScheduleSystemException {
        /**
         * 向任务表中添加数据
         * 向任务日志表中添加数据
         */
        /**
         * - 先将任务添加到数据库：boolean addTaskToDb(Task task)
         - 添加成功后，将任务添加到缓存：void addTaskToCache(Task task)
         */

        Future<Long> future = threadPool.submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                boolean sucess = addTaskToDb(task);
                if(sucess){
                    addTaskToCache(task);
                }
                return task.getTaskId();
            }
        });
        Long taskId = -1L;
        try {
            taskId = future.get(5, TimeUnit.MINUTES);
        } catch (Exception e) {
            threadLogger.error("add taskException,task={}",task);
            throw new ScheduleSystemException(e);
        }
        return taskId;
        /*boolean sucess = addTaskToDb(task);
        if(sucess){
            addTaskToCache(task);
        }
        return task.getTaskId();*/
    }
    public boolean addTaskToDb(Task task) {
        boolean success = false;
        try {
            TaskInfoEntity infoEntity = new TaskInfoEntity();
            infoEntity.setTaskType(task.getTaskType());
            infoEntity.setPriority(task.getPriority());
            infoEntity.setParameters(task.getParameters());
            infoEntity.setExecuteTime(new Date(task.getExecuteTime()));

            infoMapper.insert(infoEntity);
            task.setTaskId(infoEntity.getTaskId());
            

            TaskInfoLogsEntity logsEntity = new TaskInfoLogsEntity();
            logsEntity.setTaskId(infoEntity.getTaskId());
            logsEntity.setTaskType(infoEntity.getTaskType());
            logsEntity.setPriority(infoEntity.getPriority());
            logsEntity.setParameters(infoEntity.getParameters());
            logsEntity.setExecuteTime(infoEntity.getExecuteTime());
            logsEntity.setVersion(1);
            logsEntity.setStatus(Constants.SCHEDULED);
            logsMapper.insert(logsEntity);
            success = true;
        } catch (Exception e) {
            //日志记录
            log.error("add task exception ,taskId={}",task.getTaskId());
            throw new ScheduleSystemException(e.getMessage());
        }
        return success;
    }

    private void addTaskToCache(Task task) {
        // zSet
        String key = task.getTaskType()+"_"+task.getPriority();
        long nextScheduleTime = getNextScheduleTime();
        if(task.getExecuteTime() <= System.currentTimeMillis()){
            //消费者队列中
            cacheService.lLeftPush(Constants.TOPIC+key,JSON.toJSONString(task));// topic_1001_250
        }else if(task.getExecuteTime() <= nextScheduleTime) {
            //未来数据集合
            cacheService.zAdd(Constants.FUTURE+key,JSON.toJSONString(task),task.getExecuteTime());// future_1001_250
        }
        
        //cacheService.zAdd(Constants.DBCACHE, JSON.toJSONString(task),task.getExecuteTime());
    }

    private long getNextScheduleTime() {
        if(cacheService.exists(Constants.nextScheduleTime)){
            String nextScheduleTimeStr = cacheService.get(Constants.nextScheduleTime);
            log.info("从缓存中获取nextScheduleTime,{}",nextScheduleTimeStr);
            return Long.parseLong(nextScheduleTimeStr);
        }else {
            //数据补偿
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE,systemParams.getPreLoad());
            nextScheduleTime = calendar.getTimeInMillis();
            log.info("缓存中没有nextScheduleTime,做数据补偿,{}",nextScheduleTime);
            return nextScheduleTime;
        }
    }

    @Override
    @Transactional
    public boolean cancelTask(long taskId) throws TaskNotExistException {
        /**
         * 删除任务表中数据
         * 更新日志表中的任务状态:2
         */
        /**
         * - 根据任务id更新数据库Task updateDb(long taskId,int status)：删除任务表数据，更新任务日志表状态为已取消
         - 更新完成后返回任务对象Task，从redis中删除任务数据 removeTaskFromCache(Task task)
         */
        boolean success = false;
        Task task = updateDb(taskId, Constants.CANCELLED);
        if(task!=null){
            removeTaskFromCache(task);
            success = true;
        }
        return success;
    }



    private Task updateDb(long taskId,int status) throws TaskNotExistException{
        Task task = null;
        try {
            //删除任务表中的数据
            infoMapper.deleteById(taskId);
            //更新日志表中的状态为取消状态
            TaskInfoLogsEntity logsEntity = logsMapper.selectById(taskId);
            logsEntity.setStatus(status);
            logsMapper.updateById(logsEntity);

            //构造task对象并返回
            task = new Task();
            // task.setTaskType(logsEntity.getTaskType());
            BeanUtils.copyProperties(logsEntity,task);// 基于反射
            task.setExecuteTime(logsEntity.getExecuteTime().getTime());
        } catch (Exception e) {
            log.error("cancel task exception ,taskId={}",taskId);
            throw  new TaskNotExistException(e.getMessage());
        }
        return task;
    }
    
    private void removeTaskFromCache(Task task){
        // cacheService.zRemove(Constants.DBCACHE,JSON.toJSONString(task));
        String key = task.getTaskType()+"_"+task.getPriority();
        if(task.getExecuteTime() <= System.currentTimeMillis()){
            cacheService.lRemove(Constants.TOPIC+key,0,JSON.toJSONString(task));
        }else {
            cacheService.zRemove(Constants.FUTURE+key,JSON.toJSONString(task));
        }
    }

    @Override
    public long size(int type,int priority) {
        // 当前分组下的所有可执行任务数量   未来数据集合+消费者队列
        String key = type+"_"+priority;
        Set<String> futures = cacheService.zRangeAll(Constants.FUTURE + key);
        Long len = cacheService.lLen(Constants.TOPIC + key);
        return  futures.size() + len;
        /*Set<String> allTasks = cacheService.zRangeAll(Constants.DBCACHE);
        return allTasks.size();*/
    }

    @Override
    @Transactional
    public Task poll(int type,int priority) throws TaskNotExistException {

        Future<Task> future = threadPool.submit(new Callable<Task>() {
            @Override
            public Task call() throws Exception {
                Task task = null;
                try {
                    String key  = type+"_"+priority;
                    String task_json = cacheService.lRightPop(Constants.TOPIC + key);
                    if(!StringUtils.isEmpty(task_json)){
                        task = JSON.parseObject(task_json,Task.class);
                        // 更新数据库中的数据
                        updateDb(task.getTaskId(),Constants.EXECUTED);
                    }
                } catch (TaskNotExistException e) {
                    threadLogger.error("poll task exception,type={},priority={}",type,priority);
                    throw  new TaskNotExistException(e);
                }
                return task;
            }
        });
        Task task = null;
        try {
            task = future.get(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            threadLogger.error("poll task exception,type={},priority={}",type,priority);
            throw  new TaskNotExistException(e);
        }
        return task;
        
       /* Task task = null;
        try {
            String key  = type+"_"+priority;
            String task_json = cacheService.lRightPop(Constants.TOPIC + key);
            if(!StringUtils.isEmpty(task_json)){
                task = JSON.parseObject(task_json,Task.class);
                // 更新数据库中的数据
                updateDb(task.getTaskId(),Constants.EXECUTED);
            }
        } catch (TaskNotExistException e) {
            log.error("poll task exception,type={},priority={}",type,priority);
            throw  new TaskNotExistException(e);
        }
        return task;*/
    }
    /*@Override
    @Transactional
    public Task poll(int type,int priority) throws TaskNotExistException {
        Task task = null;
        //拉取当前需要执行的任务数据
        Set<String> byScore = cacheService.zRangeByScore(Constants.DBCACHE, 0, System.currentTimeMillis());
        if(byScore!=null && ! byScore.isEmpty()){

            String task_json = byScore.iterator().next();
            if(!StringUtils.isEmpty(task_json)){

                task = JSON.parseObject(task_json, Task.class);
                //从缓存中删除已消费的元素
                cacheService.zRemove(Constants.DBCACHE,task_json);
                // 更新数据库信息
                updateDb(task.getTaskId(),Constants.EXECUTED);
            }
        }
        return task;
    }*/
    
    // @Scheduled(cron = "*/1 * * * * ?")
    public void refresh(){
        System.out.println(System.currentTimeMillis()/1000+"执行了定时任务");

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                // 获取所有未来数据集合的key值
                Set<String> futureKeys = cacheService.scan(Constants.FUTURE + "*");// future_*
                for (String futureKey : futureKeys) { // future_250_250

                    String topicKey = Constants.TOPIC+ futureKey.split(Constants.FUTURE)[1];
                    //获取该组key下当前需要消费的任务数据
                    Set<String> tasks = cacheService.zRangeByScore(futureKey, 0, System.currentTimeMillis());
                    if(!tasks.isEmpty()){
                        //将这些任务数据添加到消费者队列中
                /*for (String task : tasks) { // topic_250_250
                    cacheService.lLeftPush(topicKey,task);
                    cacheService.zRemove(futureKey,task);
                }*/
                        cacheService.refreshWithPipeline(futureKey,topicKey,tasks);
                        System.out.println("成功的将"+futureKey+"下的当前需要执行的任务数据刷新到"+topicKey+"下");
                    }
                }
            }
        });
    }
}
