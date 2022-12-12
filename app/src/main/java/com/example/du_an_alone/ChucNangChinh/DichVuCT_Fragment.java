package com.example.du_an_alone.ChucNangChinh;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.du_an_alone.Adapter.DichVuCT_Adapter;
import com.example.du_an_alone.Adapter.DichVu_Adapter;
import com.example.du_an_alone.DAO.DichVuCTDAO;
import com.example.du_an_alone.DAO.DichVuDAO;
import com.example.du_an_alone.DTO.DichVu;
import com.example.du_an_alone.DTO.DichVuCT;
import com.example.du_an_alone.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class DichVuCT_Fragment extends Fragment {

    ListView listviewDichVuCT;
    EditText tvTenDichVu, tvGiaDichVu, tvGhiChu;
    TextView tvMaDichVu;
    FloatingActionButton fab;
    DichVuCT_Adapter adapter;
    DichVuCT dichVuCT;
    ArrayList<DichVuCT> listDichVuCT;
    DichVuCTDAO dao;
    Button btnAdd, btnHuy;

    public DichVuCT_Fragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dich_vu_c_t_, container, false);

        listviewDichVuCT = view.findViewById(R.id.lvDichVuCTFM);
        fab = view.findViewById(R.id.fab_DichVuCTFM);
        dao = new DichVuCTDAO(getActivity());
        capNhap();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getActivity(), 0);
            }
        });

        listviewDichVuCT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                dichVuCT = listDichVuCT.get(i);
                openDialog(getActivity(), 1);
                return false;
            }
        });
        return view;
    }

    @SuppressLint("MissingInflatedId")
    public void openDialog(final Context context, final int type) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_dichvuct, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        tvMaDichVu = view.findViewById(R.id.edtmadichvu_DichVuCT);
        tvTenDichVu = view.findViewById(R.id.edttendichvu_DichVuCT);
        tvGiaDichVu = view.findViewById(R.id.edtgiadichvu_DichVuCT);
        tvGhiChu = view.findViewById(R.id.edtghichu_DichVuCT);
        btnAdd = view.findViewById(R.id.btnAddichVu_DialogDichVuCT);
        btnHuy = view.findViewById(R.id.btnHuyichVu_DialogDichVuCT);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        tvMaDichVu.setEnabled(false);
        if (type!=0){
            tvMaDichVu.setText(String.valueOf(dichVuCT.getMaDichVuCt()));
            tvTenDichVu.setText(String.valueOf(dichVuCT.getTenDichVu()));
            tvGiaDichVu.setText(String.valueOf(dichVuCT.getGiaDichVu()));
            tvGhiChu.setText(String.valueOf(dichVuCT.getGhiChu()));
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dichVuCT = new DichVuCT();
                    dichVuCT.setTenDichVu(tvTenDichVu.getText().toString());
                    dichVuCT.setGiaDichVu(Integer.parseInt(tvGiaDichVu.getText().toString()));
                    dichVuCT.setGhiChu(tvGhiChu.getText().toString());
                    if (validate()>0){
                        if (type==0){
                            if (dao.Insert(dichVuCT)){
                                Toast.makeText(getActivity(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                                setData();
                            }else {
                                Toast.makeText(getActivity(), "Thêm Thất Bại", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            dichVuCT.setMaDichVuCt(Integer.parseInt(tvMaDichVu.getText().toString()));
                            if (dao.Updata(dichVuCT)){
                                Toast.makeText(context, "Sữa Thành Công", Toast.LENGTH_SHORT).show();
                                setData();
                            }else {
                                Toast.makeText(context, "Sữa Thất Bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        capNhap();
                    }
                }catch (Exception ex){
                    Toast.makeText(getActivity(), "Nhập Đúng Giá", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void setData(){
        tvTenDichVu.setText("");
        tvGhiChu.setText("");
        tvGiaDichVu.setText("");
    }
    public void capNhap(){
        listDichVuCT = (ArrayList<DichVuCT>) dao.SelectAll();
        adapter = new DichVuCT_Adapter(getActivity() , this , listDichVuCT);
        listviewDichVuCT.setAdapter(adapter);
    }
    public int validate(){
        int check =1;
        if (tvTenDichVu.getText().length()==0 || tvGiaDichVu.getText().length()==0){
            Toast.makeText(getActivity(), "Vui lòng nhập đủ", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
    public void xoa(final String Id){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Delete");
        builder.setMessage("Bạn có muốn xóa không? ");
        builder.setCancelable(true);
        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dao.delete(Integer.parseInt(Id));
                        capNhap();
                        dialog.cancel();
                    }
                }
        );
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        builder.show();
    }
}