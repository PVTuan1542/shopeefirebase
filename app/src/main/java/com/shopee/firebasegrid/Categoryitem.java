package com.shopee.firebasegrid;

public class Categoryitem {
    public String gia;
    public String gia_km;
    public int id;
    public String img,name,num_ratting;
    public int sao;

    public Categoryitem() {
    }

    public Categoryitem(String gia, String gia_km, int id, String img, String name, String num_ratting, int sao) {
        this.gia = gia;
        this.gia_km = gia_km;
        this.id = id;
        this.img = img;
        this.name = name;
        this.num_ratting = num_ratting;
        this.sao = sao;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getGiaKM() {
        return gia_km;
    }

    public void setGiaKM(String gia_km) {
        this.gia_km = gia_km;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return num_ratting;
    }

    public void setRating(String num_ratting) {
        this.num_ratting = num_ratting;
    }

    public int getSao() {
        return sao;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }
}
