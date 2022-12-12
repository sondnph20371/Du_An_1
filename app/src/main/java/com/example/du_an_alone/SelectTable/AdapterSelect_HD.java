package com.example.du_an_alone.SelectTable;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.du_an_alone.DTO.HopDong;
import com.example.du_an_alone.R;

import java.util.ArrayList;


public class AdapterSelect_HD extends BaseAdapter {
    ArrayList<HopDong> list;
    public AdapterSelect_HD(ArrayList<HopDong> list) {
        this.list = list;
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hoadon_selectt,parent,false);
        TextView tvMaHopDong, tvMaPhong, tvTenPhong , tvMaKhachThue ,  tvTenKhachThue,tvGiaPhong , tvTienCoc;
        tvMaPhong = view.findViewById(R.id.txtmaphong);
        tvTenPhong = view.findViewById(R.id.txtTenPhong);
        tvMaHopDong = view.findViewById(R.id.txtMaHopDong);
        tvMaKhachThue = view.findViewById(R.id.txtMaKhachThue);
        tvTenKhachThue = view.findViewById(R.id.txttenkhachthue);
        tvGiaPhong = view.findViewById(R.id.txtGiaTien);

        HopDong hopDong = list.get(position);
        int mahopdong = hopDong.getMaHopDong();
        int  makhachthue = hopDong.getMaKhachThue();
        int maphong = hopDong.getMaPhong();
        String tenPhong = hopDong.getTenPhong();
        String tenKhachThue = hopDong.getTenKhachHang();
        int giaphong = hopDong.getGiaPhong();
        tvMaHopDong.setText("Mã Hợp Đồng: "+mahopdong +"");
        tvMaKhachThue.setText("Mã Khách Thuê: "+makhachthue);
        tvMaPhong.setText("Mã Phòng: "+maphong+"");
        tvTenPhong.setText("Tên Phòng: "+tenPhong);
        tvTenKhachThue.setText("Tên Khách Thuê: "+tenKhachThue);
        tvGiaPhong.setText("Giá Phòng: "+giaphong);
        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}