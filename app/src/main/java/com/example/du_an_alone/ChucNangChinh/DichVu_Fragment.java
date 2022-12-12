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
import android.widget.TextView;
import android.widget.Toast;

import com.example.du_an_alone.Adapter.DichVu_Adapter;
import com.example.du_an_alone.DAO.DichVuDAO;
import com.example.du_an_alone.DTO.DichVu;
import com.example.du_an_alone.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;


public class DichVu_Fragment extends Fragment {
    ListView listviewDichVu;
    EditText  tvTienDien , tvTienNuoc , tvTienveSinh , tvTienGuiXe  , tvTienWifi;
    TextView edtMaDichVu;
    ImageView fab;
    DichVu_Adapter adapter;
    DichVu dichVu;
    ArrayList<DichVu> listDichVu;
    DichVuDAO dao;
    Button btnAdd , btnHuy;
    TextInputLayout inputDien, inputNuoc, inputVS, inputXe, inputWF;
    public DichVu_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dich_vu_, container, false);

        listviewDichVu = view.findViewById(R.id.lvDichVuFM);
        fab = view.findViewById(R.id.fab_DichVuFM);
        dao = new DichVuDAO(getActivity());
        capNhap();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getActivity() , 0);
            }
        });

        listviewDichVu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                dichVu = listDichVu.get(i);
                openDialog(getActivity() , 1);
                return false;
            }
        });
        return view;
    }

    @SuppressLint("MissingInflatedId")
    public void openDialog(final Context context, final int type) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_dichvu, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        edtMaDichVu = view.findViewById(R.id.edtmadichvu_DichVu);
        tvTienDien = view.findViewById(R.id.edttiendien_DichVu);
        tvTienNuoc = view.findViewById(R.id.edttiennuoc_DichVu);
        tvTienveSinh = view.findViewById(R.id.edtvesinh_DichVu);
        tvTienGuiXe = view.findViewById(R.id.edtguixe_DichVu);
        tvTienWifi = view.findViewById(R.id.edtgiadichvu_DichVu);
        btnAdd = view.findViewById(R.id.btnAddichVu_DialogDichVu);
        btnHuy = view.findViewById(R.id.btnHuyichVu_DialogDichVu);

        inputDien = view.findViewById(R.id.dialogDV_inputDien);
        inputNuoc = view.findViewById(R.id.dialogDV_inputNuoc);
        inputVS = view.findViewById(R.id.dialogDV_inputVS);
        inputXe = view.findViewById(R.id.dialogDV_inputXe);
        inputWF = view.findViewById(R.id.dialogDV_inputWF);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        edtMaDichVu.setEnabled(false);
        if (type!=0){
            edtMaDichVu.setText(String.valueOf(dichVu.getMaDichVu()));
            tvTienDien.setText(String.valueOf(dichVu.getTienDien()));
            tvTienNuoc.setText(String.valueOf(dichVu.getTienNuoc()));
            tvTienveSinh.setText(String.valueOf(dichVu.getTienVeSinh()));
            tvTienGuiXe.setText(String.valueOf(dichVu.getTienGuiXe()));
            tvTienWifi.setText(String.valueOf(dichVu.getTienWifi()));
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()>0) {
                    try {
                        dichVu = new DichVu();
                        dichVu.setTienDien(Integer.parseInt(tvTienDien.getText().toString()));
                        dichVu.setTienNuoc(Integer.parseInt(tvTienNuoc.getText().toString()));
                        dichVu.setTienVeSinh(Integer.parseInt(tvTienveSinh.getText().toString()));
                        dichVu.setTienGuiXe(Integer.parseInt(tvTienGuiXe.getText().toString()));
                        dichVu.setTienWifi(Integer.parseInt(tvTienWifi.getText().toString()));

                        if (type==0){
                            if (dao.Insert(dichVu)){
                                Toast.makeText(getActivity(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                                setData();
                                fab.setVisibility(View.INVISIBLE);
                            }else {
                                Toast.makeText(getActivity(), "Thêm Thất Bại", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            dichVu.setMaDichVu(Integer.parseInt(edtMaDichVu.getText().toString()));
                            if (dao.Updata(dichVu)){
                                Toast.makeText(context, "Sữa Thành Công", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(context, "Sữa Thất Bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        capNhap();
                        alertDialog.dismiss();

                    }catch (Exception ex){
                        Toast.makeText(getActivity(), "Nhập Đúng Giá", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
    public void setData(){
        tvTienveSinh.setText("");
        tvTienGuiXe.setText("");
        tvTienWifi.setText("");
        tvTienNuoc.setText("");
        tvTienDien.setText("");
    }
    public void capNhap(){
        listDichVu = (ArrayList<DichVu>) dao.SelectAll();
        adapter = new DichVu_Adapter(getActivity() , this , listDichVu);
        listviewDichVu.setAdapter(adapter);
    }
    public int validate(){
        int check =1;
        if (tvTienDien.getText().length()==0){
            inputDien.setError("Nhập tiền điện");
            check = -1;
        } else {
            inputDien.setError(null);
        }

        if (tvTienNuoc.getText().length()==0) {
            inputNuoc.setError("Nhập tiền nước");
            check=-1;
        } else {
            inputNuoc.setError(null);
        }

        if (tvTienWifi.getText().length()==0) {
            inputWF.setError("Nhập tiền mạng");
            check=-1;
        } else {
            inputWF.setError(null);
        }

        if(tvTienveSinh.getText().length()==0) {
            inputVS.setError("Nhập phí vệ sinh");
            check=-1;
        } else {
            inputVS.setError(null);
        }

        if(tvTienGuiXe.getText().length()==0) {
            inputXe.setError("Nhập tiền gửi xe");
            check=-1;
        } else {
            inputXe.setError(null);
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
                        fab.setVisibility(View.VISIBLE);
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