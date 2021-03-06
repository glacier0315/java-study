package com.glacier.sys.service.impl;

import com.glacier.sys.mapper.UserMapper;
import com.glacier.sys.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author glacier
 * @version 1.0
 * @description 用户业务类
 * @date 2019-08-04 21:50
 */
@Slf4j
@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public void test() {

    }

}
