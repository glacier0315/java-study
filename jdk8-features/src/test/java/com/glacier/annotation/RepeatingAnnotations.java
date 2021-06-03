package com.glacier.annotation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * date 2021-05-03 14:16
 * 重复注解@Repeatable
 *
 * @author glacier
 * @version 1.0
 */
class RepeatingAnnotations {
    
    @BeforeEach
    void setUp() {
    }
    
    @AfterEach
    void tearDown() {
    }
    
    /**
     * 5.引入重复注解
     * 1.@Repeatable
     * 2.可以不用以前的“注解容器”写法，直接写2次相同注解即可
     * <p>
     * Java 8在编译器层做了优化，相同注解会以集合的方式保存，因此底层的原理并没有变化。
     */
    @Test
    void test() {
        //获取注解后遍历打印值
        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter.value() + "\t" + filter.value2());
        }
    }
}
