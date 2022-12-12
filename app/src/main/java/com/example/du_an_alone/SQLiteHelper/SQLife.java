package com.example.du_an_alone.SQLiteHelper;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.example.du_an_alone.DTO.DangNhap;

import java.util.ArrayList;

public class SQLife extends SQLiteOpenHelper {
    Context contextT;
    SharedPreferences sharedPreferences;

    public SQLife(@Nullable Context context) {
        super(context, "database.txt", null, 1);
        contextT  = context;
        sharedPreferences = context.getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS NHANVIEN");
        db.execSQL("CREATE TABLE NHANVIEN(MANV INTEGER PRIMARY KEY AUTOINCREMENT," +
                "USERNAME TEXT NOT NULL," +
                "PASSWORD TEXT NOT NULL," +
                "NAMENV TEXT NOT NULL," +
                "NUMBERPHONE INTEGER NOT NULL," +
                "DIACHI TEXT NOT NULL," +
                "NGAYSINH TEXT NOT NULL," +
                "GIOITINH TEXT NOT NULL," +
                "VAITRO TEXT NOT NULL," +
                "IMAGE INTEGER NOT NULL) ");
    }
    public void AddNhanVien(DangNhap dangNhap)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME", dangNhap.getUserName());
        contentValues.put("PASSWORD", dangNhap.getPassWord());
        contentValues.put("NAMENV", dangNhap.getTenNV());
        contentValues.put("NUMBERPHONE", dangNhap.getNumberPhone());
        contentValues.put("DIACHI", dangNhap.getDiaChi());
        contentValues.put("NGAYSINH", dangNhap.getNgaySinh());
        contentValues.put("GIOITINH", dangNhap.getGioiTinh());
        contentValues.put("VAITRO", dangNhap.getVaiTro());
        contentValues.put("IMAGE", dangNhap.getImageNV());
        SQLiteDatabase database = getReadableDatabase();
        database.insert("NHANVIEN",null,contentValues);
    }
    public DangNhap getOneNV(String MANV_)
    {
        SQLiteDatabase database = getReadableDatabase();
        DangNhap dangNhap = new DangNhap();
        Cursor cursor = database.rawQuery("SELECT * FROM NHANVIEN WHERE MANV = '"+MANV_+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                int MANV = cursor.getInt(0);
                String USERNAME = cursor.getString(1);
                String PASSWORD = cursor.getString(2);
                String NAMENV = cursor.getString(3);
                int NUMBERPHONE = cursor.getInt(4);
                String DIACHI = cursor.getString(5);
                String NGAYSINH = cursor.getString(6);
                String GIOITINH = cursor.getString(7);
                String VAITRO = cursor.getString(8);
                int IMAGENV = cursor.getInt(9);
                dangNhap = new DangNhap(MANV,USERNAME,PASSWORD,NAMENV,NUMBERPHONE,DIACHI,NGAYSINH,GIOITINH,VAITRO,IMAGENV);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return dangNhap;
    }
    public ArrayList<DangNhap> getALLNV()
    {
        SQLiteDatabase database = getReadableDatabase();
        ArrayList<DangNhap> dangNhaps = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM NHANVIEN",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                int MaNV = cursor.getInt(0);
                String USERNAME = cursor.getString(1);
                String PASSWORD = cursor.getString(2);
                String TENNV = cursor.getString(3);
                int NUMBERPHONE = cursor.getInt(4);
                String DIACHI = cursor.getString(5);
                String NgaySinh = cursor.getString(6);
                String GIOITINH = cursor.getString(7);
                String VaiTro = cursor.getString(8);
                int IMAGENV = cursor.getInt(9);
                DangNhap dangNhap = new DangNhap(MaNV,USERNAME,PASSWORD,TENNV,NUMBERPHONE,DIACHI,NgaySinh,GIOITINH,VaiTro,IMAGENV);
                dangNhaps.add(dangNhap);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return dangNhaps;
    }
    public void DeleteNV(String MANV1)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("NHANVIEN","MANV=?",new String[]{MANV1+""});
    }
    public void UpdateNV(DangNhap dangNhap)
    {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME", dangNhap.getUserName());
        contentValues.put("PASSWORD", dangNhap.getPassWord());
        contentValues.put("NAMENV", dangNhap.getTenNV());
        contentValues.put("NUMBERPHONE", dangNhap.getNumberPhone());
        contentValues.put("DIACHI", dangNhap.getDiaChi());
        contentValues.put("NGAYSINH", dangNhap.getNgaySinh());
        contentValues.put("GIOITINH", dangNhap.getGioiTinh());
        contentValues.put("VAITRO", dangNhap.getVaiTro());
        contentValues.put("IMAGE", dangNhap.getImageNV());
        database.update("NHANVIEN",contentValues,"MANV=?",new String[]{dangNhap.getMaNV()+""});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void checkLogin(String user, String pass) {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM NHANVIEN WHERE USERNAME=? AND PASSWORD=?", new String[]{user, pass});
        if(cursor.getCount() != 0) {
            cursor.moveToFirst();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", cursor.getString(3));
            editor.putString("phone", cursor.getString(4));
            editor.commit();


        }
    }

    public boolean forgotPass(String user, String newPass) {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM NHANVIEN WHERE USERNAME=?", new String[]{user});
        if(cursor.getCount() != 0) {
            ContentValues values = new ContentValues();
            values.put("PASSWORD", newPass);
            long check = database.update("NHANVIEN",values, "USERNAME=?", new String[]{user});
           if(check==-1){
               return false;
            }
           else {
               return  true;
           }
        }
        return false;

    }
}
