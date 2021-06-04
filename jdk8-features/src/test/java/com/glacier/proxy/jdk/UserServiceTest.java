package com.glacier.proxy.jdk;

import com.glacier.proxy.cglib.BizUserService;
import com.glacier.proxy.cglib.CglibProxyInterceptor;
import com.glacier.proxy.jdk.dynamic.MyAdapterInvocationHandler;
import com.glacier.proxy.jdk.dynamic.MyInvocationHandler;
import com.glacier.proxy.jdk.impl.UserServiceAdapterImpl;
import com.glacier.proxy.jdk.impl.UserServiceImpl;
import com.glacier.proxy.jdk.impl.UserServiceProxyImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * date 2021-06-03 17:35
 *
 * @author glacier
 * @version 1.0
 */
class UserServiceTest {
    
    @BeforeEach
    void setUp() {
        System.getProperties()
                .put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", true);
    }
    
    @AfterEach
    void tearDown() {
    }
    
    @Test
    void findById1() {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.findById("1"));
    }
    
    /**
     * 静态代理
     */
    @Test
    void findById2() {
        System.out.println("静态代理");
        UserService userService = new UserServiceProxyImpl(new UserServiceImpl());
        System.out.println(userService.findById("1"));
    }
    
    /**
     * jdk动态代理
     */
    @Test
    void findById3() {
        System.out.println("jdk动态代理");
        UserService userService = (UserService) Proxy.newProxyInstance(
                UserServiceImpl.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                new MyInvocationHandler(new UserServiceImpl()));
        System.out.println(userService.findById("1"));
    }
    
    /**
     * jdk动态代理穿透
     */
    @Test
    void findById4() {
        System.out.println("jdk动态代理穿透");
        UserService userService = (UserService) Proxy.newProxyInstance(
                UserService.class.getClassLoader(),
                new Class[]{UserService.class},
                new MyAdapterInvocationHandler(new UserServiceAdapterImpl()));
        System.out.println(userService.findById("1"));
    }
    
    
    /**
     * Cglib代理
     */
    @Test
    void findById5() {
        System.out.println("Cglib代理");
        BizUserService userService = (BizUserService) new CglibProxyInterceptor(new BizUserService())
                .getProxyInstance();
        System.out.println(userService.findById("1"));
    }
}
