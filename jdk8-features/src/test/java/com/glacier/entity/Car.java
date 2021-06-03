package com.glacier.entity;

import java.util.function.Supplier;

/**
 * date 2021-06-03 16:59
 *
 * @author glacier
 * @version 1.0
 */
public class Car {
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }
    
    public static void collide(final Car car) {
        System.out.println("静态方法引用 " + car.toString());
    }
    
    public void repair() {
        System.out.println("任意对象的方法引用 " + this.toString());
    }
    
    public void follow(final Car car) {
        System.out.println("特定对象的方法引用 " + car.toString());
    }
}
