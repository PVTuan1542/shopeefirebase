package com.shopee.home;

public class TopSale {
    private int img;
    private String gia;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getGia() {
        return gia;
    }

    public TopSale() {
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public TopSale(int img, String gia) {
        this.img = img;
        this.gia = gia;
    }
}
