package com.glacier.proxy.jdk.impl;

import com.glacier.domain.User;
import com.glacier.domain.builder.UserBuilder;
import com.glacier.proxy.jdk.UserServiceAdapter;

import java.time.LocalDate;

/**
 * date 2021-06-04 09:25
 *
 * @author glacier
 * @version 1.0
 */
public class UserServiceAdapterImpl implements UserServiceAdapter {
    /**
     * 查找
     *
     * @param id
     * @return
     */
    @Override
    public User findById(String id) {
        System.out.println("调用 UserServiceAdapterImpl findById方法，参数是：\t" + id);
        return UserBuilder.anUser()
                .id("2")
                .name("李四")
                .idCard("1657645283870405705")
                .birthday(LocalDate.of(1981, 12, 9))
                .sex("男")
                .build();
    }
}
