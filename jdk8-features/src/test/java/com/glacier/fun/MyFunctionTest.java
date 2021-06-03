package com.glacier.fun;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * date 2021-06-03 17:07
 *
 * @author glacier
 * @version 1.0
 */
class MyFunctionTest {
    
    @BeforeEach
    void setUp() {
    }
    
    @AfterEach
    void tearDown() {
    }
    
    @Test
    void convert() {
       MyFunction myFunction = list -> {
          if (!list.isEmpty()) {
                return String.join(",", list);
          }
          return null;
       };
    
        System.out.println(myFunction);
        List<String> list = Arrays.asList("qhaflj", "khaflga", "afjlgs;k");
        System.out.println(myFunction.convert(list));
    }
}
