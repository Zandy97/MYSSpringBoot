package com.example.test.server.api_server.model;

public class UserProfile {
    private String id;
    private String pwd;
    private String name;
    private String age;

    public UserProfile(String id, String pwd, String name, String age) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
}
