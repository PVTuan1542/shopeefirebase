package com.shopee;

public class Product {
    private String name;
    private String img;
    private String gia;
    private String gia_km;
    private String sao;
    private String num_ratting;

    public Product() {
    }

    public String getGia_km() {
        return gia_km;
    }

    public void setGia_km(String gia_km) {
        this.gia_km = gia_km;
    }

    public Product(String name, String img, String gia, String gia_km, String sao, String num_ratting) {
        this.name = name;
        this.img = img;
        this.gia = gia;
        this.gia_km = gia_km;
        this.sao = sao;
        this.num_ratting = num_ratting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSao() {
        return sao;
    }

    public void setSao(String sao) {
        this.sao = sao;
    }

    public String getNum_ratting() {
        return num_ratting;
    }

    public void setNum_ratting(String num_ratting) {
        this.num_ratting = num_ratting;
    }
}
