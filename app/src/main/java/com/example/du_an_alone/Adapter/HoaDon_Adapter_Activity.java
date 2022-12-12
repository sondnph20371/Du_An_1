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

import com.example.du_an_alone.ChucNangChinh.Hoa_DonFragment;
import com.example.du_an_alone.ChucNangChinh.Hoa_Don_Activity;
import com.example.du_an_alone.DTO.HoaDon;
import com.example.du_an_alone.R;

import java.util.ArrayList;

public class HoaDon_Adapter_Activity extends ArrayAdapter<HoaDon> {
    Context context;
    Hoa_DonFragment fragment;
    Hoa_Don_Activity activity;
    TextView tenHopDong , maPhong ,tenPhong , maKhachThue , tenKhachThue, tienDien , tienNuoc , tienVeSinh , tienGuiXe ,tienPhong , tongTien , ngayThu ,tienWifi , trangThai;
    ArrayList<HoaDon> listHoaDon;

    public HoaDon_Adapter_Activity(Context context, Hoa_Don_Activity activity, ArrayList<HoaDon> listHoaDon) {
        super(context, 0, listHoaDon);
        this.context = context;
        this.activity = activity;
        this.listHoaDon = listHoaDon;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_hoa_don_activity, null);
        }
        final HoaDon hoaDon = listHoaDon.get(position);
        if (hoaDon!=null){
            tenHopDong = view.findViewById(R.id.txtmahoadon_item_hoadon);
            tenHopDong.setText("Hóa Đơn Thanh Toán Tiền Nhà Tháng "+hoaDon.getTenHoaDon());
            Log.d("zzzzzzzzzzzzztenhoadon", hoaDon.getTenHoaDon()+"");
            maPhong = view.findViewById(R.id.txtmaphong_item_hoadon);
            maPhong.setText("Mã Phòng: "+hoaDon.getMaPhong());
            Log.d("zzzzzzzzzzzzzmaphong", hoaDon.getMaPhong()+"");
            tenPhong = view.findViewById(R.id.txttenphong_item_hoadon);
            tenPhong.setText("Phòng: "+hoaDon.getTenPhong());
            Log.d("zzzzzzzzzzzzztenphong", hoaDon.getTenPhong()+"");
            maKhachThue = view.findViewById(R.id.txtmakhachhang_item_hoadon);
            maKhachThue.setText("Mã Khách Thuê: "+hoaDon.getMaKhachThue());
            Log.d("zzzzzzzzzzzzzmakhachthue", hoaDon.getMaKhachThue()+"");
            tenKhachThue = view.findViewById(R.id.txttenkhachhang_item_hoadon);
            tenKhachThue.setText("Tên Khách Thuê: "+hoaDon.getTenKhachThue());
            Log.d("zzzzzzzzzzzzztenkhachthue", hoaDon.getTenKhachThue()+"");
            tienDien = view.findViewById(R.id.txttiendien_itemhoadon);
            tienDien.setText("Tiền Điện: "+hoaDon.getSoDien()+" VND");
            Log.d("zzzzzzzzzzzzztiendien", hoaDon.getSoDien()+"");
            tienNuoc = view.findViewById(R.id.txttiennuoc_itemhoadon);
            tienNuoc.setText("Giá Vệ Sinh: "+hoaDon.getSoNuoc()+" VND");
            Log.d("zzzzzzzzzzzzztiennuoc", hoaDon.getSoNuoc()+"");
            tienVeSinh = view.findViewById(R.id.txttienvesinh_itemhoadon);
            tienVeSinh.setText("Tiền Vệ Sinh: "+hoaDon.getVeSinh()+" VND");
            Log.d("zzzzzzzzzzzzztienvesinh", hoaDon.getVeSinh()+"");
            tienGuiXe = view.findViewById(R.id.txttienguixe_itemhoadon);
            tienGuiXe.setText("Tiền Gữi Xe: "+hoaDon.getGuiXe()+" VND");
            Log.d("zzzzzzzzzzzzzguixe", hoaDon.getGuiXe()+"");
            tienWifi = view.findViewById(R.id.txttienwifi_itemhoadon);
            tienWifi.setText("Tiền WiFi: "+hoaDon.getWifi()+" VND");
            Log.d("zzzzzzzzzzzzztienwifi", hoaDon.getWifi()+"");
            tienPhong = view.findViewById(R.id.txttienphong_itemhoadon);
            tienPhong.setText("Tiền Phòng: "+hoaDon.getTienPhong()+" VND");
            Log.d("zzzzzzzzzzzzztienphong", hoaDon.getTienPhong()+"");
            ngayThu = view.findViewById(R.id.txtngaythu_itemhoadon);
            ngayThu.setText("Ngày Thu Tiền: "+hoaDon.getNgayThu());
            Log.d("zzzzzzzzzzzzzngaythu", hoaDon.getNgayThu()+"");
            tongTien = view.findViewById(R.id.txttongtien_itemhoadon);
            tongTien.setText("Tổng Tiền: "+hoaDon.getTongTienThanhToan()+" VND");
            Log.d("zzzzzzzzzzzzztongtien", hoaDon.getTongTienThanhToan()+"");
            trangThai = view.findViewById(R.id.txttrangthaithanhtoan_itemhoadon);
            trangThai.setText(" "+hoaDon.getTrangThai());
            Log.d("zzzzzzzzzzzzztrangthai", hoaDon.getTrangThai());
        }
        return view;
    }
}
