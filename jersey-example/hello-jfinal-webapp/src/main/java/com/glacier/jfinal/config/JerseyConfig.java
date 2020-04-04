package com.glacier.jfinal.config;

import com.glacier.jfinal.handler.RestServiceHandler;
import com.glacier.jfinal.web.UserController;
import com.jfinal.config.*;
import com.jfinal.template.Engine;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/12 0012</pre>
 */
public class JerseyConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {
        me.add("user", UserController.class, "");

    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins me) {

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {
        me.add(new RestServiceHandler("^/rest/\\S*"));
    }
}
