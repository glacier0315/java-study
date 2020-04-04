package com.glacier.springbot.config;

import com.glacier.springbot.jersey.RestConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/13 0013</pre>
 */

@Configuration
public class JerseyConfig {

    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, RestConfig.class.getName());
        return registration;
    }
}
