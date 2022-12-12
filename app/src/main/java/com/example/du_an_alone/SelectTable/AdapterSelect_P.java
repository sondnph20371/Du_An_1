package com.example.du_an_alone.SelectTable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.du_an_alone.DTO.Phong;
import com.example.du_an_alone.R;

import java.util.ArrayList;



public class AdapterSelect_P extends BaseAdapter {
    ArrayList<Phong> listPhong;
    public AdapterSelect_P(ArrayList<Phong> listPhong) {
        this.listPhong = listPhong;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemselect_phong,parent,false);
        TextView tvMaPhong, tvTenPhong , tvTenLoaiPhong ,  tvDienTichPhong , tvDonGiaPhong, tvTienCoc , tvtrangThaiPhong;
        tvMaPhong = view.findViewById(R.id.txtMaPhong_itemPhong);
        tvTenPhong = view.findViewById(R.id.txtTenPhong_itemPhong);
        tvTenLoaiPhong = view.findViewById(R.id.txttenloaiphong_itemPhong);
        tvDienTichPhong = view.findViewById(R.id.txtDienTichPhong_itemPhong);
        tvDonGiaPhong = view.findViewById(R.id.txtGiaPhong_itemPhong);
        Phong phong = listPhong.get(position);
        int maPhong = phong.getId();
        String tenPhong = phong.getTenPhong();
        String tenLoaiPhong = phong.getTenLoaiPhong();
        int DienTich = phong.getDienTichPhong();
        int donGia = phong.getGiaPhong();
        tvMaPhong.setText("Mã Phòng: "+maPhong+"");
        tvTenPhong.setText("Tên Phòng: "+tenPhong);
        tvTenLoaiPhong.setText("Tên Loại Phòng: "+tenLoaiPhong);
        tvDienTichPhong.setText("Diện Tích Phòng: "+DienTich+"m2");
        tvDonGiaPhong.setText("Đơn Giá Phòng: "+donGia+" Triệu VNĐ");
        return view;
    }

    @Override
    public int getCount() {
        return listPhong.size();
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