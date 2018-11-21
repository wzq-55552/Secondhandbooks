package com.example.hasee.second_handbooks.db;

/*
用户信息类
 */
public class User {
    //学号
    private Long number;
    //手机号
    private Long telepgone;
    //昵称
    private String nickname;
    //性别
    private String sex;
    //密码
    private String password;
    //诚信度
    private int honesty;

    public User() {

    }

    public User(Long number, Long telepgone, String nickname, String sex, String password, int honesty) {
        this.number = number;
        this.telepgone = telepgone;
        this.nickname = nickname;
        this.sex = sex;
        this.password = password;
        this.honesty = honesty;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getTelepgone() {
        return telepgone;
    }

    public void setTelepgone(Long telepgone) {
        this.telepgone = telepgone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHonesty() {
        return honesty;
    }

    public void setHonesty(int honesty) {
        this.honesty = honesty;
    }
}

