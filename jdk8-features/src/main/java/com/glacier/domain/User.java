package com.glacier.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * date 2021-06-03 17:17
 *
 * @author glacier
 * @version 1.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = 7205812652553145335L;
    private String id;
    private String name;
    private String sex;
    private String idCard;
    private LocalDate birthday;
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getIdCard() {
        return idCard;
    }
    
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }
    
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", idCard='" + idCard + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
