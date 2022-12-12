package com.example.du_an_alone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.du_an_alone.ChucNangChinh.LoaiPhong_Activity;
import com.example.du_an_alone.ChucNangChinh.ThemLoaiPhong_Fragment;
import com.example.du_an_alone.DTO.LoaiPhong;
import com.example.du_an_alone.R;

import java.util.ArrayList;

public class LoaiPhong_Adapter extends ArrayAdapter<LoaiPhong> {
    Context context;
    ArrayList<LoaiPhong> listLP;
    TextView tvMaLoaiPhong , tvTenLoaiPhong;
    ThemLoaiPhong_Fragment fragment;
    public LoaiPhong_Adapter( Context context , ThemLoaiPhong_Fragment fragment, ArrayList<LoaiPhong> listLP ) {
        super(context, 0, listLP);
        this.context = context;
        this.listLP = listLP;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_loaiphong, null);
        }
        final LoaiPhong loaiPhong =listLP.get(position);
        if (loaiPhong!= null){
            tvMaLoaiPhong = view.findViewById(R.id.txtmaloaiphong_itemLoaiPhong);
            tvMaLoaiPhong.setText("Mã Loại Phòng: "+loaiPhong.getId());

            tvTenLoaiPhong = view.findViewById(R.id.txttenloaiphong_itemLoaiPhong);
            tvTenLoaiPhong.setText("Loại Phòng: "+loaiPhong.getTenLoaiPhong());

            ImageView imgXoa = view.findViewById(R.id.imgxoaloaiphong);
            imgXoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragment.xoa(String.valueOf(loaiPhong.getId()));
                }
            });
        }
        return view;
    }

}
