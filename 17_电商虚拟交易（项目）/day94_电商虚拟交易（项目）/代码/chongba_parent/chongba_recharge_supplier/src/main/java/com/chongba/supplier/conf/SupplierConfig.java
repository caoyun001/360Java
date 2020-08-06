package com.chongba.supplier.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by 传智播客*黑马程序员.
 */
@Data
@ConfigurationProperties(prefix = "supplier")
@Component
public class SupplierConfig {
    
    private Map<String,String> apis;

    private int maxrepeat;//最大重试次数
}
