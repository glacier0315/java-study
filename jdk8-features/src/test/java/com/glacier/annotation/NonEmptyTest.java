package com.glacier.annotation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * date 2021-06-03 16:30
 *
 * @author glacier
 * @version 1.0
 */
class NonEmptyTest {
    @BeforeEach
    void setUp() {
    }
    
    @AfterEach
    void tearDown() {
    }
    
    @Test
    void test() {
        @NonEmpty Collection<@NonEmpty String> list = new ArrayList<>();
        list.add(null);
        System.out.println(list);
    }
}
