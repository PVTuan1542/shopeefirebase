package com.shopee.home.sanpham;

public class sanpham {
    private String thonhTinSP;
    private  int anh;
    private float giaBan;
    private float giaKhuyenMai;
    private int soSao;
    private int soDanhGia;

    public sanpham(String thonhTinSP, int anh, float giaBan, float giaKhuyenMai, int soSao, int soDanhGia) {
        this.thonhTinSP = thonhTinSP;
        this.anh = anh;
        this.giaBan = giaBan;
        this.giaKhuyenMai = giaKhuyenMai;
        this.soSao = soSao;
        this.soDanhGia = soDanhGia;
    }

    public String getthonhTinSP() {
        return thonhTinSP;
    }

    public void setthonhTinSP(String tieuDeSP) {
        this.thonhTinSP = tieuDeSP;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getGiaKhuyenMai() {
        return giaKhuyenMai;
    }

    public void setGiaKhuyenMai(float giaKhuyenMai) {
        this.giaKhuyenMai = giaKhuyenMai;
    }

    public int getSoSao() {
        return soSao;
    }

    public void setSoSao(int soSao) {
        this.soSao = soSao;
    }

    public int getSoDanhDanhGia() {
        return soDanhGia;
    }

    public void setSoDanhDanhGia(int soDanhDanhGia) {
        this.soDanhGia = soDanhDanhGia;
    }
}
