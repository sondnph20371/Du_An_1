package com.example.du_an_alone.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_alone.DTO.DichVu;
import com.example.du_an_alone.SQLiteHelper.SQLite_PhongTro;


import java.util.ArrayList;

public class DichVuDAO {
    SQLiteDatabase database;

    public DichVuDAO(Context context) {
        SQLite_PhongTro sqLife = new SQLite_PhongTro(context);
        database = sqLife.getWritableDatabase();
    }
    public boolean Insert(DichVu dichVu){
        ContentValues values = new ContentValues();
        values.put("TIENDIEN" , dichVu.getTienDien());
        values.put("TIENNUOC"  ,dichVu.getTienNuoc());
        values.put("TIENVESINH"  ,dichVu.getTienVeSinh());
        values.put("TIENGUIXE"  ,dichVu.getTienGuiXe());
        values.put("TIENWIFI"  ,dichVu.getTienWifi());
        long row = database.insert("DICHVU" , null , values);
        return row >0;
    }
    public boolean Updata(DichVu dichVu){
        ContentValues values = new ContentValues();
        values.put("TIENDIEN" , dichVu.getTienDien());
        values.put("TIENNUOC"  ,dichVu.getTienNuoc());
        values.put("TIENVESINH"  ,dichVu.getTienVeSinh());
        values.put("TIENGUIXE"  ,dichVu.getTienGuiXe());
        values.put("TIENWIFI"  ,dichVu.getTienWifi());
        long row = database.update("DICHVU" , values ,"MADICHVU=?" , new String[]{String.valueOf(dichVu.getMaDichVu())});
        return row >0;
    }
    public boolean delete(int id) {
        int row = database.delete("DICHVU", "MADICHVU=?", new String[]{id + ""});
        return row > 0;
    }
    public ArrayList<DichVu> SelectAll(){
        ArrayList<DichVu> listDV = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DICHVU" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            DichVu dichVu = new DichVu();
            dichVu.setMaDichVu(cursor.getInt(0));
            dichVu.setTienDien(cursor.getInt(1));
            dichVu.setTienNuoc(cursor.getInt(2));
            dichVu.setTienVeSinh(cursor.getInt(3));
            dichVu.setTienGuiXe(cursor.getInt(4));
            dichVu.setTienWifi(cursor.getInt(5));
            listDV.add(dichVu);
            cursor.moveToNext();
        }
        return listDV;
    }
}
