package com.glacier.springbot.jersey;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/13 0013</pre>
 */

public class RestConfig extends ResourceConfig {

    public RestConfig() {
        packages("com.glacier.springbot");

        register(RequestContextFilter.class);
        register(JacksonJsonProvider.class);

    }

}
