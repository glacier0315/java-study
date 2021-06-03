package com.glacier.annotation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * date 2021-06-03 16:29
 *
 * @author glacier
 * @version 1.0
 */
class HolderTest {
    
    @BeforeEach
    void setUp() {
    }
    
    @AfterEach
    void tearDown() {
    }
    
    @Test
    void method() {
        final Holder<String> holder = new @NonEmpty Holder<>();
    
        try {
            holder.method();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
