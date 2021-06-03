package com.glacier.annotation;


/**
 * date 2021-05-03 14:14
 *
 * @author glacier
 * @version 1.0
 */
public class Holder<@NonEmpty T> extends @NonEmpty Object {
    
    public void method() throws @NonEmpty Exception {
        throw new RuntimeException("afl");
    }
}
