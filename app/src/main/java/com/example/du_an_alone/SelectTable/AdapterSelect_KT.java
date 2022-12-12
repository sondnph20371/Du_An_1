package com.example.du_an_alone.SelectTable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.du_an_alone.DTO.KhachThue;
import com.example.du_an_alone.R;

import java.util.ArrayList;

public class AdapterSelect_KT extends BaseAdapter {
    ArrayList<KhachThue> listKhachThue;
    int MaLoaiSelect;
    public AdapterSelect_KT(ArrayList<KhachThue> listKhachThue) {
        this.listKhachThue = listKhachThue;
    }

    public int getMaLoaiSelect() {
        return MaLoaiSelect;
    }

    public void setMaLoaiSelect(int maLoaiSelect) {
        MaLoaiSelect = maLoaiSelect;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_kh,parent,false);
        TextView txtRowMaKH,txtRowTenKH,txtRowGioiTinh,txtRowPhoneKH;
        txtRowMaKH = view.findViewById(R.id.txtRowMaKH_SELECT);
        txtRowTenKH = view.findViewById(R.id.txtRowTenKH_SELECT);
        txtRowGioiTinh = view.findViewById(R.id.txtRowGioiTinhKH_SELECT);
        txtRowPhoneKH = view.findViewById(R.id.txtRowPhoneKH_SELECT);
        KhachThue khachThue = listKhachThue.get(position);
        int MAKH = khachThue.getMaKhachThue();
        String TENKH = khachThue.getTen();
        int NumberPhone = khachThue.getSoDienThoai();
        String DiaChi = khachThue.getQueQuan();
        String GioiTinh = khachThue.getGioiTinh();
        String NgaySinh = khachThue.getNgaySinh();
        txtRowMaKH.setText("Mã Khách Thuê: "+MAKH+"");
        txtRowTenKH.setText("Tên Khách Thuê: "+TENKH);
        txtRowGioiTinh.setText("Giới Tính: "+GioiTinh);
        txtRowPhoneKH.setText("NumberPhone: "+NumberPhone);
        return view;
    }

    @Override
    public int getCount() {
        return listKhachThue.size();
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
