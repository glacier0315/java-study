package com.glacier.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * date 2021-06-04 09:46
 *
 * @author glacier
 * @version 1.0
 */
public class CglibProxyInterceptor implements MethodInterceptor {
    /**
     * 委托对象
     */
    private final Object target;
    
    public CglibProxyInterceptor(Object target) {
        this.target = target;
    }
    
    /**
     * 给目标对象创建一个代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类(代理对象)
        return en.create();
        
    }
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("进入Cglib代理类，准备开始增强业务");
        System.out.println("准备发送邮件");
        System.out.println("目标类名字：" + target.getClass().getName());
        System.out.println("方法名：" + method.getName());
        //执行目标对象方法，参数分别是 目标类对象 、当前方法注入参数
        Object returnValue = method.invoke(target, objects);
        System.out.println("准备退出Cglib代理类，增强业务结束，" + LocalDateTime.now());
        return returnValue;
    }
}
