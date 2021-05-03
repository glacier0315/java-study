package com.glacier.annotation;

import java.util.ArrayList;
import java.util.Collection;

/**
 * date 2021-05-03 14:16
 *
 * @author glacier
 * @version 1.0
 */
public class AnnotationTest {
    
    public static void main(String[] args) {
        final Holder<String> holder = new @NonEmpty Holder<>();
        @NonEmpty Collection<@NonEmpty String> strings = new ArrayList<>();
        try {
            holder.method();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
