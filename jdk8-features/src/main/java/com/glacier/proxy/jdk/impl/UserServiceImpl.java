package com.glacier.proxy.jdk.impl;

import com.glacier.domain.User;
import com.glacier.domain.builder.UserBuilder;
import com.glacier.proxy.jdk.UserService;

import java.time.LocalDate;

/**
 * date 2021-06-03 17:30
 *
 * @author glacier
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
    /**
     * 查找
     *
     * @param id
     * @return
     */
    @Override
    public User findById(String id) {
        System.out.println("参数\t" + id);
        return UserBuilder.anUser()
                .id("1")
                .name("张三")
                .idCard("1657645283870405705")
                .birthday(LocalDate.of(1981, 12, 9))
                .sex("男")
                .build();
    }
}
