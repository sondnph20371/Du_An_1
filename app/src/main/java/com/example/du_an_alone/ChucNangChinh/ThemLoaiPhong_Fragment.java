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
import android.widget.TextView;
import android.widget.Toast;

import com.example.du_an_alone.Adapter.LoaiPhong_Adapter;
import com.example.du_an_alone.DAO.LoaiPhongDAO;
import com.example.du_an_alone.DTO.LoaiPhong;
import com.example.du_an_alone.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;


public class ThemLoaiPhong_Fragment extends Fragment {
    ListView lvLoaiPhong;
    EditText edtTenLoaiPhong ;
    TextView edtMaLoaiPhong;
    ImageView fab;
    TextInputLayout inputLP;
    LoaiPhong_Adapter adapter;
    LoaiPhong loaiPhong;
    ArrayList<LoaiPhong> listLP;
    LoaiPhongDAO dao;
    public ThemLoaiPhong_Fragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_them_loai_phong_, container, false);
        lvLoaiPhong = view.findViewById(R.id.lvLoaiPhongFM);
        fab = view.findViewById(R.id.fab_themloaiphongFM);
        dao = new LoaiPhongDAO(getActivity());
        capNhap();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getActivity() , 0);
            }
        });

        lvLoaiPhong.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                loaiPhong = listLP.get(i);
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
        View view = inflater.inflate(R.layout.dialog_themloaiphong, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

        edtMaLoaiPhong = view.findViewById(R.id.edtmaloaiphong_LoaiPhong);
        edtTenLoaiPhong = view.findViewById(R.id.edttenloaiphong_LoaiPhong);
        Button btnthem = view.findViewById(R.id.btnThemLoaiPhong_DiaLogLoaiPhong);
        Button btnhuy = view.findViewById(R.id.btnHuyLoaiPhong_DiaLogLoaiPhong);
        inputLP = view.findViewById(R.id.dialogLP_inputLP);
        edtMaLoaiPhong.setEnabled(false);
        if (type!=0){
            edtMaLoaiPhong.setText(String.valueOf(loaiPhong.getId()));
            edtTenLoaiPhong.setText(loaiPhong.getTenLoaiPhong());
        }
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    LoaiPhong loaiPhong1 = new LoaiPhong();
                    loaiPhong1.setTenLoaiPhong(edtTenLoaiPhong.getText().toString());
                    if (validate()>0){
                        if (type==0){
                            if (dao.Insert(loaiPhong1)){
                                Toast.makeText(getContext(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                                setData();
                                alertDialog.dismiss();
                            }else {
                                Toast.makeText(getContext(), "Thêm Thất Bại", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            loaiPhong1.setId(Integer.parseInt(edtMaLoaiPhong.getText().toString()));
                            if (dao.Updata(loaiPhong1)){
                                Toast.makeText(context, "Sữa Thành Công", Toast.LENGTH_SHORT).show();
                                alertDialog.dismiss();
                                setData();
                            }else {
                                Toast.makeText(context, "Sữa Thất Bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        capNhap();
                    }
                }catch (Exception ex){
                    Toast.makeText(getActivity(), "Nhập Đúng!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void capNhap(){
        listLP = (ArrayList<LoaiPhong>) dao.GetALL();
        adapter = new LoaiPhong_Adapter(getActivity() , this , listLP);
        lvLoaiPhong.setAdapter(adapter);
    }
    public int validate(){
        int check =1;
        if (edtTenLoaiPhong.getText().length()==0){
            inputLP.setError("Vui lòng nhập tên loại phòng");
            check = -1;
        } else {
            inputLP.setError(null);
        }
        return check;
    }
    public void setData(){
        edtTenLoaiPhong.setText("");
    }
    public void xoa(final String Id){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle("Delete");
        builder.setMessage("Bạn có muốn xóa không? ");
        builder.setCancelable(true);
        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dao.Delete(Integer.parseInt(Id));
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