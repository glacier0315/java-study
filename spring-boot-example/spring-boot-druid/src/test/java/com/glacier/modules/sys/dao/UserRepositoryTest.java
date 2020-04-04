package com.glacier.modules.sys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userDao;

    @Test
    public void testSaveS() {
        userDao.test();
    }

}
