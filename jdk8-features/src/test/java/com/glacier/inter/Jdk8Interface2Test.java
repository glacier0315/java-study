package com.glacier.inter;

import com.glacier.inter.impl.Jdk8InterfaceImpl2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * date 2021-06-03 16:55
 *
 * @author glacier
 * @version 1.0
 */
class Jdk8Interface2Test {
    
    @BeforeEach
    void setUp() {
    }
    
    @AfterEach
    void tearDown() {
    }
    
    @Test
    void staticMethod() {
        //可以直接使用接口名.静态方法来访问接口中的静态方法
        Jdk8Interface2.staticMethod();
    }
    
    @Test
    void defaultMethod() {
        new Jdk8InterfaceImpl2()
                .defaultMethod();
    }

}
