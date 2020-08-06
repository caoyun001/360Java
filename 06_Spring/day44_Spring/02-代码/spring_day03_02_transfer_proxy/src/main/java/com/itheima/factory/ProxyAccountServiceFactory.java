package com.itheima.factory;

import com.itheima.service.AccountService;
import com.itheima.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/*
    基于JDK的动态代理( Proxy )
    作用: 用于创建AccountService 动态代理对象的 工厂类
 */
@Component
public class ProxyAccountServiceFactory {

    //指定被代理对象(AccountServiceImpl对象)
    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;
    @Autowired
    private TransactionManager transactionManager;

    //用于创建AccountService 动态代理对象
    @Bean("proxyAccountService")
    public AccountService createAccountServiceProxy(){
        //创建AccountService 的动态代理对象
        /**
         * 参数一: 被代理对象的类加载器
         * 参数二: 被代理对象 所实现的所有接口
         * 参数三: 指定原有方法 如何进行增强
         */
        AccountService proxyAccountService = (AccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * invoke 方法, 就是对原有功能方法的增强
                     * @param proxy 就是创建出来的动态代理对象的引用
                     * @param method 被代理对象 所要执行的方法
                     * @param args 被代理对象 所要执行的方法 所接收的实际参数值
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("被代理对象 = " + accountService);
                        System.out.println("被增强的方法 = " + method.getName());
                        System.out.println("被增强的方法 所接收的实际参数值 = " + Arrays.toString(args));
                        Object rtValue = null;
                        try {
                            //开启事务(增强)
                            transactionManager.begin();
                            //调用 被代理对象 的原有方法
                            rtValue = method.invoke(accountService, args);
                            //提交事务(增强)
                            transactionManager.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            //回滚事务(增强)
                            transactionManager.rollback();
                        } finally {
                            //释放连接(增强)
                            transactionManager.close();
                        }
                        return rtValue;
                    }
                }
        );
        return proxyAccountService;
    }
}
