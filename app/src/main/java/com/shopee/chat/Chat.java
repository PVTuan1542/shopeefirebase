package com.shopee.chat;

public class Chat {

    private int img;
    private String name, detail, time;

    public Chat(int img, String name, String detail, String time) {
        this.img = img;
        this.name = name;
        this.detail = detail;
        this.time = time;
    }

    public Chat(int img, String name, String detail) {
        this.img = img;
        this.name = name;
        this.detail = detail;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}


