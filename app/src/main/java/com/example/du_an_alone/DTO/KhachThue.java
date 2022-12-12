package com.example.du_an_alone.DTO;

public class KhachThue {

    private int maKhachThue;
    private String ten;
    private String gioiTinh;
    private String ngaySinh;
    private int CCCD;
    private String queQuan;
    private String ngheNghiep;
    private int soDienThoai;
    public KhachThue() {
    }

    public KhachThue(int maKhachThue, String ten,String gioiTinh, String ngaySinh, int CCCD, String queQuan, String ngheNghiep,int soDienThoai) {
        this.maKhachThue = maKhachThue;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.CCCD = CCCD;
        this.queQuan = queQuan;
        this.ngheNghiep = ngheNghiep;
      this.soDienThoai = soDienThoai;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getMaKhachThue() {
        return maKhachThue;
    }

    public void setMaKhachThue(int maKhachThue) {
        this.maKhachThue = maKhachThue;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getCCCD() {
        return CCCD;
    }

    public void setCCCD(int CCCD) {
        this.CCCD = CCCD;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

}
