package com.shopee.home;

public class FlashSale {
    private int img;
    private String gia,sell;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public FlashSale() {
    }

    public String getSell() {
        String selled = sell;
        return selled;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public FlashSale(int img, String gia) {
        this.img = img;
        this.gia = gia;
    }

    public FlashSale(int img, String gia, String sell) {
        this.img = img;
        this.sell = sell;
        this.gia = gia;
    }
}
