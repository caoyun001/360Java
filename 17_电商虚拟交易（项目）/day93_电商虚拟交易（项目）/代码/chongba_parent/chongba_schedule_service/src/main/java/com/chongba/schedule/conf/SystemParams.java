package com.chongba.schedule.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 传智播客*黑马程序员.
 */
@Data
@ConfigurationProperties(prefix = "chongba")
@Component
public class SystemParams {
    
    private Integer preLoad;
}
