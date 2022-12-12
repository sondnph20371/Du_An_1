package com.example.du_an_alone.DTO;

public class DichVu {
    private int MaDichVu;

    private int tienDien;
    private int tienNuoc;
    private int tienVeSinh;
    private int tienGuiXe;
    private int tienWifi;

    public DichVu() {
    }

    public DichVu(int maDichVu, int tienDien, int tienNuoc, int tienVeSinh, int tienGuiXe, int tienWifi) {
        MaDichVu = maDichVu;
        this.tienDien = tienDien;
        this.tienNuoc = tienNuoc;
        this.tienVeSinh = tienVeSinh;
        this.tienGuiXe = tienGuiXe;
        this.tienWifi = tienWifi;
    }

    public int getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        MaDichVu = maDichVu;
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
}
