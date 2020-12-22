package com.shopee.feed;

public class post {
    private int logo;
    private String tenShop;
    private int anh;
    private int like;
    private int cmt;
    private int view;

    public post(int logo, String tenShop, int anh, int like, int cmt, int view) {
        this.logo = logo;
        this.tenShop = tenShop;
        this.anh = anh;
        this.like = like;
        this.cmt = cmt;
        this.view = view;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getTenShop() {
        return tenShop;
    }

    public void setTenShop(String tenShop) {
        this.tenShop = tenShop;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getCmt() {
        return cmt;
    }

    public void setCmt(int cmt) {
        this.cmt = cmt;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
