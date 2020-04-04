package com.glacier.jersey;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/12 0012</pre>
 */
public class MyResourceConfig extends ResourceConfig {

    public MyResourceConfig() {
        // register(HelloWorldResource.class);
        packages("com.glacier.jersey");
        // register(JacksonJsonProvider.class);
    }
}
