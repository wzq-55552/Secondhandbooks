package com.example.hasee.second_handbooks.db;


//交换信息类
public class ExchangeMessage {
    //书名
    private String Book_name;
    //书图片
    private int Book_image_id;
    //交换地点
    private String location;
    //交换时间
    private String time;//后期改为Date
    //备注
    private String remark;

    //暂定的构造函数
    public ExchangeMessage(String book_name,String time,String location,String remark){
        this.Book_name = book_name;
        this.time = time;
        this.location = location ;
        this.remark = remark;
    }

    public String getTime() {
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

    public void setTime(String time) {
        this.time = time;
    }
}
