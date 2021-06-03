package com.glacier.proxy.jdk.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * date 2021-06-03 17:47
 *
 * @author glacier
 * @version 1.0
 */
public class UserServiceDynamicProxy {
    private Object target;
    private InvocationHandler invocationHandler;
    
    public UserServiceDynamicProxy(Object target, InvocationHandler invocationHandler){
        this.target = target;
        this.invocationHandler = invocationHandler;
    }
    
    public Object getPersonProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocationHandler);
    }
}
