package com.example.du_an_alone.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.du_an_alone.ChucNangChinh.KhachThue_Activity;
import com.example.du_an_alone.ChucNangChinh.ThemKhachThue_Fragment;
import com.example.du_an_alone.DTO.KhachThue;
import com.example.du_an_alone.DTO.Phong;
import com.example.du_an_alone.R;

import java.util.ArrayList;
import java.util.List;

public class KhachThue_Adapter extends ArrayAdapter<KhachThue> {
    private Context context;
    List<KhachThue> listkhachthue;
    ThemKhachThue_Fragment fragment;
    KhachThue_Activity activity;
    Phong phong;
    ImageView imgXoa;
    List<KhachThue> listPhong;
    TextView  tvMaPhong ,  tvTenPhong , tvMaKhachThue , tvHoKhachThue , tvTenKhachThue , tvGioiTinhKhachThue , tvSoDienThoai,
    tvNgaySinhKhachThue, tvQueQuanKhachThue , tvCCCD, tvNgheNghiepKhachThue ;

    public KhachThue_Adapter(Context context , ThemKhachThue_Fragment fragment, ArrayList<KhachThue> listkhachthue ) {
        super(context, 0, listkhachthue);
        this.context = context;
        this.listkhachthue = listkhachthue;
        this.fragment = fragment;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_khachthue, null);
        }
        phong = new Phong();
        final KhachThue khachThue = listkhachthue.get(position);
        if (khachThue != null){


            tvMaKhachThue = view.findViewById(R.id.txtMaKhachThue_itemKhachThue);
            tvMaKhachThue.setText("Mã Khách Thuê: "+khachThue.getMaKhachThue());

            Log.d("zzzzzzzzzzzzzzzzzz" , String.valueOf(khachThue.getMaKhachThue()));

            tvTenKhachThue = view.findViewById(R.id.txttenkhachthue_itemKhachThue);
            tvTenKhachThue.setText(""+khachThue.getTen());

            Log.d("zzzzzzzzzzzzzzzzzz" , khachThue.getTen());

            tvGioiTinhKhachThue = view.findViewById(R.id.txtGioiTinh_itemKhachThue);
            tvGioiTinhKhachThue.setText("Giới Tính: "+khachThue.getGioiTinh());

            Log.d("zzzzzzzzzzzzzzzzzz" , khachThue.getGioiTinh());

            tvNgaySinhKhachThue = view.findViewById(R.id.txtNgaySinh_itemKhachThue);
            tvNgaySinhKhachThue.setText("Ngày Sinh: "+khachThue.getNgaySinh());

            Log.d("zzzzzzzzzzzzzzzzzz" , khachThue.getNgaySinh());

            tvQueQuanKhachThue = view.findViewById(R.id.txtQueQuan_itemKhachThue);
            tvQueQuanKhachThue.setText("Quê Quán: "+khachThue.getQueQuan());

            Log.d("zzzzzzzzzzzzzzzzzz" , khachThue.getQueQuan());

            tvCCCD = view.findViewById(R.id.txtCCCD_itemKhachThue);
            tvCCCD.setText("CCCD: "+khachThue.getCCCD());

            Log.d("zzzzzzzzzzzzzzzzzz" , String.valueOf(khachThue.getCCCD()));

            tvSoDienThoai = view.findViewById(R.id.txtSodienThoai_itemKhachThue);
            tvSoDienThoai.setText("Số Điện Thoại: "+khachThue.getSoDienThoai());

            Log.d("zzzzzzzzzzzzzzzzzz" , String.valueOf(khachThue.getCCCD()));

            tvNgheNghiepKhachThue = view.findViewById(R.id.txtNgheNghiep_itemKhachThue);
            tvNgheNghiepKhachThue.setText("Nghề Nghiệp: "+khachThue.getNgheNghiep());

            Log.d("zzzzzzzzzzzzzzzzzz" , khachThue.getNgheNghiep());
            imgXoa = view.findViewById(R.id.imgdelete_khachthue);
            imgXoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragment.xoa(String.valueOf(khachThue.getMaKhachThue()));
                }
            });

        }
        return view;
    }
}
