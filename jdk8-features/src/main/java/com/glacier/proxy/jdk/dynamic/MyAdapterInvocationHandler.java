package com.glacier.proxy.jdk.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * date 2021-06-03 17:39
 *
 * @author glacier
 * @version 1.0
 */
public class MyAdapterInvocationHandler implements InvocationHandler {
    
    /**
     * 委托对象
     */
    private final Object target;
    
    public MyAdapterInvocationHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理 代理穿透");
        // 进行业务增强
        System.out.println("JDK动态代理对业务进行了增强处理");
        // 通过反射调用方法本身
        Object obj = target.getClass()
                .getMethod(method.getName(),
                        Arrays.stream(args)
                                .map(Object::getClass)
                                .collect(Collectors.toList())
                                .toArray(new Class[args.length]))
                .invoke(target, args);
        System.out.println("JDK动态代理对业务进行了增强处理结束");
        return obj;
    }
}
