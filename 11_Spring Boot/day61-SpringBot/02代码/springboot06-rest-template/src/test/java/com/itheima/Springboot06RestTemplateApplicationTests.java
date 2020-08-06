package com.itheima;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @SpringBootTest 代表当前类是一个SpringBoot的测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot06RestTemplateApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void contextLoads(){
        String forObject = restTemplate.getForObject("http://www.baidu.com/", String.class);
        System.out.println(forObject);
    }

}
