package com.example.du_an_alone.DTO;

import java.io.Serializable;

public class DangNhap implements Serializable {
    int MaNV;
    String UserName;
    String PassWord;
    String TenNV;
    int NumberPhone;
    String DiaChi;
    String NgaySinh;
    String GioiTinh;
    String VaiTro;
    int ImageNV;

    public DangNhap(int maNV, String userName, String passWord, String tenNV, int numberPhone, String diaChi, String ngaySinh, String gioiTinh, String vaiTro, int imageNV) {
        MaNV = maNV;
        UserName = userName;
        PassWord = passWord;
        TenNV = tenNV;
        NumberPhone = numberPhone;
        DiaChi = diaChi;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        VaiTro = vaiTro;
        ImageNV = imageNV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public DangNhap() {
    }

    public int getMaNV() {
        return MaNV;
    }


    public String getUserName() {
        return UserName;
    }


    public String getPassWord() {
        return PassWord;
    }


    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public int getNumberPhone() {
        return NumberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        NumberPhone = numberPhone;
    }

    public String getDiaChi() {
        return DiaChi;
    }


    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getVaiTro() {
        return VaiTro;
    }


    public int getImageNV() {
        return ImageNV;
    }
}
