package com.example.du_an_alone.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_alone.DTO.DichVu;
import com.example.du_an_alone.DTO.DichVuCT;
import com.example.du_an_alone.SQLiteHelper.SQLite_PhongTro;

import java.util.ArrayList;

public class DichVuCTDAO {
    SQLiteDatabase database;

    public DichVuCTDAO(Context context) {
        SQLite_PhongTro sqLife = new SQLite_PhongTro(context);
        database = sqLife.getWritableDatabase();
    }
    public boolean Insert(DichVuCT dichVuCT){
        ContentValues values = new ContentValues();
        values.put("TENDICHVU" , dichVuCT.getTenDichVu());
        values.put("GIADICHVU"  ,dichVuCT.getGiaDichVu());
        values.put("GHICHU" , dichVuCT.getGhiChu());
        long row = database.insert("DICHVUCT" , null , values);
        return row >0;
    }
    public boolean Updata(DichVuCT dichVuCT){
        ContentValues values = new ContentValues();
        values.put("TENDICHVU" , dichVuCT.getTenDichVu());
        values.put("GIADICHVU"  ,dichVuCT.getGiaDichVu());
        values.put("GHICHU" , dichVuCT.getGhiChu());
        long row = database.update("DICHVUCT" , values ,"MADICHVUCT=?" , new String[]{String.valueOf(dichVuCT.getMaDichVuCt())});
        return row >0;
    }
    public boolean delete(int id) {
        int row = database.delete("DICHVUCT", "MADICHVUCT=?", new String[]{id + ""});
        return row > 0;
    }
    public ArrayList<DichVuCT> SelectAll(){
        ArrayList<DichVuCT> listDVCT = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DICHVUCT" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            DichVuCT dichVuCT = new DichVuCT();
            dichVuCT.setMaDichVuCt(cursor.getInt(0));
            dichVuCT.setTenDichVu(cursor.getString(1));
            dichVuCT.setGiaDichVu(cursor.getInt(2));
            dichVuCT.setGhiChu(cursor.getString(3));
            listDVCT.add(dichVuCT);
            cursor.moveToNext();
        }
        return listDVCT;
    }
}
