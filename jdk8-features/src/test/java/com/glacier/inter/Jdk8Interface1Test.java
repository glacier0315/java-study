package com.glacier.inter;

import com.glacier.inter.impl.Jdk8InterfaceImpl1;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * date 2021-06-03 16:55
 *
 * @author glacier
 * @version 1.0
 */
class Jdk8Interface1Test {
    
    @BeforeEach
    void setUp() {
    }
    
    @AfterEach
    void tearDown() {
    }
    
    /**
     * 3.接口新增：默认方法与静态方法
     * default 接口默认实现方法是为了让集合类默认实现这些函数式处理，而不用修改现有代码
     * （List继承于Iterable<T>，接口默认方法不必须实现default forEach方法）
     */
    @Test
    void staticMethod() {
        //可以直接使用接口名.静态方法来访问接口中的静态方法
        Jdk8Interface1.staticMethod();
    }
    
    @Test
    void defaultMethod() {
        new Jdk8InterfaceImpl1()
                .defaultMethod();
    }
    
    @Test
    void test1() {
        new Jdk8InterfaceImpl1()
                .test();
    }
}
