package com.glacier.annotation;

import java.lang.annotation.*;

/**
 * date 2021-05-03 14:14
 *
 * @author glacier
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Filters.class)
public @interface Filter {
    String value();
    
    String value2();
}
