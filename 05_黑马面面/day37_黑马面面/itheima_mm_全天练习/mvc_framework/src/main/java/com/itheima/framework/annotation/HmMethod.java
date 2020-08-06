package com.itheima.framework.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/9
 * @description ：存储对象方法信息
 * @version: 1.0
 */
@Data
@AllArgsConstructor
public class HmMethod {
    private Method method;      // 当前对象某一方法实例
    private Class clazz;        // 当前对象类的字节码实例
    private Object instance;    // 对象
}
