package com.glacier.modules.sys.service.impl;

import com.glacier.modules.sys.dao.UserRepository;
import com.glacier.modules.sys.domain.User;
import com.glacier.modules.sys.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017-05-22 23:20</pre>
 */
public class UserServiceImplTest {
    @Mock
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDelete() throws Exception {
        userService.delete(new User());
    }

    @Test
    public void testDeleteById() throws Exception {
        userService.deleteById("id");
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> result = userService.findAll();
        Assert.assertEquals(Arrays.<User>asList(new User()), result);
    }

    @Test
    public void testFindOne() throws Exception {
        User result = userService.findOne("id");
        Assert.assertEquals(new User(), result);
    }

    @Test
    public void testSave() throws Exception {
        User result = userService.save(new User());
        Assert.assertEquals(new User(), result);
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        userService.saveOrUpdate(new User());
    }

    @Test
    public void testUpdate() throws Exception {
        userService.update(new User());
    }

    @Test
    public void testUpdateUserPassWord() throws Exception {
        userService.updateUserPassWord("passWord", "id");
    }
}
