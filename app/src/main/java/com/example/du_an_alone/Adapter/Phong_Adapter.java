package com.example.du_an_alone.Adapter;

import android.content.Context;
import android.graphics.Color;
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

import com.example.du_an_alone.ChucNangChinh.HopDong_Fragment;
import com.example.du_an_alone.ChucNangChinh.Phong_Activity;
import com.example.du_an_alone.ChucNangChinh.ThemPhong_Fragment;
import com.example.du_an_alone.DAO.LoaiPhongDAO;
import com.example.du_an_alone.DTO.HopDong;
import com.example.du_an_alone.DTO.LoaiPhong;
import com.example.du_an_alone.DTO.Phong;
import com.example.du_an_alone.R;

import java.util.ArrayList;
import java.util.List;

public class Phong_Adapter extends ArrayAdapter<Phong> {
    Context context;
    ThemPhong_Fragment fragment;
    ArrayList<Phong> listP;
    ImageView ivXoa;
    LoaiPhong loaiPhong;
    TextView tvMaPhong, tvTenPhong , tvTenLoaiPhong ,  tvDienTichPhong , tvDonGiaPhong , tvtrangThaiPhong;


    //code update trạng thái

    public Phong_Adapter(@NonNull Context context , ThemPhong_Fragment fragment, ArrayList<Phong> listP) {
        super(context, 0, listP);
        this.context = context;
        this.fragment = fragment;
        this.listP = listP;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_phong, null);
        }
        loaiPhong = new LoaiPhong();
        final Phong phong = listP.get(position);
        if (phong!= null){
        tvMaPhong = view.findViewById(R.id.txtMaPhong_itemPhong);
        tvMaPhong.setText("Mã Phòng:  "+phong.getId());

        Log.d("zzzzzzMaphong" , phong.getId()+"");

        tvTenPhong = view.findViewById(R.id.txtTenPhong_itemPhong);
        tvTenPhong.setText("Tên Phòng:  "+phong.getTenPhong());

        Log.d("zzzzzztenphong" , phong.getTenPhong()+"");

        tvTenLoaiPhong = view.findViewById(R.id.txttenloaiphong_itemPhong);
        tvTenLoaiPhong.setText("Tên Loại Phòng:  "+ phong.getTenLoaiPhong());

            Log.d("zzzzzztenloaiphong" , phong.getTenLoaiPhong()+"");

        tvDienTichPhong = view.findViewById(R.id.txtDienTichPhong_itemPhong);
        tvDienTichPhong.setText("Diện Tích Phòng:  "+phong.getDienTichPhong()+"m2");

            Log.d("zzzzzzdientichphong" , phong.getDienTichPhong()+"");

        tvDonGiaPhong = view.findViewById(R.id.txtGiaPhong_itemPhong);
        tvDonGiaPhong.setText("Giá Phòng:  "+phong.getGiaPhong()+" VND");

            Log.d("zzzzzzdongia" , phong.getGiaPhong()+"");

        tvtrangThaiPhong = view.findViewById(R.id.txttrangthaiphong_itemPhong);
        if(phong.getTrangThaiTienCoc()==0) {
            tvtrangThaiPhong.setText("Đang Trống");
            tvtrangThaiPhong.setTextColor(Color.RED);
        } else {
            tvtrangThaiPhong.setText("Đã được thuê");
            tvtrangThaiPhong.setTextColor(Color.BLUE);
        }
        ivXoa = view.findViewById(R.id.imgdelete_Phong);
        ivXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.xoa(String.valueOf(phong.getId()));
            }
        });
        }
        return view;
    }
}
