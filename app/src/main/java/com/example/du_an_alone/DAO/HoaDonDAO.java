package com.example.du_an_alone.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_alone.DTO.HoaDon;
import com.example.du_an_alone.SQLiteHelper.SQLite_PhongTro;

import java.util.ArrayList;

public class HoaDonDAO {
    SQLiteDatabase database;

    public HoaDonDAO(Context context) {
        SQLite_PhongTro sqLite_phongTro = new SQLite_PhongTro(context);
        database = sqLite_phongTro.getWritableDatabase();
    }

    public boolean Insert(HoaDon hoaDon) {
        ContentValues values = new ContentValues();
        values.put("TENHOADON", hoaDon.getTenHoaDon());
        values.put("MAPHONG", hoaDon.getMaPhong());
        values.put("TENPHONG", hoaDon.getTenPhong());
        values.put("MAKHACHTHUE", hoaDon.getMaKhachThue());
        values.put("HOTEN", hoaDon.getTenKhachThue());
        values.put("NGAYTHU", hoaDon.getNgayThu());
        values.put("SODIEN", hoaDon.getSoDien());
        values.put("SONUOC", hoaDon.getSoNuoc());
        values.put("VESINH", hoaDon.getVeSinh());
        values.put("GUIXE", hoaDon.getGuiXe());
        values.put("WIFI", hoaDon.getWifi());
        values.put("GIAPHONG", hoaDon.getTienPhong());
        values.put("TONGTIEN", hoaDon.getTongTienThanhToan());
        values.put("TRANGTHAITHANHTOAN", hoaDon.getTrangThai());
        long row = database.insert("HOADON", null, values);
        return row > 0;
    }

    public boolean Updata(HoaDon hoaDon) {
        ContentValues values = new ContentValues();
        values.put("TENHOADON", hoaDon.getTenHoaDon());
        values.put("MAPHONG", hoaDon.getMaPhong());
        values.put("TENPHONG", hoaDon.getTenPhong());
        values.put("MAKHACHTHUE", hoaDon.getMaKhachThue());
        values.put("HOTEN", hoaDon.getTenKhachThue());
        values.put("NGAYTHU", hoaDon.getNgayThu());
        values.put("SODIEN", hoaDon.getSoDien());
        values.put("SONUOC", hoaDon.getSoNuoc());
        values.put("VESINH", hoaDon.getVeSinh());
        values.put("GUIXE", hoaDon.getGuiXe());
        values.put("WIFI", hoaDon.getWifi());
        values.put("GIAPHONG", hoaDon.getTienPhong());
        values.put("TONGTIEN", hoaDon.getTongTienThanhToan());
        values.put("TRANGTHAITHANHTOAN", hoaDon.getTrangThai());
        long row = database.update("HOADON", values, "MAHOADON=?", new String[]{hoaDon.getMaHoaDon() + ""});
        return row > 0;
    }

    public boolean Delete(int maHoaDon) {
        int row = database.delete("HOADON", "MAHOADON=?", new String[]{maHoaDon + ""});
        return row > 0;
    }

    public ArrayList<HoaDon> GetALL() {
        ArrayList<HoaDon> listHD = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM HOADON", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            HoaDon hoaDon = new HoaDon();
            hoaDon.setMaHoaDon(cursor.getInt(0));
            hoaDon.setTenHoaDon(cursor.getString(1));
            hoaDon.setMaPhong(cursor.getInt(2));
            hoaDon.setTenPhong(cursor.getString(3));
            hoaDon.setTienPhong(cursor.getInt(4));
            hoaDon.setMaKhachThue(cursor.getInt(5));
            hoaDon.setTenKhachThue(cursor.getString(6));
            hoaDon.setNgayThu(cursor.getString(7));
            hoaDon.setSoDien(cursor.getInt(8));
            hoaDon.setSoNuoc(cursor.getInt(9));
            hoaDon.setVeSinh(cursor.getInt(10));
            hoaDon.setGuiXe(cursor.getInt(11));
            hoaDon.setWifi(cursor.getInt(12));
            hoaDon.setTongTienThanhToan(cursor.getInt(13));
            hoaDon.setTrangThai(cursor.getString(14));
            listHD.add(hoaDon);
            cursor.moveToNext();
        }
        return listHD;

    }
}
