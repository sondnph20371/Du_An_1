package com.example.du_an_alone.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_alone.DTO.Phong;
import com.example.du_an_alone.SQLiteHelper.SQLite_PhongTro;

import java.util.ArrayList;
import java.util.List;

public class PhongDAO {
    SQLiteDatabase database;

    public PhongDAO(Context context) {
        SQLite_PhongTro sqLite = new SQLite_PhongTro(context);
        database = sqLite.getWritableDatabase();
    }

    public boolean Insert(Phong phong){
        ContentValues values = new ContentValues();
        values.put("TENPHONG" , phong.getTenPhong());
        values.put("DIENTICHPHONG" , phong.getDienTichPhong());
        values.put("GIAPHONG" , phong.getGiaPhong());
        values.put("TRANGTHAITIENCOC" , phong.getTrangThaiTienCoc());
        values.put("TENLOAIPHONG" , phong.getTenLoaiPhong());
     long row = database.insert("PHONG" , null , values);
     return row > 0;
    }

    public boolean Updata(Phong phong){
        ContentValues values = new ContentValues();
        values.put("TENPHONG" , phong.getTenPhong());
        values.put("DIENTICHPHONG" , phong.getDienTichPhong());
        values.put("GIAPHONG" , phong.getGiaPhong());
        values.put("TRANGTHAITIENCOC" , phong.getTrangThaiTienCoc());
        values.put("TENLOAIPHONG" , phong.getTenLoaiPhong());
        long row = database.update("PHONG" , values , "MAPHONG = ?" , new String[]{String.valueOf(phong.getId())});
        return row>0;
    }

    public boolean Delete(int id){
        int row = database.delete("PHONG" , "MAPHONG=?" , new String[]{id+""});
        return row>0;
    }

    public ArrayList<Phong> GetAll(){
        ArrayList<Phong> listP = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT *FROM PHONG" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Phong phong = new Phong();
            phong.setId(cursor.getInt(0));
            phong.setTenLoaiPhong(cursor.getString(5));
            phong.setTenPhong(cursor.getString(1));
            phong.setDienTichPhong(cursor.getInt(2));
            phong.setGiaPhong(cursor.getInt(3));
            phong.setTrangThaiTienCoc(cursor.getInt(4));
            listP.add(phong);
            cursor.moveToNext();
        }
        return listP;
    }
    public List<Phong> getAll(){
        String sql = "SELECT * FROM PHONG";
        return GetAll();
    }
    public Phong getID(String tenPhong){
        String sql = "SELECT * FROM LOAIPHONG WHERE MAPHONG AND TENPHONG=?" ;
        List<Phong> list = GetAll();
        return list.get(0);
    }

    public boolean updateTrangThai(int id, int trangThai) {
        Cursor cursor = database.rawQuery("SELECT * FROM PHONG WHERE MAPHONG=?", new String[]{id+""});
        if(cursor.getCount()>0) {
            ContentValues values = new ContentValues();
            values.put("TRANGTHAITIENCOC", trangThai);
            long check = database.update("PHONG",values, "MAPHONG=?", new String[]{id+""});
            if(check == -1) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Phong> getPhongTrong() {
        ArrayList<Phong> listP = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM PHONG WHERE  MAPHONG NOT IN (SELECT MAPHONG FROM HOPDONG) ", null);
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                Phong phong = new Phong();
                phong.setId(cursor.getInt(0));
                phong.setTenLoaiPhong(cursor.getString(5));
                phong.setTenPhong(cursor.getString(1));
                phong.setDienTichPhong(cursor.getInt(2));
                phong.setGiaPhong(cursor.getInt(3));
                phong.setTrangThaiTienCoc(cursor.getInt(4));
                listP.add(phong);
                cursor.moveToNext();
            }
        }
        return listP;

    }

}
