package com.example.du_an_alone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.du_an_alone.DTO.LoaiPhong;
import com.example.du_an_alone.R;

import java.util.ArrayList;
import java.util.List;

public class Spinner_LoaiPhong_Adapter extends ArrayAdapter<LoaiPhong> {
    Context context;
    ArrayList<LoaiPhong> listLP;
    TextView tvMaLoaiPhong ,tvTenLoaiPhong;

    public Spinner_LoaiPhong_Adapter( Context context  , ArrayList<LoaiPhong> listLP) {
        super(context, 0, listLP);
        this.context = context;
        this.listLP = listLP;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.spinner_loaiphong , null);
        }
        final LoaiPhong item = listLP.get(position);
        if (item!=null){
            tvMaLoaiPhong = view.findViewById(R.id.tvMaLoaiPhongsp);
            tvMaLoaiPhong.setText("STT: "+item.getId());
            tvTenLoaiPhong = view.findViewById(R.id.tvTenLoaiPhongsp);
            tvTenLoaiPhong.setText("Loại Phòng"+item.getTenLoaiPhong());
        }
        return view;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.spinner_loaiphong , null);
        }
        final LoaiPhong item = listLP.get(position);
        if (item!=null){
            tvMaLoaiPhong = view.findViewById(R.id.tvMaLoaiPhongsp);
            tvMaLoaiPhong.setText(item.getId()+" ");
            tvTenLoaiPhong = view.findViewById(R.id.tvTenLoaiPhongsp);
            tvTenLoaiPhong.setText(item.getTenLoaiPhong());
        }
        return view;
    }
}
