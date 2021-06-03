package com.glacier.lambda;

import com.glacier.entity.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * date 2021-06-03 16:57
 *
 * @author glacier
 * @version 1.0
 */
class LambdaTest {
    public List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    @BeforeEach
    void setUp() {
    }
    
    @AfterEach
    void tearDown() {
    }
    
    /**
     * 1.Lambda表达式
     */
    @Test
    public void testLambda() {
        this.list.forEach(System.out::println);
        this.list.forEach(e -> System.out.println("方式二：" + e));
    }
    
    /**
     * 2.Stream函数式操作流元素集合
     */
    @Test
    public void testStream() {
        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        System.out.println("求和：" + nums
                .stream()//转成Stream
                .filter(Objects::nonNull)//过滤
                .distinct()//去重
                .mapToInt(num -> num * 2)//map操作
                .skip(2)//跳过前2个元素
                .limit(4)//限制取前4个元素
                .peek(System.out::println)//流式处理对象函数
                .sum());//
    }
    
    /**
     * 4.方法引用,与Lambda表达式联合使用
     */
    @Test
    public void testMethodReference() {
        //构造器引用。语法是Class::new，或者更一般的Class< T >::new，要求构造器方法是没有参数；
        final Car car = Car.create(Car::new);
        final List<Car> cars = Collections.singletonList(car);
        //静态方法引用。语法是Class::static_method，要求接受一个Class类型的参数；
        cars.forEach(Car::collide);
        //任意对象的方法引用。它的语法是Class::method。无参，所有元素调用；
        cars.forEach(Car::repair);
        //特定对象的方法引用，它的语法是instance::method。有参，在某个对象上调用方法，将列表元素作为参数传入；
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
    
    /**
     * 9.数组并行（parallel）操作
     */
    @Test
    public void testParallel() {
        long[] arrayOfLong = new long[20000];
        //1.给数组随机赋值
        Arrays.parallelSetAll(arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt(1000000));
        //2.打印出前10个元素
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();
        //3.数组排序
        Arrays.parallelSort(arrayOfLong);
        //4.打印排序后的前10个元素
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();
    }
}
