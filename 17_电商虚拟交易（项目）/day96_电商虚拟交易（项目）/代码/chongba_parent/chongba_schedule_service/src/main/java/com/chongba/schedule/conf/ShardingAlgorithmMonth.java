package com.chongba.schedule.conf;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * Created by 传智播客*黑马程序员.
 */
@Slf4j
public class ShardingAlgorithmMonth implements PreciseShardingAlgorithm<Date> {

    /**
     * 执行分片策略
     * @param collection                所有候选表的集合--所有表的名称
     * @param preciseShardingValue      精确分片值-----任务的执行时间
     * @return                          路由匹配的表名称                
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {
        String nodeName = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_M");
            String format = simpleDateFormat.format(preciseShardingValue.getValue());
            for (String tableName : collection) {
                if(tableName.endsWith(format)){
                    nodeName = tableName;
                    break;
                }
            }
        } catch (Exception e) {
            log.error("doSharding exception");
        }
        return nodeName;
    }
}
