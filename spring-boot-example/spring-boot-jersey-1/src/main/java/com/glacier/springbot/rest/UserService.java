package com.glacier.springbot.rest;

import com.glacier.springbot.domain.Result;
import com.glacier.springbot.domain.User;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/13 0013</pre>
 */


@Singleton
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserService implements IUserService {

    @GET
    public List<User> list() {
        List<User> users = new ArrayList<>();
        User user = new User("123", "xm", "123456", 1);
        users.add(user);
        return users;
    }

    @GET
    @Path("/{id}")
    public User find(@PathParam("id") String id) {
        User user = new User(id, "xm", "123456", 1);
        return user;
    }

    @PUT
    public Result save(User user) {
        user.setId("123");
        return new Result(200, "保存成功！", user);
    }


    @POST
    public Result update(User user) {
        user.setId("1234");
        return new Result(200, "修改成功！", user);
    }
}
