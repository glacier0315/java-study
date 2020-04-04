package com.glacier.jersey;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/12 0012</pre>
 */
public class App {

    public static void main(String[] args) {
        String webapp = "hello-webapp/src/main/webapp";
        // 服务器的监听端口
        Server server = new Server(80);
        // 关联一个已经存在的上下文
        WebAppContext context = new WebAppContext();
        // 设置描述符位置
        context.setDescriptor(webapp + "/WEB-INF/web.xml");
        // 设置Web内容上下文路径
        context.setResourceBase(webapp);
        // 设置上下文路径
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        // 启动
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("jetty start!");
    }
}
