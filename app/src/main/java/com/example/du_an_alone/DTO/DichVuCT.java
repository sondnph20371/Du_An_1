package com.example.du_an_alone.DTO;

public class DichVuCT {
    private int maDichVuCt;
    private String tenDichVu;
    private int giaDichVu;
    private String ghiChu;
    public DichVuCT() {
    }

    public DichVuCT(int maDichVuCt, String tenDichVu, int giaDichVu , String ghiChu) {
        this.maDichVuCt = maDichVuCt;
        this.tenDichVu = tenDichVu;
        this.giaDichVu = giaDichVu;
        this.ghiChu = ghiChu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getMaDichVuCt() {
        return maDichVuCt;
    }

    public void setMaDichVuCt(int maDichVuCt) {
        this.maDichVuCt = maDichVuCt;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public int getGiaDichVu() {
        return giaDichVu;
    }

    public void setGiaDichVu(int giaDichVu) {
        this.giaDichVu = giaDichVu;
    }
}
