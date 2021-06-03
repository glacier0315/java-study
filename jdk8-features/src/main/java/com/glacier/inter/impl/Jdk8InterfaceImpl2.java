package com.glacier.inter.impl;

import com.glacier.inter.Jdk8Interface1;
import com.glacier.inter.Jdk8Interface2;

/**
 * date 2021-05-03 14:16
 *
 * @author glacier
 * @version 1.0
 */
public class Jdk8InterfaceImpl2 implements Jdk8Interface1, Jdk8Interface2 {
    
    /**
     * 实现接口后，默认方法名相同，必须复写默认方法
     */
    @Override
    public void defaultMethod() {
        //接口的
        Jdk8Interface1.super.defaultMethod();
        System.out.println("实现类复写重名默认方法！！！！");
    }
    
    @Override
    public void test() {
        System.out.println("实现接口1中的方法");
    }
}
