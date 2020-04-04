package com.glacier.jersey;

import com.glacier.domain.User;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/12 0012</pre>
 */
@Singleton
@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    @Path("/{name}")
    public User find(@PathParam("name") String name){
        User user = new User(name,20,1);
        return user;
    }
}
