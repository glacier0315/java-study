package com.glacier.base64;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * date 2021-06-03 17:02
 *
 * @author glacier
 * @version 1.0
 */
class Base64Test {
    @BeforeEach
    void setUp() {
    }
    
    @AfterEach
    void tearDown() {
    }
    
    /**
     * 8.新增base64加解密API
     */
    @Test
    void testBase64() {
        final String text = "就是要测试加解密！！abjdkhdkuasu!!@@@@";
        String encoded = Base64.getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println("加密后=" + encoded);
        
        final String decoded = new String(Base64.getDecoder()
                .decode(encoded), StandardCharsets.UTF_8);
        System.out.println("解密后=" + decoded);
    }
}
