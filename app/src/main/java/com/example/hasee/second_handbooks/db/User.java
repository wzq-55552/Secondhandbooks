package com.example.hasee.second_handbooks.db;

import android.widget.TextView;

/*
用户信息类
 */
public class User {
    //学号
    private Long number;
    //手机号
    private Long telephone;
    //昵称
    private String nickname;
    //性别
    private String sex;
    //密码
    private String password;
    //诚信度
    private Long honesty;

    public User() {

    }

    public User(Long number, Long telephone, String nickname, String sex, String password, Long honesty) {
        this.number = number;
        this.telephone = telephone;
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

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
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

    public Long getHonesty() {
        return honesty;
    }

    public void setHonesty(Long honesty) {
        this.honesty = honesty;
    }

    public void change_user_information(TextView nickname, TextView sex) {
        nickname.setText(this.nickname);
        sex.setText(this.sex);
    }
}

