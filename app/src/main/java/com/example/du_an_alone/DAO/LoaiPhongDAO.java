package com.example.du_an_alone.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_alone.DTO.LoaiPhong;
import com.example.du_an_alone.SQLiteHelper.SQLite_PhongTro;

import java.util.ArrayList;
import java.util.List;

public class LoaiPhongDAO {
    SQLiteDatabase db;

    public LoaiPhongDAO(Context context) {
        SQLite_PhongTro sqlite = new SQLite_PhongTro(context);
        db = sqlite.getWritableDatabase();
    }
    public boolean Insert(LoaiPhong loaiPhong){
        ContentValues values = new ContentValues();
        values.put("TENLOAIPHONG" , loaiPhong.getTenLoaiPhong());
        long row = db.insert("LOAIPHONG" , null , values);
        return row > 0;
    }
    public boolean Updata(LoaiPhong loaiPhong){
        ContentValues values = new ContentValues();
        values.put("TENLOAIPHONG" , loaiPhong.getTenLoaiPhong());
        long row = db.update("LOAIPHONG" , values , "MALOAIPHONG=?" , new String[]{String.valueOf(loaiPhong.getId())});
        return row > 0;
    }
    public boolean Delete(int maLoaiPhong){
        int row = db.delete("LOAIPHONG" , "MALOAIPHONG=?" , new String[]{maLoaiPhong+""});
        return row > 0;
    }
    public ArrayList<LoaiPhong> GetALL(){
        ArrayList<LoaiPhong> listLP = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM LOAIPHONG" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LoaiPhong loaiPhong = new LoaiPhong();
            loaiPhong.setId(cursor.getInt(0));
            loaiPhong.setTenLoaiPhong(cursor.getString(1));
            listLP.add(loaiPhong);
            cursor.moveToNext();
        }
        return listLP;
    }
    public List<LoaiPhong> getAll(){
        String sql = "SELECT * FROM LOAIPHONG";
        return GetALL();
    }
    public LoaiPhong getID(String maLoai){
        String sql = "SELECT * FROM LOAIPHONG WHERE MALOAIPHONG=?";
        List<LoaiPhong> list = GetALL();
        return list.get(0);
    }
}
