package com.glacier.proxy.jdk.impl;

import com.glacier.domain.User;
import com.glacier.proxy.jdk.UserService;

/**
 * date 2021-06-03 17:33
 *
 * @author glacier
 * @version 1.0
 */
public class UserServiceProxyImpl implements UserService {
    
    private final UserService userService;
    
    public UserServiceProxyImpl(UserService userService) {
        this.userService = userService;
    }
    
    /**
     * 查找
     *
     * @param id
     * @return
     */
    @Override
    public User findById(String id) {
        System.out.println("执行findById前");
        User user = userService.findById(id);
        System.out.println("执行findById后");
        return user;
    }
}
