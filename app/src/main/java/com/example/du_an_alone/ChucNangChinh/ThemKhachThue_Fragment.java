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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.du_an_alone.Adapter.KhachThue_Adapter;
import com.example.du_an_alone.DAO.KhachThueDAO;
import com.example.du_an_alone.DTO.KhachThue;
import com.example.du_an_alone.R;

import java.util.ArrayList;
import java.util.List;


public class ThemKhachThue_Fragment extends Fragment {

    List<KhachThue> listKhachThue;

    KhachThue khachThue;
    Button btnAddKhachHang , btnHuyKhachHang;
    int position;
    EditText txtMaKhachThue , txtTenKhachThue , txtGioiTinhKhachThue ,txtSoDienThoai , txtNgaySinhKhachThue, txtQueQuanKhachThue , txtCCCD, txtNgheNghiepKhachThue ;
    KhachThueDAO dao;
    ImageView fab;
    ListView listviewKhachThue;
    KhachThue_Adapter adapter;
    public ThemKhachThue_Fragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_them_khach_thue_, container, false);
        listviewKhachThue = view.findViewById(R.id.lvKhachThuefm);
        fab = view.findViewById(R.id.fab_KhachHangfm);
        dao = new KhachThueDAO(getActivity());
        capNhatLV();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            openDialog(getActivity() , 0);
            }
        });
        listviewKhachThue.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                khachThue = listKhachThue.get(position);
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
        View view = inflater.inflate(R.layout.dialog_khachthue, null);
        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

        txtMaKhachThue =view.findViewById(R.id.edtmakhachthue_dialogKhachthue);
        txtTenKhachThue =view.findViewById(R.id.edttenkhachthue_dialogKhachthue);
        txtGioiTinhKhachThue =view.findViewById(R.id.edtgioitinhkhachthue_dialogKhachthue);
        txtNgaySinhKhachThue =view.findViewById(R.id.edtngaysinhkhachthue_dialogKhachthue);
        txtQueQuanKhachThue =view.findViewById(R.id.edtquequankhachthue_dialogKhachthue);
        txtSoDienThoai = view.findViewById(R.id.edtsodienthoaikhachthue_dialogKhachthue);
        txtCCCD =view.findViewById(R.id.edtCCCDkhachthue_dialogKhachthue);
        txtNgheNghiepKhachThue =view.findViewById(R.id.edtnghenghiepkhachthue_dialogKhachthue);
        dao = new KhachThueDAO(getActivity());
        btnAddKhachHang = view.findViewById(R.id.btnthemkhachthue_btnAdd);
        btnHuyKhachHang = view.findViewById(R.id.btnhuykhachthue_btnHuy);
        //kiểm tra type = 0 hay 1
        if (type!=0){
            txtMaKhachThue.setText(String.valueOf(khachThue.getMaKhachThue()));
            txtTenKhachThue.setText(khachThue.getTen());
            txtGioiTinhKhachThue.setText(khachThue.getGioiTinh());
            txtNgaySinhKhachThue.setText(khachThue.getNgaySinh());
            txtQueQuanKhachThue.setText(khachThue.getQueQuan());
            txtCCCD.setText(String.valueOf(khachThue.getCCCD()));
            txtNgheNghiepKhachThue.setText(khachThue.getNgheNghiep());
            txtSoDienThoai.setText(String.valueOf(khachThue.getSoDienThoai()));
            btnAddKhachHang.setText("Cập Nhập");
        }

        btnHuyKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        btnAddKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate() > 0) {
                    try {
                        KhachThue khachThue1 = new KhachThue();
                        khachThue1.setTen(txtTenKhachThue.getText().toString());
                        khachThue1.setGioiTinh(txtGioiTinhKhachThue.getText().toString());
                        khachThue1.setNgaySinh(txtNgaySinhKhachThue.getText().toString());
                        khachThue1.setCCCD(Integer.parseInt(txtCCCD.getText().toString()));
                        khachThue1.setQueQuan(txtQueQuanKhachThue.getText().toString());
                        khachThue1.setNgheNghiep(txtNgheNghiepKhachThue.getText().toString());
                        khachThue1.setSoDienThoai(Integer.parseInt(txtSoDienThoai.getText().toString()));

                        if (type == 0) {
                            if (dao.Insert(khachThue1)) {
                                Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getActivity(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            khachThue1.setMaKhachThue(Integer.parseInt(txtMaKhachThue.getText().toString()));
                            if (dao.Updata(khachThue1)) {
                                Toast.makeText(getActivity(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getActivity(), "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        capNhatLV();
                        alertDialog.dismiss();

                    } catch (Exception ex) {
                        Toast.makeText(context, "Nhập Đúng!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public int validate() {
        int check = 1;
        if (txtTenKhachThue.getText().length()==0) {
           txtTenKhachThue.setError("Vui lòng nhập tên");
            check = -1;
        } else {
            txtTenKhachThue.setError(null);
        }

        if (txtGioiTinhKhachThue.getText().length()==0) {
            txtGioiTinhKhachThue.setError("Vui lòng nhập giới tính");
            check = -1;
        } else {
            txtGioiTinhKhachThue.setError(null);
        }

        if (txtNgaySinhKhachThue.getText().length()==0) {
            txtNgaySinhKhachThue.setError("Vui lòng nhập ngày sinh");
            check = -1;
        } else {
            txtNgaySinhKhachThue.setError(null);
        }

        if (txtCCCD.getText().length()==0) {
            txtCCCD.setError("Vui lòng nhập CCCD");
            check = -1;
        } else {
            txtCCCD.setError(null);
        }

        if (txtQueQuanKhachThue.getText().length()==0) {
            txtQueQuanKhachThue.setError("Vui lòng nhập quê quán");
            check = -1;
        } else {
            txtQueQuanKhachThue.setError(null);
        }
        if (txtSoDienThoai.getText().length()==0) {
            txtSoDienThoai.setError("Vui lòng nhập số điện thoại");
            check = -1;
        } else {
            txtSoDienThoai.setError(null);
        }

        if (txtNgheNghiepKhachThue.getText().length()==0) {
            txtNgheNghiepKhachThue.setError("Vui lòng nhập nghề nghiệp");
            check = -1;
        } else {
            txtNgheNghiepKhachThue.setError(null);
        }

        return check;
    }

    public void capNhatLV() {
        listKhachThue = (List<KhachThue>) dao.GetALL();
        adapter = new KhachThue_Adapter(getActivity(), this, (ArrayList<KhachThue>) listKhachThue);
        listviewKhachThue.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void xoa(final String Id){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Delete");
        builder.setMessage("Bạn có muốn xóa không? ");
        builder.setCancelable(true);
        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dao.Delete(Integer.parseInt(Id));
                        capNhatLV();
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