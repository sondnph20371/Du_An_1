package com.example.du_an_alone.ChucNangChinh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.du_an_alone.Function_Login.DangNhap;
import com.example.du_an_alone.R;


public class Home_Fragment extends Fragment {
        ImageButton imgPhong, imgLoaiPhong , imgDichVu , imgHoaDon , imgKhachThue , imghopdong;
        Intent intent;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_,container,false);
        imgLoaiPhong = view.findViewById(R.id.imgloaiphong);
        imgPhong = view.findViewById(R.id.imgphong);
        imgDichVu = view.findViewById(R.id.imgdichvu);
        imgKhachThue =view.findViewById(R.id.imgthongtinkhacthue);
        imghopdong =view.findViewById(R.id.imghopdong);
        imgHoaDon = view.findViewById(R.id.imghoadon);
        imgLoaiPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity() , LoaiPhong_Activity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Loại Phòng", Toast.LENGTH_SHORT).show();
            }
        });
        imgPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity() , Phong_Activity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Phòng", Toast.LENGTH_SHORT).show();
            }
        });
        imgDichVu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity() , DichVu_Activity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Dịch Vụ", Toast.LENGTH_SHORT).show();
            }
        });
        imgKhachThue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity() , KhachThue_Activity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Khách Thuê", Toast.LENGTH_SHORT).show();
            }
        });
        imgHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity() , Hoa_Don_Activity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Hóa Đơn", Toast.LENGTH_SHORT).show();
            }
        });
        imghopdong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity() , HopDong_Activity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Hóa Đơn", Toast.LENGTH_SHORT).show();
            }
        });
      return view;
    }
}