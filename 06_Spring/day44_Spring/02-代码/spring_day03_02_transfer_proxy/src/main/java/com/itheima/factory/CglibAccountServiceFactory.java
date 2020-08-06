package com.itheima.factory;

import com.itheima.service.AccountService;
import com.itheima.utils.TransactionManager;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/*
    基于CgLib的动态代理( 第三方jar包 )
    作用: 用于创建AccountService 动态代理对象的 工厂类
 */
@Component
public class CglibAccountServiceFactory {

    //指定被代理对象(AccountServiceImpl对象)
    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;
    @Autowired
    private TransactionManager transactionManager;

    //用于创建AccountService 动态代理对象
    @Bean("cgLibAccountService")
    public AccountService createAccountServiceProxy(){
        //创建AccountService 的动态代理对象
        AccountService cgLibAccountService = (AccountService) Enhancer.create(
                accountService.getClass(),
                new MethodInterceptor() {
                    /**
                     * intercept 方法,  就是对原有功能方法的增强
                     * @param proxy 就是创建出来的动态代理对象的引用
                     * @param method 被代理对象 所要执行的方法
                     * @param objects 被代理对象 所要执行的方法 所接收的实际参数值
                     * @param methodProxy 所要执行的方法的代理对象  method.invoke()
                     */
                    @Override
                    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        System.out.println("被代理对象 = " + accountService);
                        System.out.println("被增强的方法 = " + method.getName());
                        System.out.println("被增强的方法 所接收的实际参数值 = " + Arrays.toString(objects));
                        Object rtValue = null;
                        try {
                            //开启事务(增强)
                            transactionManager.begin();
                            //调用 被代理对象 的原有方法
                            rtValue = method.invoke(accountService, objects);
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
                });

        return cgLibAccountService;
    }
}
