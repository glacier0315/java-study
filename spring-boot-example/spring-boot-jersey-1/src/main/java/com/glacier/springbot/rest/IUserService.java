package com.glacier.springbot.rest;

import com.glacier.springbot.domain.Result;
import com.glacier.springbot.domain.User;

import java.util.List;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/13 0013</pre>
 */
public interface IUserService {

    public List<User> list();

    public User find(String id);

    public Result save(User user);

    public Result update(User user);
}
