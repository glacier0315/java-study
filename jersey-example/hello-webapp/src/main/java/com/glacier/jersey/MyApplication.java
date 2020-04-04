package com.glacier.jersey;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/12 0012</pre>
 */
@ApplicationPath("/")
public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // register root resource
        classes.add(HelloWorldResource.class);
        return classes;
    }
}
