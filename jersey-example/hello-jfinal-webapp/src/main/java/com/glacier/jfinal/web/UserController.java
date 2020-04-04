package com.glacier.jfinal.web;

import com.glacier.domain.User;
import com.jfinal.core.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/12 0012</pre>
 */
public class UserController extends Controller {

    public void index() {
        List<User> list = new ArrayList<>();
        User user = null;
        for (int i = 0; i < 5; i++) {
            user = new User("name_" + Math.random(), 20, 5 + i);
            list.add(user);
        }
        renderJson(list);
    }

    public void view() {
        User user = new User("xm", 20, 1);
        renderJson(user);
    }
}
