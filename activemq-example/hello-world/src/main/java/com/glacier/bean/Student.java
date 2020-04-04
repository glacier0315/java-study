package com.glacier.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author glacier
 * @version v1.0.0
 * @Date 2017-09-24  20:29:59
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 6598540986256127247L;
    private String name;
    private int sex;
    private Date birthDay;
    private Map<String, String> map;
    private Room room;
    private List<String> list;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", birthDay=" + birthDay +
                ", map=" + map +
                ", room=" + room +
                ", list=" + list +
                '}';
    }
}
