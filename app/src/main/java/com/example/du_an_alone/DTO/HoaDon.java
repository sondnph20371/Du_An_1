package com.example.du_an_alone.DTO;

public class HoaDon {
    private int maHoaDon;
    private String tenHoaDon;
    private int maPhong;
    private String tenPhong;
    private int tienPhong;
    private int maKhachThue;
    private String tenKhachThue;
    private String ngayThu;
    private int maDichVu;
    private int soDien;
    private int soNuoc;
    private int veSinh;
    private int guiXe;
    private int wifi;
    private int tongTienThanhToan;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, String tenHoaDon,
                  int maPhong, String tenPhong,
                  int tienPhong, int maKhachThue,
                  String tenKhachThue, String ngayThu,
                  int maDichVu, int soDien, int soNuoc,
                  int veSinh, int guiXe, int wifi,
                  int tongTienThanhToan, String trangThai) {
        this.maHoaDon = maHoaDon;
        this.tenHoaDon = tenHoaDon;
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.tienPhong = tienPhong;
        this.maKhachThue = maKhachThue;
        this.tenKhachThue = tenKhachThue;
        this.ngayThu = ngayThu;
        this.maDichVu = maDichVu;
        this.soDien = soDien;
        this.soNuoc = soNuoc;
        this.veSinh = veSinh;
        this.guiXe = guiXe;
        this.wifi = wifi;
        this.tongTienThanhToan = tongTienThanhToan;
        this.trangThai = trangThai;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenHoaDon() {
        return tenHoaDon;
    }

    public void setTenHoaDon(String tenHoaDon) {
        this.tenHoaDon = tenHoaDon;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(int tienPhong) {
        this.tienPhong = tienPhong;
    }

    public int getMaKhachThue() {
        return maKhachThue;
    }

    public void setMaKhachThue(int maKhachThue) {
        this.maKhachThue = maKhachThue;
    }

    public String getTenKhachThue() {
        return tenKhachThue;
    }

    public void setTenKhachThue(String tenKhachThue) {
        this.tenKhachThue = tenKhachThue;
    }

    public String getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(String ngayThu) {
        this.ngayThu = ngayThu;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public int getSoDien() {
        return soDien;
    }

    public void setSoDien(int soDien) {
        this.soDien = soDien;
    }

    public int getSoNuoc() {
        return soNuoc;
    }

    public void setSoNuoc(int soNuoc) {
        this.soNuoc = soNuoc;
    }

    public int getVeSinh() {
        return veSinh;
    }

    public void setVeSinh(int veSinh) {
        this.veSinh = veSinh;
    }

    public int getGuiXe() {
        return guiXe;
    }

    public void setGuiXe(int guiXe) {
        this.guiXe = guiXe;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public int getTongTienThanhToan() {
        return tongTienThanhToan;
    }

    public void setTongTienThanhToan(int tongTienThanhToan) {
        this.tongTienThanhToan = tongTienThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
