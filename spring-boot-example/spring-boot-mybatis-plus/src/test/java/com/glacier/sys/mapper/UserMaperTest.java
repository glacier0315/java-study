package com.glacier.sys.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.glacier.EbootSysApplication;
import com.glacier.sys.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author glacier
 * @version 1.0
 * @description
 * @date 2020-01-28 08:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EbootSysApplication.class})
public class UserMaperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testSelectPage() {
        Page<User> page = userMapper.selectPage(new Page<User>(2, 1), null);
        System.out.println(page.getRecords());
    }
}
