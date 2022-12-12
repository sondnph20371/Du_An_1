package com.example.du_an_alone.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.du_an_alone.ChucNangChinh.DichVuCT_Fragment;
import com.example.du_an_alone.ChucNangChinh.DichVu_Activity;
import com.example.du_an_alone.ChucNangChinh.DichVu_Fragment;
import com.example.du_an_alone.DTO.DichVu;
import com.example.du_an_alone.DTO.DichVuCT;
import com.example.du_an_alone.R;

import java.util.ArrayList;

public class DichVuCT_Adapter extends ArrayAdapter<DichVuCT> {
    Context context;
    ArrayList<DichVuCT> listDVCT;
    TextView  tvMaDichVu , tvTenDichVu , tvGiaDichVu , tvGhiChu;
    DichVuCT_Fragment fragment;
    Button btnXoa;
    public DichVuCT_Adapter(Context context, DichVuCT_Fragment fragment, ArrayList<DichVuCT> listDVCT) {
        super(context, 0, listDVCT);
        this.context = context;
        this.listDVCT = listDVCT;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_dichvuct, null);
        }

        final DichVuCT dichVu = listDVCT.get(position);
        if (dichVu!=null){
            tvMaDichVu = view.findViewById(R.id.txtMadichvu_itemDichVuCT);
            tvMaDichVu.setText("Mã Dịch Vụ: "+dichVu.getMaDichVuCt());

            tvTenDichVu = view.findViewById(R.id.txttendichvu_itemDichVuCT);
            tvTenDichVu.setText("Tên Dịch Vụ: "+dichVu.getTenDichVu());

            tvGiaDichVu = view.findViewById(R.id.txtgiadichvu_itemDichVuCT);
            tvGiaDichVu.setText("Giá Tiền Nước: "+dichVu.getGiaDichVu());

            tvGhiChu = view.findViewById(R.id.txtghichu_itemDichVuCT);
            tvGhiChu.setText("Ghi Chú: "+dichVu.getGhiChu());
            btnXoa = view.findViewById(R.id.btnxoadichvu);
            btnXoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragment.xoa(String.valueOf(dichVu.getMaDichVuCt()));
                }
            });
        }
        return view;
    }

}
