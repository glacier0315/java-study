package com.glacier.proxy.cglib;

import com.glacier.domain.User;
import com.glacier.domain.builder.UserBuilder;

import java.time.LocalDate;

/**
 * date 2021-06-04 09:39
 *
 * @author glacier
 * @version 1.0
 */
public class BizUserService {
    /**
     * 查找
     *
     * @param id
     * @return
     */
    public User findById(String id) {
        System.out.println("调用 BizUserService findById方法，参数是：\t" + id);
        return UserBuilder.anUser()
                .id("1")
                .name("张三")
                .idCard("1657645283870405705")
                .birthday(LocalDate.of(1981, 12, 9))
                .sex("男")
                .build();
    }
}
