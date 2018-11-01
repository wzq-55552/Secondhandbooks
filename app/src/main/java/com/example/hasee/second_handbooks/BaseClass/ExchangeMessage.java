package com.example.hasee.second_handbooks.BaseClass;


import java.util.Date;

//交换信息类
public class ExchangeMessage {
    //书名
    private String Book_name;
    //书图片
    private int Book_image_id;
    //交换地点
    private String location;
    //交换时间
    private Date time;
    //备注
    private String remark;

    public ExchangeMessage(String book_name){
        book_name = this.Book_name;
    }

    public Date getTime() {
        return time;
    }

    public int getBook_image_id() {
        return Book_image_id;
    }

    public String getBook_name() {
        return Book_name;
    }

    public String getLocation() {
        return location;
    }

    public String getRemark() {
        return remark;
    }


    public void setBook_image_id(int book_image_id) {
        Book_image_id = book_image_id;
    }

    public void setBook_name(String book_name) {
        Book_name = book_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
