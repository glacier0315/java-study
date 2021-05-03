package com.glacier.demo;

/**
 * date 2021-05-03 14:16
 *
 * @author glacier
 * @version 1.0
 */
public interface JDK8Interface1 {

    //1.接口中可以定义静态方法了
    static void staticMethod() {
        System.out.println("接口中的静态方法");
    }

    //2.使用default之后就可以定义普通方法的方法体了
    default void defaultMethod() {
        System.out.println("接口中的默认方法");
    }
}