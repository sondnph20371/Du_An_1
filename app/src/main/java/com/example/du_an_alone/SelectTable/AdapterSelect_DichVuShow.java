package com.example.du_an_alone.SelectTable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.du_an_alone.DTO.DichVu;
import com.example.du_an_alone.R;

import java.util.ArrayList;


public class AdapterSelect_DichVuShow extends BaseAdapter {
    ArrayList<DichVu> listDichVu;
    public AdapterSelect_DichVuShow(ArrayList<DichVu> listDichVu) {
        this.listDichVu = listDichVu;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dichvu_activity,parent,false);
        TextView tvMaDichVu, tvTienDien, tvTienNuoc , tvTienVeSinh ,  tvTienGuiXe , tvTienWifi;
        tvMaDichVu = view.findViewById(R.id.txtMadichvu_itemDichVu);
        tvTienDien = view.findViewById(R.id.txtgiadien_itemDichVu);
        tvTienNuoc = view.findViewById(R.id.txtgianuoc_itemDichVu);
        tvTienVeSinh = view.findViewById(R.id.txtvesinh_itemDichVu);
        tvTienGuiXe = view.findViewById(R.id.txtguixe_itemDichVu);
        tvTienWifi = view.findViewById(R.id.txtwifi_itemDichVu);
        DichVu dichVu = listDichVu.get(position);
        tvMaDichVu.setText("Mã Dịch Vụ: "+dichVu.getMaDichVu());
        tvTienDien.setText("Tiền Điện: "+dichVu.getTienDien());
        tvTienNuoc.setText("Tiền Nước: "+dichVu.getTienNuoc());
        tvTienVeSinh.setText("Tiền Vệ Sinh: "+dichVu.getTienVeSinh());
        tvTienGuiXe.setText("Tiền Gữi Xe: "+dichVu.getTienGuiXe());
        tvTienWifi.setText("Tiền WiFi: "+dichVu.getTienWifi());
        return view;
    }

    @Override
    public int getCount() {
        return listDichVu.size();
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