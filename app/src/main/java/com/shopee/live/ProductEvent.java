package com.shopee.live;

public class ProductEvent {
    private String ten;
    private String tenshop;
    private String thoigian;
    private String nhacnho;
    private int hinhanh;
    private int hinhnho;

    public ProductEvent(String ten, String tenshop, String thoigian, String nhacnho, int hinhanh, int hinhnho) {
        this.ten = ten;
        this.tenshop = tenshop;
        this.thoigian = thoigian;
        this.nhacnho = nhacnho;
        this.hinhanh = hinhanh;
        this.hinhnho = hinhnho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenshop() {
        return tenshop;
    }

    public void setTenshop(String tenshop) {
        this.tenshop = tenshop;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getNhacnho() {
        return nhacnho;
    }

    public void setNhacnho(String nhacnho) {
        this.nhacnho = nhacnho;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getHinhnho() {
        return hinhnho;
    }

    public void setHinhnho(int hinhnho) {
        this.hinhnho = hinhnho;
    }
}
