package com.example.du_an_alone.ChucNangChinh;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.du_an_alone.Adapter.ThanhLiAdapter;
import com.example.du_an_alone.DAO.HopDongDAO;
import com.example.du_an_alone.DAO.PhongDAO;
import com.example.du_an_alone.DTO.HoaDon;
import com.example.du_an_alone.DTO.HopDong;
import com.example.du_an_alone.R;

import java.util.ArrayList;

public class Fragment_ThanhLiPhong extends Fragment {
    ListView lvThanhLi;
    ThanhLiAdapter adapter;
    HopDongDAO hopDongDAO;
    HopDong hopDong;
    PhongDAO phongDAO;
    ArrayList<HopDong> listHopDong;
    public Fragment_ThanhLiPhong() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__thanh_li_phong, container, false);
        lvThanhLi = view.findViewById(R.id.lvThanhLi);
        hopDongDAO = new HopDongDAO(getActivity());
        listHopDong = hopDongDAO.GetALL();
        phongDAO = new PhongDAO(getActivity());
        capNhatLV();

//        lvThanhLi.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                hopDong = li
//                return false;
//            }
//        });

        lvThanhLi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                hopDong = listHopDong.get(position);
                Toast.makeText(getActivity(), hopDong.getTenPhong(), Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Thanh lí phòng "+ hopDong.getTenPhong());
                builder.setMessage("Bạn có muốn thanh lí hợp đồng phòng này ");
                builder.setNegativeButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                hopDongDAO.Delete(hopDong.getMaHopDong());
                                Toast.makeText(getActivity(), "Thanh lí hợp đồng thành công", Toast.LENGTH_SHORT).show();
                                capNhatLV();
                                phongDAO.updateTrangThai(hopDong.getMaPhong(), 0);
                                dialog.cancel();
                            }
                        }
                );

                builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                builder.show();
            }
        });


        return view;
    }

    public void capNhatLV() {
        adapter = new ThanhLiAdapter(getActivity(), this, (ArrayList<HopDong>) hopDongDAO.getAll());
        lvThanhLi.setAdapter(adapter);
    }
}