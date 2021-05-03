package com.glacier.bean;

import java.io.Serializable;

/**
 * @author glacier
 * @version v1.0.0
 * @Date 2017-09-24  20:33:17
 */
public class Room implements Serializable {
    private static final long serialVersionUID = -977057270691752825L;
    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }
}
