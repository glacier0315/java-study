package com.glacier.jersey;

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
@Path("helloworld")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHello() {
        return "Hello World!";
    }


    @GET
    @Path("/{name}")
    public String hello(@PathParam("name") String name) {
        return "Hello " + name + "!";
    }

}