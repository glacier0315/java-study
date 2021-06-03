package com.glacier.inter.impl;

import com.glacier.inter.Jdk8Interface1;

/**
 * date 2021-05-03 14:16
 *
 * @author glacier
 * @version 1.0
 */
public class Jdk8InterfaceImpl1 implements Jdk8Interface1 {
    
    /**
     * 实现接口后，因为默认方法不是抽象方法，重写/不重写都成！
     */
//    @Override
//    public void defaultMethod() {
//        System.out.println("接口中的默认方法");
//    }
    
    @Override
    public void test() {
        System.out.println("实现接口1中的方法");
    }
}
