package com.example.du_an_alone.ChucNangChinh;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.du_an_alone.Adapter.Phong_Adapter;
import com.example.du_an_alone.Adapter.Spinner_LoaiPhong_Adapter;
import com.example.du_an_alone.DAO.LoaiPhongDAO;
import com.example.du_an_alone.DAO.PhongDAO;
import com.example.du_an_alone.DTO.HopDong;
import com.example.du_an_alone.DTO.LoaiPhong;
import com.example.du_an_alone.DTO.Phong;
import com.example.du_an_alone.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;


public class ThemPhong_Fragment extends Fragment {

    ListView lvPhong;
    List<Phong> listPhong;
    PhongDAO phongDAO;
    Phong_Adapter adapter;
    Phong phong;
    EditText txtTenPhong, txtDienTichPhong, txtDonGiaPhong, txtMaPhong;
    TextInputLayout inputTen, inputDT, inputGia;
    Button btnAddphong , btnHuyphong;
    ImageView fab;
    Spinner spinner;
    Spinner_LoaiPhong_Adapter loaiPhongSpinnerAdapter;
    ArrayList<LoaiPhong> listLoaiPhong;
    LoaiPhongDAO loaiPhongDAO;
    LoaiPhong loaiPhong;
    String tenLoaiPhong ;
    int position , trangthaiPhong;
    ArrayList<HopDong> listHD;
    public ThemPhong_Fragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_them_phong_, container, false);
        lvPhong = view.findViewById(R.id.lvPhongfm);
        fab = view.findViewById(R.id.fab_Phongfm);
        phongDAO = new PhongDAO(getActivity());
        capNhatLV();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenDiaLog(getActivity(), 0);
            }
        });

        lvPhong.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                phong = listPhong.get(i);
                OpenDiaLog(getActivity() , 1);
                return false;
            }
        });
        return view;
    }
    @SuppressLint("MissingInflatedId")
    public void OpenDiaLog(final Context context, final int type){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_phong, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
        txtTenPhong = view.findViewById(R.id.edttenphong_Phong);
        txtDienTichPhong = view.findViewById(R.id.edtdientichphong_Phong);
        txtDonGiaPhong = view.findViewById(R.id.edtdongiaphong_Phong);
        txtMaPhong = view.findViewById(R.id.edtmaphong_Phong);
        btnAddphong = view.findViewById(R.id.btnThemPhong_Phong);
        btnHuyphong = view.findViewById(R.id.btnHuyPhong_Phong);
        spinner = view.findViewById(R.id.spinner_Phong);
        inputTen = view.findViewById(R.id.dialogPhong_InputTen);
        inputDT = view.findViewById(R.id.dialogPhong_InputDT);
        inputGia = view.findViewById(R.id.dialogPhong_InputGia);
        listLoaiPhong = new ArrayList<LoaiPhong>();
        loaiPhongDAO = new LoaiPhongDAO(getActivity());
        listLoaiPhong =(ArrayList<LoaiPhong>) loaiPhongDAO.getAll();
        loaiPhongSpinnerAdapter = new Spinner_LoaiPhong_Adapter(getActivity(),listLoaiPhong);
        spinner.setAdapter(loaiPhongSpinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tenLoaiPhong = listLoaiPhong.get(position).getTenLoaiPhong();
                Toast.makeText(getContext(), "Chọn "+listLoaiPhong.get(position).getTenLoaiPhong(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        txtMaPhong.setEnabled(false);
        if (type!=0){
            txtMaPhong.setText(String.valueOf(phong.getId()));
            txtTenPhong.setText(phong.getTenPhong());
            txtDienTichPhong.setText(String.valueOf(phong.getDienTichPhong()));
            txtDonGiaPhong.setText(String.valueOf(phong.getGiaPhong()));
            for (int i = 0 ; i < listLoaiPhong.size();i++){
                if (phong.getTenLoaiPhong()==listLoaiPhong.get(i).getTenLoaiPhong()){
                    position = i;
                }
                Log.i("demo" , "posPhong"+position);
                spinner.setSelection(position);
            }



        }
        btnHuyphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        btnAddphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()>0) {
                    try {
                        Phong  phong1 = new Phong();
                        phong1.setTenPhong(txtTenPhong.getText().toString());
                        phong1.setDienTichPhong(Integer.parseInt(txtDienTichPhong.getText().toString()));
                        phong1.setGiaPhong(Integer.parseInt(txtDonGiaPhong.getText().toString()));
                        phong1.setTenLoaiPhong(tenLoaiPhong);
                        phong1.setTrangThaiTienCoc(trangthaiPhong);
                        if (type == 0) {
                            if (phongDAO.Insert(phong1)) {
                                Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
                                alertDialog.dismiss();
                                setData();
                            } else {
                                Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            phong1.setId(Integer.parseInt(txtMaPhong.getText().toString()));
                            if (phongDAO.Updata(phong1)) {
                                Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                                alertDialog.dismiss();
                            } else {
                                Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        capNhatLV();
                    }catch (Exception ex){
                    Toast.makeText(getActivity(), "Chọn loại phòng", Toast.LENGTH_SHORT).show();
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    public int validate() {
        int check = 1;
        if (txtTenPhong.getText().length() == 0 ) {
           inputTen.setError("Vui lòng nhập tên phòng");
          check = -1;
        }  else {
            inputTen.setError(null);
        }
        if(txtDienTichPhong.getText().length()==0) {
            inputDT.setError("Vui lòng nhập diện tích phòng");
            check = -1;
        }  else {
            inputDT.setError(null);
        }
        if(txtDonGiaPhong.getText().length()==0) {
            inputGia.setError("Vui lòng nhập giá phòng");
            check = -1;
        } else {
            inputGia.setError(null);
        }
        return check;
    }
    public void setData(){
        txtTenPhong.setText("");
        txtDienTichPhong.setText("");
        txtDonGiaPhong.setText("");
    }
    public void capNhatLV() {
        listPhong = (ArrayList<Phong>) phongDAO.GetAll();
        adapter = new Phong_Adapter(getContext(), this, (ArrayList<Phong>) listPhong);
        lvPhong.setAdapter(adapter);
    }
    public void xoa(final String Id){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle("Xóa Phòng");
        builder.setMessage("Bạn có muốn xóa phòng này không? ");
        builder.setCancelable(true);
        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        phongDAO.Delete(Integer.parseInt(Id));
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