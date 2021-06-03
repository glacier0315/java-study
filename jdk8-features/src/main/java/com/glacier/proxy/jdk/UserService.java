package com.glacier.proxy.jdk;

import com.glacier.domain.User;

/**
 * date 2021-06-03 17:17
 *
 * @author glacier
 * @version 1.0
 */
public interface UserService {
    
    /**
     * 查找
     * @param id
     * @return
     */
    User findById(String id);
}
