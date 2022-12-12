package com.example.du_an_alone.DTO;

public class HopDong {
    private int maHopDong;
    private int maPhong;
    private String tenPhong;
    private int maKhachThue;
    private int soDienThoai;
    private String queQuan;
    private int CCCD;
    private String tenKhachHang;
    private String ngayLamHopDong;
    private String  ngayKetThuc;
    private int maDichVu;
    private int tienDien;
    private int tienNuoc;
    private int tienVeSinh;
    private int tienGuiXe;
    private int tienWifi;
    private int tienCoc;
    private int trangThaitiencoc;
    private int giaPhong;

    public HopDong() {
    }

    public HopDong(int maHopDong, int tienDien, int tienNuoc, int tienVeSinh, int tienGuiXe, int tienWifi) {
        this.maHopDong = maHopDong;
        this.tienDien = tienDien;
        this.tienNuoc = tienNuoc;
        this.tienVeSinh = tienVeSinh;
        this.tienGuiXe = tienGuiXe;
        this.tienWifi = tienWifi;
    }

    public HopDong(int maHopDong, int maPhong,
                   String tenPhong, int maKhachThue,
                   int soDienThoai, String queQuan,
                   int CCCD, String tenKhachHang,
                   String ngayLamHopDong,
                   String ngayKetThuc, int maDichVu,
                   int tienCoc , int trangThaitiencoc , int giaPhong ) {
        this.maHopDong = maHopDong;
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.maKhachThue = maKhachThue;
        this.soDienThoai = soDienThoai;
        this.queQuan = queQuan;
        this.CCCD = CCCD;
        this.tenKhachHang = tenKhachHang;
        this.ngayLamHopDong = ngayLamHopDong;
        this.ngayKetThuc = ngayKetThuc;
        this.maDichVu = maDichVu;
        this.tienCoc = tienCoc;
        this.trangThaitiencoc = trangThaitiencoc;
        this.giaPhong = giaPhong;
    }

    public int getTienDien() {
        return tienDien;
    }

    public void setTienDien(int tienDien) {
        this.tienDien = tienDien;
    }

    public int getTienNuoc() {
        return tienNuoc;
    }

    public void setTienNuoc(int tienNuoc) {
        this.tienNuoc = tienNuoc;
    }

    public int getTienVeSinh() {
        return tienVeSinh;
    }

    public void setTienVeSinh(int tienVeSinh) {
        this.tienVeSinh = tienVeSinh;
    }

    public int getTienGuiXe() {
        return tienGuiXe;
    }

    public void setTienGuiXe(int tienGuiXe) {
        this.tienGuiXe = tienGuiXe;
    }

    public int getTienWifi() {
        return tienWifi;
    }

    public void setTienWifi(int tienWifi) {
        this.tienWifi = tienWifi;
    }

    public int getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(int giaPhong) {
        this.giaPhong = giaPhong;
    }

    public int getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(int tienCoc) {
        this.tienCoc = tienCoc;
    }

    public int getTrangThaitiencoc() {
        return trangThaitiencoc;
    }

    public void setTrangThaitiencoc(int trangThai) {
        this.trangThaitiencoc = trangThai;
    }

    public int getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(int maHopDong) {
        this.maHopDong = maHopDong;
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

    public int getMaKhachThue() {
        return maKhachThue;
    }

    public void setMaKhachThue(int maKhachThue) {
        this.maKhachThue = maKhachThue;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public int getCCCD() {
        return CCCD;
    }

    public void setCCCD(int CCCD) {
        this.CCCD = CCCD;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getNgayLamHopDong() {
        return ngayLamHopDong;
    }

    public void setNgayLamHopDong(String ngayLamHopDong) {
        this.ngayLamHopDong = ngayLamHopDong;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }
}
