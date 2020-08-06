package com.chongba.schedule.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by 传智播客*黑马程序员.
 */
@Component
public class AsyncTask {
    
    @Async("mythreadpool")
    public void asyncTask(){
        
        System.out.println("spring boot async task test " +
                Thread.currentThread().getName());
    }
}
