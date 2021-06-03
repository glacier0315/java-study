package com.glacier.domain.builder;

import com.glacier.domain.User;

import java.time.LocalDate;

/**
 * date 2021-06-03 17:29
 *
 * @author glacier
 * @version 1.0
 */
public final class UserBuilder {
    private String id;
    private String name;
    private String sex;
    private String idCard;
    private LocalDate birthday;
    
    private UserBuilder() {
    }
    
    public static UserBuilder anUser() {
        return new UserBuilder();
    }
    
    public UserBuilder id(String id) {
        this.id = id;
        return this;
    }
    
    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }
    
    public UserBuilder sex(String sex) {
        this.sex = sex;
        return this;
    }
    
    public UserBuilder idCard(String idCard) {
        this.idCard = idCard;
        return this;
    }
    
    public UserBuilder birthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }
    
    public User build() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSex(sex);
        user.setIdCard(idCard);
        user.setBirthday(birthday);
        return user;
    }
}
