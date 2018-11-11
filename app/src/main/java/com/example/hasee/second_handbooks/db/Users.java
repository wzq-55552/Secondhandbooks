package com.example.hasee.second_handbooks.db;

/*
用户信息类
 */
public class Users {
    //账号
    private String account;
    //密码
    private String password;
    //性别
    private char sex;
    //姓名,用户名
    private String users_name;
    //学号
    private String users_id;
    //手机号
    private String phone;


    public Users(){

    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public char getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsers_id() {
        return users_id;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

}

