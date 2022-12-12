package com.example.du_an_alone.DTO;

public class Phong {

    private int id;
    private String tenPhong;
    private int dienTichPhong;
    private int giaPhong;
    private int trangThaiTienCoc;
    private String tenLoaiPhong;

    public Phong() {
    }

    public Phong(int id, String tenPhong, int dienTichPhong, int giaPhong, int trangThaiTienCoc, String tenLoaiPhong) {
        this.id = id;
        this.tenPhong = tenPhong;
        this.dienTichPhong = dienTichPhong;
        this.giaPhong = giaPhong;
        this.trangThaiTienCoc = trangThaiTienCoc;
        this.tenLoaiPhong = tenLoaiPhong;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getDienTichPhong() {
        return dienTichPhong;
    }

    public void setDienTichPhong(int dienTichPhong) {
        this.dienTichPhong = dienTichPhong;
    }

    public int getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(int giaPhong) {
        this.giaPhong = giaPhong;
    }

    public int getTrangThaiTienCoc() {
        return trangThaiTienCoc;
    }

    public void setTrangThaiTienCoc(int trangThaiTienCoc) {
        this.trangThaiTienCoc = trangThaiTienCoc;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }
}
