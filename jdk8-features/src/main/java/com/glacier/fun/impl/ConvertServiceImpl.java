package com.glacier.fun.impl;

import com.glacier.fun.ConvertService;
import com.glacier.fun.MyFunction;

import java.util.List;

/**
 * date 2021-06-03 17:09
 *
 * @author glacier
 * @version 1.0
 */
public class ConvertServiceImpl implements ConvertService {
    /**
     * @param list
     * @param myFunction
     * @return
     */
    @Override
    public String convert(List<String> list, MyFunction myFunction) {
        System.out.println("执行convert前");
        String convert = myFunction.convert(list);
        System.out.println("执行convert后");
        return convert;
    }
}
