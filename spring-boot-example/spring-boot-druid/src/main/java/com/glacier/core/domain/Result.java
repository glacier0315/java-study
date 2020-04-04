package com.glacier.core.domain;

import java.io.Serializable;

/**
 * 结果类
 *
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/3/29 0029</pre>
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 5252256407574491693L;
    private boolean status = true;
    private int code = 200;
    private String message = "success";
    private Object data;

    public Result() {
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public Result(boolean status, int code, String message, Object data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
