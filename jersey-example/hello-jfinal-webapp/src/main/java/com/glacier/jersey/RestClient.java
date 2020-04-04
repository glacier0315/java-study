package com.glacier.jersey;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * rest 客户端封装
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/3/30 0030</pre>
 */
public class RestClient {

    public static final String RELAY_URL = "http://192.168.0.200:81/rest";

    /**
     * rest请求封装
     *
     * @param path            请求路径(相对)
     * @param method          请求方法
     * @param requestDataType 请求媒体类型
     * @param returnType      返回类型
     * @param headParams      请求头参数
     * @param queryParams     请求参数
     * @param requestData     请求体参数
     * @param <T>             请求体类型
     * @param <S>             返回值类型
     * @return
     */
    public static <T, S> S rest(String path, String method, MediaType requestDataType, GenericType<S> returnType,
                                Map<String, Object> headParams, Map<String, Object> queryParams, T requestData) {
        S s = null;
        Response response = rest(path, method, requestDataType, headParams, queryParams, requestData);
        if (response != null) {
            s = response.readEntity(returnType);
        }

        return s;
    }

    /**
     * rest请求封装
     *
     * @param path            请求路径(相对)
     * @param method          请求方法
     * @param requestDataType 请求媒体类型
     * @param headParams      请求头参数
     * @param queryParams     请求参数
     * @param requestData     请求体参数
     * @param <T>             请求体类型
     * @return
     */
    public static <T> Response rest(String path, String method, MediaType requestDataType,
                                    Map<String, Object> headParams, Map<String, Object> queryParams, T requestData) {
        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target(RELAY_URL).path(path);

        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                target.queryParam(key, queryParams.get(key));
            }
        }

        Invocation.Builder request = target.request(requestDataType);
        if (headParams != null) {
            for (String key : headParams.keySet()) {
                request.header(key, headParams.get(key));
            }
        }
        Response response = null;
        switch (method) {
            case "GET":
                response = request.buildGet().invoke();
                break;
            case "POST":
                response = request.buildPost(Entity.entity(requestData, requestDataType)).invoke();
                break;
            case "PUT":
                response = request.buildPut(Entity.entity(requestData, requestDataType)).invoke();
                break;
            case "DELETE":
                response = request.buildDelete().invoke();
                break;
            default:
                break;
        }
        return response;
    }

    /**
     * get请求
     * @param path 请求路径
     * @param returnType 返回值类型
     * @param queryParams 请求参数
     * @param <T>
     * @return
     */
    public static <T> T get(String path, GenericType<T> returnType, Map<String, Object> queryParams) {
        return rest(path, "GET", MediaType.APPLICATION_JSON_TYPE, returnType, null, queryParams, null);
    }

    /**
     * get请求
     *
     * @param path            请求路径
     * @param requestDataType 请求媒体类型
     * @param returnType      返回值类型
     * @param headParams      请求头参数
     * @param queryParams     请求参数
     * @param <T>
     * @return
     */
    public static <T> T get(String path, MediaType requestDataType, GenericType<T> returnType, Map<String, Object> headParams, Map<String, Object> queryParams) {
        return rest(path, "GET", requestDataType, returnType, headParams, queryParams, null);
    }

    /**
     * post请求
     * @param path 请求路径
     * @param returnType 返回值类型
     * @param requestDate 请求体数据
     * @param <T>
     * @param <M>
     * @return
     */
    public static <T, M> M post(String path, GenericType<M> returnType, T requestDate) {
        return rest(path, "POST", MediaType.APPLICATION_JSON_TYPE, returnType, null, null, requestDate);
    }
}
