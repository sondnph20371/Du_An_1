package com.example.du_an_alone.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_alone.DTO.HopDong;
import com.example.du_an_alone.DTO.LoaiPhong;
import com.example.du_an_alone.DTO.Phong;
import com.example.du_an_alone.SQLiteHelper.SQLite_PhongTro;

import java.util.ArrayList;
import java.util.List;

public class HopDongDAO {
    SQLiteDatabase database;

    public HopDongDAO(Context context) {
        SQLite_PhongTro sqLite_phongTro = new SQLite_PhongTro(context);
        database = sqLite_phongTro.getWritableDatabase();
    }
    public boolean Insert(HopDong hopDong){
        ContentValues values  = new ContentValues();
        values.put("MAPHONG" , hopDong.getMaPhong());
        values.put("TENPHONG" , hopDong.getTenPhong());
        values.put("MAKHACHTHUE" , hopDong.getMaKhachThue());
        values.put("HOTEN" , hopDong.getTenKhachHang());
        values.put("QUEQUAN" , hopDong.getQueQuan());
        values.put("SODIENTHOAI" , hopDong.getSoDienThoai());
        values.put("CCCD" , hopDong.getCCCD());
        values.put("NGAYLAMHOPDONG" , hopDong.getNgayLamHopDong());
        values.put("NGAYKETTHUC" , hopDong.getNgayKetThuc());
        values.put("MADICHVU" , hopDong.getMaDichVu());
        values.put("TIENDIEN" , hopDong.getTienDien());
        values.put("TIENNUOC"  ,hopDong.getTienNuoc());
        values.put("TIENVESINH"  ,hopDong.getTienVeSinh());
        values.put("TIENGUIXE"  ,hopDong.getTienGuiXe());
        values.put("TIENWIFI"  ,hopDong.getTienWifi());
        values.put("GIAPHONG" , hopDong.getGiaPhong());
        values.put("TIENCOC" , hopDong.getTienCoc());
        values.put("TRANGTHAITIENCOC" , hopDong.getTrangThaitiencoc());
        long row = database.insert("HOPDONG" , null , values);
        return row > 0;
    }
    public boolean Updata(HopDong hopDong){
        ContentValues values = new ContentValues();
        values.put("MAPHONG" , hopDong.getMaPhong());
        values.put("TENPHONG" , hopDong.getTenPhong());
        values.put("MAKHACHTHUE" , hopDong.getMaKhachThue());
        values.put("HOTEN" , hopDong.getTenKhachHang());
        values.put("QUEQUAN" , hopDong.getQueQuan());
        values.put("SODIENTHOAI" , hopDong.getSoDienThoai());
        values.put("CCCD" , hopDong.getCCCD());
        values.put("NGAYLAMHOPDONG" , hopDong.getNgayLamHopDong());
        values.put("NGAYKETTHUC" , hopDong.getNgayKetThuc());
        values.put("MADICHVU" , hopDong.getMaDichVu());
        values.put("TIENDIEN" , hopDong.getTienDien());
        values.put("TIENNUOC"  ,hopDong.getTienNuoc());
        values.put("TIENVESINH"  ,hopDong.getTienVeSinh());
        values.put("TIENGUIXE"  ,hopDong.getTienGuiXe());
        values.put("TIENWIFI"  ,hopDong.getTienWifi());
        values.put("GIAPHONG" , hopDong.getGiaPhong());
        values.put("TIENCOC" , hopDong.getTienCoc());
        values.put("TRANGTHAITIENCOC" , hopDong.getTrangThaitiencoc());
        long row = database.update("HOPDONG" , values , "MAHOPDONG=?" , new String[]{hopDong.getMaHopDong()+""});
        return row >0 ;
    }
    public boolean Delete(int maHopDong){
        int row = database.delete("HOPDONG" , "MAHOPDONG=?" , new String[]{maHopDong+""});
        return row > 0;
    }
    public ArrayList<HopDong> GetALL(){
        ArrayList<HopDong> listHD = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM HOPDONG" , null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            while (!cursor.isAfterLast()){
                HopDong hopDong = new HopDong();
                hopDong.setMaHopDong(cursor.getInt(0));
                hopDong.setMaPhong(cursor.getInt(1));
                hopDong.setTenPhong(cursor.getString(2));
                hopDong.setMaKhachThue(cursor.getInt(3));
                hopDong.setQueQuan(cursor.getString(4));
                hopDong.setCCCD(cursor.getInt(5));
                hopDong.setSoDienThoai(cursor.getInt(6));
                hopDong.setTenKhachHang(cursor.getString(7));
                hopDong.setNgayLamHopDong(cursor.getString(8));
                hopDong.setNgayKetThuc(cursor.getString(9));
                hopDong.setMaDichVu(cursor.getInt(10));
                hopDong.setTienCoc(cursor.getInt(11));
                hopDong.setGiaPhong(cursor.getInt(12));
                hopDong.setTrangThaitiencoc(cursor.getInt(13));
                hopDong.setTienDien(cursor.getInt(14));
                hopDong.setTienNuoc(cursor.getInt(15));
                hopDong.setTienVeSinh(cursor.getInt(16));
                hopDong.setTienGuiXe(cursor.getInt(17));
                hopDong.setTienWifi(cursor.getInt(18));
                listHD.add(hopDong);
                cursor.moveToNext();
            }
        }
        return listHD;
    }
    public List<HopDong> getAll(){
        String sql = "SELECT * FROM HOPDONG";
        return GetALL();
    }



}
