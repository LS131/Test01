package com.baizhi.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String password;
    public User(){
        System.out.println("User对象创建一个");
    }
}
