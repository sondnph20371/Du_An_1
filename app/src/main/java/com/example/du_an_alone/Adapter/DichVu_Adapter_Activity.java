package com.example.du_an_alone.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.du_an_alone.ChucNangChinh.DichVu_Activity;
import com.example.du_an_alone.ChucNangChinh.DichVu_Fragment;
import com.example.du_an_alone.DTO.DichVu;
import com.example.du_an_alone.R;

import java.util.ArrayList;

public class DichVu_Adapter_Activity extends ArrayAdapter<DichVu> {
    Context context;
    ArrayList<DichVu> listDV;
    DichVu_Activity activity;
    TextView tvMaDichVu, tvTienDien , tvTienNuoc , tvTienveSinh , tvTienGuiXe  , tvTienWifi;
    DichVu_Fragment fragment;

    public DichVu_Adapter_Activity(Context context, DichVu_Activity activity, ArrayList<DichVu> listDV) {
        super(context, 0, listDV);
        this.context = context;
        this.listDV = listDV;
        this.activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_dichvu_activity, null);
        }
        final DichVu dichVu = listDV.get(position);
        if (dichVu!=null){
            tvMaDichVu = view.findViewById(R.id.txtMadichvu_itemDichVu);
            tvMaDichVu.setText("Dịch Vụ");
            Log.d("ZZZZ" , dichVu.getMaDichVu()+"");
            tvTienDien = view.findViewById(R.id.txtgiadien_itemDichVu);
            tvTienDien.setText("Giá Tiền Điện: "+dichVu.getTienDien()+"/Kw");

            tvTienNuoc = view.findViewById(R.id.txtgianuoc_itemDichVu);
            tvTienNuoc.setText("Giá Tiền Nước: "+dichVu.getTienNuoc()+"/Khối");

            tvTienveSinh = view.findViewById(R.id.txtvesinh_itemDichVu);
            tvTienveSinh.setText("Giá Vệ Sinh: "+dichVu.getTienVeSinh()+"/Người");

            tvTienGuiXe = view.findViewById(R.id.txtguixe_itemDichVu);
            tvTienGuiXe.setText("Giá Tiền Gửi Xe: "+dichVu.getTienGuiXe()+"/Cái");

            tvTienWifi = view.findViewById(R.id.txtwifi_itemDichVu);
            tvTienWifi.setText("Giá Tiền WiFi: "+dichVu.getTienWifi()+"/Người");
        }
        return view;
    }

}
