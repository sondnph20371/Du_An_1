package com.example.du_an_alone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.du_an_alone.ChucNangChinh.Fragment_ThanhLiPhong;
import com.example.du_an_alone.ChucNangChinh.Hoa_DonFragment;
import com.example.du_an_alone.DTO.HoaDon;
import com.example.du_an_alone.DTO.HopDong;
import com.example.du_an_alone.R;

import java.util.ArrayList;

public class ThanhLiAdapter extends ArrayAdapter<HopDong> {
    private Context context;
    private Fragment_ThanhLiPhong fragment;
    private ArrayList<HopDong> list;
    TextView tenPhong, tenKT;


    public ThanhLiAdapter(Context context , Fragment_ThanhLiPhong fragment, ArrayList<HopDong> list) {
        super(context, 0, list);
        this.context = context;
        this.fragment = fragment;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_thanhli, null);
        }

        final HopDong hopDong = list.get(position);
        if(hopDong!=null) {
            tenPhong = view.findViewById(R.id.itemThanhLi_tenP);
            tenPhong.setText("Phòng: "+ hopDong.getTenPhong());
            tenKT = view.findViewById(R.id.itemThanhli_tenKT);
            tenKT.setText("Tên Khách Thuê: \n"+ hopDong.getTenKhachHang());
        }


        return view;
    }
}
