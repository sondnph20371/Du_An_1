package com.example.du_an_alone.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_alone.DTO.KhachThue;
import com.example.du_an_alone.SQLiteHelper.SQLite_PhongTro;

import java.util.ArrayList;

public class KhachThueDAO {
    SQLiteDatabase database;

    public KhachThueDAO(Context context) {
        SQLite_PhongTro sqLite = new SQLite_PhongTro(context);
        database = sqLite.getWritableDatabase();
    }
    public boolean Insert(KhachThue khachThue){
        ContentValues values = new ContentValues();
        values.put("HOTEN" , khachThue.getTen());
        values.put("GIOITINH" , khachThue.getGioiTinh());
        values.put("NGAYSINH" , khachThue.getNgaySinh());
        values.put("CCCD" , khachThue.getCCCD());
        values.put("QUEQUAN" , khachThue.getQueQuan());
        values.put("NGHENGHIEP" , khachThue.getNgheNghiep());
        values.put("SODIENTHOAI" , khachThue.getSoDienThoai());
        long row = database.insert("KHACHTHUE" , null , values);
        return row > 0;
    }
    public boolean Updata(KhachThue khachThue){
        ContentValues values = new ContentValues();
        values.put("HOTEN" , khachThue.getTen());
        values.put("GIOITINH" , khachThue.getGioiTinh());
        values.put("NGAYSINH" , khachThue.getNgaySinh());
        values.put("CCCD" , khachThue.getCCCD());
        values.put("QUEQUAN" , khachThue.getQueQuan());
        values.put("NGHENGHIEP" , khachThue.getNgheNghiep());
        values.put("SODIENTHOAI" , khachThue.getSoDienThoai());

        long row  = database.update("KHACHTHUE" , values , "MAKHACHTHUE=?" , new String[]{String.valueOf(khachThue.getMaKhachThue())});
        return row > 0;
    }
    public boolean Delete(int maKhachThue){
        int row = database.delete("KHACHTHUE" , "MAKHACHTHUE=?" , new String[]{maKhachThue+""});
        return row > 0;
    }
    public ArrayList<KhachThue> GetALL(){
        ArrayList<KhachThue> listKT = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM KHACHTHUE" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            KhachThue khachThue  = new KhachThue();
            khachThue.setMaKhachThue(cursor.getInt(0));
            khachThue.setTen(cursor.getString(1));
            khachThue.setGioiTinh(cursor.getString(2));
            khachThue.setNgaySinh(cursor.getString(3));
            khachThue.setCCCD(cursor.getInt(4));
            khachThue.setQueQuan(cursor.getString(5));
            khachThue.setSoDienThoai(cursor.getInt(6));
            khachThue.setNgheNghiep(cursor.getString(7));
            listKT.add(khachThue);
            cursor.moveToNext();
        }
        return listKT;
    }


}
