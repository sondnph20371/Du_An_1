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
import androidx.fragment.app.Fragment;

import com.example.du_an_alone.ChucNangChinh.HopDong_Activity;
import com.example.du_an_alone.ChucNangChinh.HopDong_Fragment;
import com.example.du_an_alone.DTO.HopDong;
import com.example.du_an_alone.R;

import java.util.ArrayList;
import java.util.List;

public class HopDong_Adapter extends ArrayAdapter<HopDong> {
            Context context;
            HopDong_Fragment fragment;
            ArrayList<HopDong> listHopDong;
            TextView tvMaPhong , tvTenPhong , tvmaHopDong ,
                    tvMaKhachThue ,tvTenKhachThue , tvNgayLam ,tvQueQuan , tvSoDienThoai , tvCCCD
                    ,tvNgayKetThuc ,maDichVu , tvTenDichVu , tvGiaDichVu , tvtienCoc , tvgiaphong ,tvtrangThaiPhong ,tvtiendien
                    ,tvtiennuoc ,tvtienvesinh ,tvtienguixe  ,tvtienwifi;
            ImageView imgXoa;
            HopDong_Activity activity;

    public HopDong_Adapter(Context context , HopDong_Fragment fragment, ArrayList<HopDong> listHopDong) {
        super(context, 0, listHopDong);
        this.context = context;
        this.fragment = fragment;
        this.listHopDong = listHopDong;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_hopdong , null);
        }

        final HopDong hopDong = listHopDong.get(position);

        if (hopDong!=null){
            tvMaPhong = view.findViewById(R.id.txtMaPhong_ItemHopDong);
            tvMaPhong.setText("Ph??ng S???: "+hopDong.getMaPhong());

            tvTenPhong = view.findViewById(R.id.txtTenPhong_ItemHopDong);
            tvTenPhong.setText("Ph??ng:  "+hopDong.getTenPhong());

            tvmaHopDong = view.findViewById(R.id.txtMahopdong_ItemHopDong);
            tvmaHopDong.setText("H???p ?????ng S???:  "+hopDong.getMaHopDong());

            tvMaKhachThue = view.findViewById(R.id.txtMakhachthue_ItemHopDong);
            tvMaKhachThue.setText("Kh??ch Thu?? S???: "+hopDong.getMaKhachThue());

            tvTenKhachThue = view.findViewById(R.id.txtTenKhachthue_ItemHopDong);
            tvTenKhachThue.setText("T??n Kh??ch Thu??: "+hopDong.getTenKhachHang());

            tvQueQuan = view.findViewById(R.id.txtQueQuan_ItemHopDong);
            tvQueQuan.setText("Qu?? Qu??n: "+hopDong.getQueQuan());

            tvSoDienThoai = view.findViewById(R.id.txtSoDienThoai_ItemHopDong);
            tvSoDienThoai.setText("S??? ??i???n Tho???i: "+hopDong.getSoDienThoai());

            tvCCCD = view.findViewById(R.id.txtCCCD_ItemHopDong);
            tvCCCD.setText("CCCD: "+hopDong.getCCCD());

            tvNgayLam = view.findViewById(R.id.txtngaylap_ItemHopDong);
            tvNgayLam.setText("Ng??y L??m:  "+hopDong.getNgayLamHopDong());

            Log.d("zzz" , hopDong.getNgayLamHopDong());

            tvNgayKetThuc = view.findViewById(R.id.txtngayhethan_ItemHopDong);
            tvNgayKetThuc.setText("Ng??y K???t Th??c:  "+hopDong.getNgayKetThuc());

            Log.d("zzz" , hopDong.getNgayKetThuc());

            maDichVu = view.findViewById(R.id.txtmadichvu_ItemHopDong);
            maDichVu.setText("D???ch V??? Ph??ng");

            tvtiendien = view.findViewById(R.id.txtdien_ItemHopDong);
            tvtiendien.setText("Ti???n ??i???n: "+hopDong.getTienDien()+" VND/Kw");

            tvtiennuoc = view.findViewById(R.id.txtnuoc_ItemHopDong);
            tvtiennuoc.setText("Ti???n N?????c: "+hopDong.getTienNuoc()+" VND/Kh???i");

            tvtienvesinh = view.findViewById(R.id.txtvesinh_ItemHopDong);
            tvtienvesinh.setText("Ti???n V??? Sinh: "+hopDong.getTienVeSinh()+" VND/Ng?????i");

            tvtienguixe = view.findViewById(R.id.txtguixe_ItemHopDong);
            tvtienguixe.setText("Ti???n G???i Xe: "+hopDong.getTienGuiXe()+" VND/C??i");

            tvtienwifi = view.findViewById(R.id.txtwifi_ItemHopDong);
            tvtienwifi.setText("Ti???n Wifi: "+hopDong.getTienWifi()+" VND/Ng?????i");

            tvgiaphong = view.findViewById(R.id.txtGiaPhong_ItemHopDong);
            tvgiaphong.setText("Gi?? Ph??ng: "+hopDong.getGiaPhong()+" VND");

            tvtienCoc = view.findViewById(R.id.txtTienCoc_ItemHopDong);
            tvtienCoc.setText("Ti???n C???c: "+hopDong.getTienCoc()+" VND");

            tvtrangThaiPhong = view.findViewById(R.id.txtTrangthai_ItemHopDong);
            if (hopDong.getTrangThaitiencoc()>0){
                tvtrangThaiPhong.setTextColor(Color.BLUE);
                tvtrangThaiPhong.setText("???? Thanh To??n");
            }else {
                tvtrangThaiPhong.setTextColor(Color.RED);
                tvtrangThaiPhong.setText("Ch??a Thanh To??n");
            }
//            imgXoa = view.findViewById(R.id.imgxoa_hopdong);
//            imgXoa.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    fragment.xoa(String.valueOf(hopDong.getMaHopDong()));
//                }
//            });
        }
        return view;
    }
}
