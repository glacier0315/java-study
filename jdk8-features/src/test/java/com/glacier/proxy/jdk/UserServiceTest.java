package com.glacier.proxy.jdk;

import com.glacier.proxy.jdk.dynamic.MyInvocationHandler;
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
    }
    
    @AfterEach
    void tearDown() {
    }
    
    @Test
    void findById1() {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.findById("1"));
    }
    
    @Test
    void findById2() {
        UserService userService = new UserServiceProxyImpl(new UserServiceImpl());
        System.out.println(userService.findById("1"));
    }
    
    @Test
    void findById3() {
        UserService userService = (UserService) Proxy.newProxyInstance(
                UserServiceImpl.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                new MyInvocationHandler(new UserServiceImpl()));
        System.out.println(userService.findById("1"));
    }
}
