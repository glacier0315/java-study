package com.glacier.proxy.jdk.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * date 2021-06-03 17:39
 *
 * @author glacier
 * @version 1.0
 */
public class MyInvocationHandler implements InvocationHandler {
    
    private final Object target;
    
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 进行业务增强
        System.out.println("JDK动态代理对业务进行了增强处理");
        // 通过反射调用方法本身
        Object obj = method.invoke(target, args);
        System.out.println("JDK动态代理对业务进行了增强处理结束");
        return obj;
    }
}
