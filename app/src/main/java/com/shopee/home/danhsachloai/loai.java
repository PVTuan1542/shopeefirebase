package com.shopee.home.danhsachloai;

public class loai {
    private String ten;
    private  int anh;
    private String mota;

    public loai(String ten, int anh, String mota) {
        this.ten = ten;
        this.anh = anh;
        this.mota = mota;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
