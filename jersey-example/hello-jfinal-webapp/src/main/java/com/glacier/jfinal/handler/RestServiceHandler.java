package com.glacier.jfinal.handler;

import com.jfinal.handler.Handler;
import com.jfinal.kit.StrKit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/11 0011</pre>
 */
public class RestServiceHandler extends Handler {

    private Pattern urlPattern;

    public RestServiceHandler(String urlRegx) {
        if (StrKit.isBlank(urlRegx))
            throw new IllegalArgumentException("The para urlRegx can not be blank.");
        urlPattern = Pattern.compile(urlRegx);
    }

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        if (urlPattern.matcher(target).matches()) {
            isHandled[0] = true;
            try {
                request.getRequestDispatcher(target).forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            next.handle(target, request, response, isHandled);
        }
    }

}
