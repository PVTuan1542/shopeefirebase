package com.shopee.cart;

public class Cart {
    private int img;
    private String name;
    private String product;
    private String gia;
    private int solg;

    public Cart(int img, String name, String product, String gia, int solg) {
        this.img = img;
        this.name = name;
        this.product = product;
        this.gia = gia;
        this.solg = solg;
    }

    public int getSolg() {
        return solg;
    }

    public void setSolg(int solg) {
        this.solg = solg;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
