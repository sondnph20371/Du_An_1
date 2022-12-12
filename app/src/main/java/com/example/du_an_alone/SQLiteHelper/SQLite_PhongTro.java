package com.example.du_an_alone.SQLiteHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLite_PhongTro extends SQLiteOpenHelper {
    Context contextT;
    public SQLite_PhongTro(Context context ) {
        super(context, "SQLITE.txt", null, 1);
        this.contextT = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS DANGNHAP");
        db.execSQL("DROP TABLE IF EXISTS LOAIPHONG");
        db.execSQL("DROP TABLE IF EXISTS PHONG");
        db.execSQL("DROP TABLE IF EXISTS DICHVU");
        db.execSQL("DROP TABLE IF EXISTS KHACHTHUE");
        db.execSQL("DROP TABLE IF EXISTS HOADON");
        db.execSQL("DROP TABLE IF EXISTS HOPDONG");
        String db_table_dangnhap = ("CREATE TABLE DANGNHAP(MADANGNHAP INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ," +
                " USERNAME TEXT NOT NULL , PASSWORD TEXT NOT NULL , TENNGUOIDUNG TEXT NOT NULL ," +
                " NGAYSINH TEXT NOT NULL , DIACHI TEXT NOT NULL ,SODIENTHOAI INTEGER NOT NULL  ," +
                " GIOITINH TEXT NOT NULL)");
        db.execSQL(db_table_dangnhap);

        db.execSQL("CREATE TABLE LOAIPHONG(MALOAIPHONG INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TENLOAIPHONG TEXT NOT NULL)");

        db.execSQL("CREATE TABLE PHONG(MAPHONG INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                "TENPHONG TEXT NOT NULL ," +
                "DIENTICHPHONG INTEGER NOT NULL," +
                "GIAPHONG INTEGER NOT NULL," +
                "TRANGTHAITIENCOC INTEGER NOT NULL REFERENCES HOPDONG(TRANGTHAITIENCOC)," +
                "TENLOAIPHONG TEXT NOT NULL REFERENCES LOAIPHONG(TENLOAIPHONG))");

        db.execSQL("CREATE TABLE DICHVU(MADICHVU INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "TIENDIEN INTEGER NOT NULL,"+
                "TIENNUOC INTEGER NOT NULL,"+
                "TIENVESINH INTEGER NOT NULL,"+
                "TIENGUIXE INTEGER NOT NULL,"+
                "TIENWIFI INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE DICHVUCT(MADICHVUCT INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "TENDICHVU TEXT NOT NULL,"+
                "GIADICHVU INTEGER NOT NULL,"+
                "GHICHU TEXT)");

        db.execSQL("CREATE TABLE KHACHTHUE(MAKHACHTHUE INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT  ," +
                " HOTEN TEXT NOT NULL ," +
                " GIOITINH TEXT NOT NULL ," +
                " NGAYSINH TEXT NOT NULL," +
                " CCCD INTEGER NOT NULL ," +
                " QUEQUAN TEXT NOT NULL ," +
                " SODIENTHOAI INTEGER NOT NULL ," +
                " NGHENGHIEP TEXT NOT NULL )");

        db.execSQL("CREATE TABLE HOADON(MAHOADON INTEGER PRIMARY KEY AUTOINCREMENT," +
                " TENHOADON TEXT NOT NULL," +
                " MAPHONG INTEGER NOT NULL REFERENCES HOPDONG(MAPHONG)," +
                " TENPHONG TEXT NOT NULL REFERENCES HOPDONG(TENPHONG)," +
                " GIAPHONG INTEGER NOT NULL REFERENCES HOPDONG(GIAPHONG)," +
                " MAKHACHTHUE INTEGER NOT NULL REFERENCES HOPDONG(MAKHACHTHUE)," +
                " HOTEN TEXT NOT NULL REFERENCES HOPDONG(HOTEN),"+
                " NGAYTHU DATE NOT NULL," +
                " SODIEN INTEGER NOT NULL ," +
                " SONUOC INTEGER NOT NULL ," +
                " VESINH INTEGER NOT NULL ," +
                " GUIXE INTEGER NOT NULL ," +
                " WIFI INTEGER NOT NULL ," +
                " TONGTIEN INTEGER NOT NULL , " +
                " TRANGTHAITHANHTOAN TEXT NOT NULL )");

        db.execSQL("CREATE TABLE HOPDONG(MAHOPDONG INTEGER PRIMARY KEY AUTOINCREMENT," +
                " MAPHONG INTEGER NOT NULL REFERENCES PHONG(MAPHONG)," +
                " TENPHONG TEXT NOT NULL REFERENCES PHONG(TENPHONG)," +
                " MAKHACHTHUE INTEGER NOT NULL REFERENCES KHACHTHUE(MAKHACHTHUE)," +
                " QUEQUAN TEXT NOT NULL REFERENCES KHACHTHUE(QUEQUAN)," +
                " CCCD INTEGER NOT NULL REFERENCES KHACHTHUE(CCCD)," +
                " SODIENTHOAI INTEGER NOT NULL REFERENCES KHACHTHUE(SODIENTHOAI)," +
                " HOTEN TEXT NOT NULL REFERENCES KHACHTHUE(HOTEN)," +
                " NGAYLAMHOPDONG DATE NOT NULL ," +
                " NGAYKETTHUC DATE NOT NULL," +
                " MADICHVU INTEGER NOT NULL  REFERENCES DICHVU(MADICHVU)," +
                " TIENCOC INTEGER NOT NULL ," +
                " GIAPHONG INTEGER NOT NULL REFERENCES PHONG(GIAPHONG)," +
                " TRANGTHAITIENCOC INTEGER NOT NULL, "+
                " TIENDIEN INTEGER  NOT NULL REFERENCES DICHVU(TIENDIEN)," +
                " TIENNUOC INTEGER  NOT NULL REFERENCES DICHVU(TIENNUOC)," +
                " TIENVESINH INTEGER  NOT NULL REFERENCES DICHVU(TIENVESINH)," +
                " TIENGUIXE INTEGER  NOT NULL REFERENCES DICHVU(TIENGUIXE)," +
                " TIENWIFI INTEGER  NOT NULL REFERENCES DICHVU(TIENWIFI) )");

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOAIPHONG");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PHONG");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DICHVU");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS KHACHTHUE");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS HOADON");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS HOPDONG");
    }
}
