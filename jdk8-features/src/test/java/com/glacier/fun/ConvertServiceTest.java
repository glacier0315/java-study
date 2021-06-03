package com.glacier.fun;

import com.glacier.fun.impl.ConvertServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * date 2021-06-03 17:10
 *
 * @author glacier
 * @version 1.0
 */
class ConvertServiceTest {
    
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
        
        List<String> list = Arrays.asList("qhaflj", "khaflga", "afjlgs;k");
        ConvertService convertService = new ConvertServiceImpl();
        
        System.out.println(convertService.convert(list, myFunction));
        
    }
}
