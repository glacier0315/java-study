package com.glacier.modules.sys.service.impl;

import com.glacier.modules.sys.dao.UserRepository;
import com.glacier.modules.sys.domain.User;
import com.glacier.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author glacier
 * @version 1.0.0
 * @since <pre>2017-03-29</pre>
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(String id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void saveOrUpdate(User user) {
        if (user.getId() != null && user.getId().trim().length() > 0) {
            this.update(user);
        } else {

            this.save(user);
        }
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void updateUserPassWord(String passWord, String id) {
        userRepository.updateUserPassWord(passWord, id);
    }


}
