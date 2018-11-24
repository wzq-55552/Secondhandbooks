package com.example.hasee.second_handbooks.db;

import android.widget.TextView;

/*
用户信息类
 */
public class User {
    //学号
    private String number;
    //手机号
    private String telephone;
    //昵称
    private String nickname;
    //性别
    private String sex;
    //密码
    private String password;
    //诚信度
    private String honesty;

    public User() {

    }

    public User(String number, String telephone, String nickname, String sex, String password, String honesty) {
        this.number = number;
        this.telephone = telephone;
        this.nickname = nickname;
        this.sex = sex;
        this.password = password;
        this.honesty = honesty;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getHonesty() {
        return honesty;
    }

    public void setHonesty(String honesty) {
        this.honesty = honesty;
    }
}

