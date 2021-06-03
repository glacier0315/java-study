package com.glacier.fun;

import java.util.List;

/**
 * date 2021-06-03 17:08
 *
 * @author glacier
 * @version 1.0
 */
public interface ConvertService {
    
    /**
     *
     * @param list
     * @param myFunction
     * @return
     */
    String convert(List<String> list, MyFunction myFunction);
}
