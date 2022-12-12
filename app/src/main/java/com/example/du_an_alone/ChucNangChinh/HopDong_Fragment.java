package com.example.du_an_alone.ChucNangChinh;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.du_an_alone.Adapter.HopDong_Adapter;
import com.example.du_an_alone.Adapter.Phong_Adapter;
import com.example.du_an_alone.DAO.DichVuDAO;
import com.example.du_an_alone.DAO.HopDongDAO;
import com.example.du_an_alone.DAO.KhachThueDAO;
import com.example.du_an_alone.DAO.PhongDAO;
import com.example.du_an_alone.DTO.DichVu;
import com.example.du_an_alone.DTO.HopDong;
import com.example.du_an_alone.DTO.KhachThue;
import com.example.du_an_alone.DTO.Phong;
import com.example.du_an_alone.R;
import com.example.du_an_alone.SelectTable.AdapterSelect_DichVuShow;
import com.example.du_an_alone.SelectTable.AdapterSelect_KT;
import com.example.du_an_alone.SelectTable.AdapterSelect_P;

import java.util.ArrayList;
import java.util.Calendar;


public class HopDong_Fragment extends Fragment {
    PhongDAO phongDAO;
    KhachThueDAO khachThueDAO;
    DichVuDAO dichVuDAO;
    ArrayList<Phong> listPhong;
    ArrayList<KhachThue> listKhachThue;
    ArrayList<DichVu> listDichVu;
    String tenPhong  , tenKhachHang, queQuan ;
    int maPhong , maKhachHang , maDichVu , position ,soDienthoai ,  cCCD  , giaphong  , tienDien , tienNuoc , tienVeSinh ,tienGuiXe  , tienWifi ;
    TextView tvMAKT, tvTENKT, tvMAP, tvTENP, tvmaDichVu
            ;
    CheckBox checkboxTienCoc;
    ImageView fab;
    EditText    tvmaHopDong ,tvTienCoc;
    ImageView tvNgayLam , tvNgayKetThuc;
    HopDongDAO dao;
    ArrayList<HopDong> listHopDong;
    Button btnThem , btnHuy , btnDiaLogPhong , btnDiaLogKhachThue , btnDialogDichVu;
    HopDong hopDong;
    ListView listViewHD;
    TextView txtNgayLam , txtNgayKetThuc;
    HopDong_Adapter adapter;

    public HopDong_Fragment() {

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hop_dong_, container, false);
        fab = view.findViewById(R.id.fab_hopdong);
        dao = new HopDongDAO(getActivity());
        listViewHD = view.findViewById(R.id.lvhopdong);
        dao = new HopDongDAO(getActivity());
        capNhatLV();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getActivity() , 0);
            }
        });
        listViewHD.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                hopDong = listHopDong.get(i);
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
        View view = inflater.inflate(R.layout.dialog_hopdong, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

        tvmaHopDong = view.findViewById(R.id.edtmahopdong_dialogHopDong);
        tvTienCoc = view.findViewById(R.id.edtTienCoc_DiaLogHopDong);
        tvNgayLam = view.findViewById(R.id.imgngaylam_hopdong);
        tvNgayKetThuc = view.findViewById(R.id.imgngayhethan_hopdong);
        txtNgayLam = view.findViewById(R.id.txtngaylam_dialoghopdong);
        txtNgayKetThuc = view.findViewById(R.id.txtngayhethan_dialoghopdong);
        btnThem = view.findViewById(R.id.btnthemhopdong_btnAdd);
        tvMAP = view.findViewById(R.id.tvHD_MAP_Add);
        tvTENP = view.findViewById(R.id.tvHD_TENP_Add);
        tvMAKT = view.findViewById(R.id.tvHD_MAKT_Add);
        tvTENKT = view.findViewById(R.id.tvHD_TENKT_Add);
        tvmaDichVu = view.findViewById(R.id.tvHD_MADV_Add);
        btnHuy = view.findViewById(R.id.btnhuyhopdong_btnHuy);
        checkboxTienCoc = view.findViewById(R.id.checkbox_trangthaithanhtoatiencoc_Phong);
        listPhong = new ArrayList<Phong>();
        phongDAO = new PhongDAO(getActivity());
        listPhong = phongDAO.getPhongTrong(); // Luu y
        listKhachThue = new ArrayList<KhachThue>();
        khachThueDAO = new KhachThueDAO(getActivity());
        listKhachThue = khachThueDAO.GetALL(); // luy y
        btnDialogDichVu = view.findViewById(R.id.btnHD_SelectDV_Add);
        btnDiaLogKhachThue = view.findViewById(R.id.btnHD_SelectKT_Add);
        btnDiaLogPhong = view.findViewById(R.id.btnHD_SelectP_Add);
        btnDiaLogPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(view.getContext());
                View view1 = LayoutInflater.from(view.getContext()).inflate(R.layout.select_table_phong, null);
                builder1.setView(view1);
                Dialog dialog1 = builder1.create();
                dialog1.show();
                AdapterSelect_P adapterSelect_p = new AdapterSelect_P(listPhong);
                ListView lvShowP = view1.findViewById(R.id.lvShowSelectP);
                lvShowP.setAdapter(adapterSelect_p);
                lvShowP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        maPhong = listPhong.get(i).getId();
                        tvMAP.setText(String.valueOf(maPhong));
                        tenPhong = listPhong.get(i).getTenPhong();
                        String txttenPhong = tvTENP.getText().toString();
                        txttenPhong += " " + tenPhong;
                        tvTENP.setText(txttenPhong);
                        giaphong = listPhong.get(i).getGiaPhong();
                        dialog1.dismiss();
                    }
                });
            }
        });
        btnDiaLogKhachThue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(view.getContext());
                View view1 = LayoutInflater.from(view.getContext()).inflate(R.layout.select_table_kh, null);
                builder1.setView(view1);
                Dialog dialog1 = builder1.create();
                dialog1.show();
                AdapterSelect_KT adapterSelect_kt = new AdapterSelect_KT(listKhachThue);
                ListView lvShopKT = view1.findViewById(R.id.lvShowSelectKH);
                lvShopKT.setAdapter(adapterSelect_kt);
                lvShopKT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        maKhachHang = listKhachThue.get(i).getMaKhachThue();
                        String maKhachThues = tvMAKT.getText().toString();
                        maKhachThues += " " + maKhachHang;
                        tvMAKT.setText(maKhachThues);
                        tenKhachHang = listKhachThue.get(i).getTen();
                        String tenKhachThues = tvTENKT.getText().toString();
                        tenKhachThues += " " + tenKhachHang;
                        tvTENKT.setText(tenKhachThues);
                        queQuan = listKhachThue.get(position).getQueQuan();
                        soDienthoai = listKhachThue.get(position).getSoDienThoai();
                        cCCD = listKhachThue.get(position).getCCCD();
                        dialog1.dismiss();
                    }
                });
            }
        });
        listDichVu = new ArrayList<DichVu>();
        dichVuDAO = new DichVuDAO(getActivity());
        listDichVu = dichVuDAO.SelectAll();
        btnDialogDichVu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(view.getContext());
                View view1 = LayoutInflater.from(view.getContext()).inflate(R.layout.select_table_dichvuhopdong, null);
                builder1.setView(view1);
                Dialog dialog1 = builder1.create();
                dialog1.show();
                AdapterSelect_DichVuShow adapterSelect_kt = new AdapterSelect_DichVuShow(listDichVu);
                ListView lvShopDV = view1.findViewById(R.id.lvShowSelectDVHD);
                lvShopDV.setAdapter(adapterSelect_kt);
                lvShopDV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        maDichVu = listDichVu.get(position).getMaDichVu();
                        String madichvus = tvMAKT.getText().toString();
                        madichvus+=" " + maDichVu;
                        tvmaDichVu.setText(madichvus);
                        tienDien = listDichVu.get(position).getTienDien();
                        tienNuoc = listDichVu.get(position).getTienNuoc();
                        tienVeSinh =listDichVu.get(position).getTienVeSinh();
                        tienGuiXe =listDichVu.get(position).getTienGuiXe();
                        tienWifi =listDichVu.get(position).getTienWifi();
                            dialog1.dismiss();
                    }
                });
            }
        });
        tvNgayLam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                DatePickerDialog dialog =new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            int nam = i;
                            int thang = i1;
                            int ngay = i2;
                            txtNgayLam.setText(nam +" - "+( thang + 1 )+" - "+ngay);
                    }
                },      calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DATE));
                        dialog.show();
            }

        });
        tvNgayKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                DatePickerDialog dialog =new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        int nam = i;
                        int thang = i1+1;
                        int ngay = i2;
                        txtNgayKetThuc.setText(nam +" - "+ (thang + 1)+" - "+ngay);
                    }
                },      calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
        tvmaHopDong.setEnabled(false);
        if (type != 0){
            tvmaHopDong.setText(String.valueOf(hopDong.getMaHopDong()));
            tvTienCoc.setText(String.valueOf(hopDong.getTienCoc()));
            txtNgayLam.setText(hopDong.getNgayLamHopDong());
            txtNgayKetThuc.setText(hopDong.getNgayKetThuc());
            tvMAP.setText(String.valueOf(hopDong.getMaPhong()));
            tvTENP.setText(hopDong.getTenPhong());
            tvMAKT.setText(String.valueOf(hopDong.getMaKhachThue()));
            tvTENKT.setText(hopDong.getTenKhachHang());
            tvmaDichVu.setText(String.valueOf(hopDong.getMaDichVu()));
//            tvTienDien.setText(String.valueOf(hopDong.getTienDien()));
//            tvTienNuoc.setText(String.valueOf(hopDong.getTienNuoc()));
//            tvTienVeSinh.setText(String.valueOf(hopDong.getTienVeSinh()));
//            tvTienGuiXe.setText(String.valueOf(hopDong.getTienGuiXe()));
//            tvTienWifi.setText(String.valueOf(hopDong.getTienWifi()));
//            tvGiaPhong.setText(String.valueOf(hopDong.getGiaPhong()));
//            tvSDT.setText(String.valueOf(hopDong.getSoDienThoai()));
//            tvCCCD.setText(String.valueOf(hopDong.getSoDienThoai()));
//            tvQueQuan.setText(String.valueOf(hopDong.getQueQuan()));

            if (hopDong.getTrangThaitiencoc()==1){
                checkboxTienCoc.setChecked(true);
            }else {
                checkboxTienCoc.setChecked(false);
            }
            btnThem.setText("UPDATE");
        }
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validate() > 0) {
//                try {
                    HopDong  hopDong = new HopDong();
                    hopDong.setTienCoc(Integer.parseInt(tvTienCoc.getText().toString()));
                    hopDong.setNgayLamHopDong(txtNgayLam.getText().toString());
                    hopDong.setNgayKetThuc(txtNgayKetThuc.getText().toString());
                    hopDong.setMaPhong(maPhong);
                    hopDong.setTenPhong(tenPhong);
                    hopDong.setMaKhachThue(maKhachHang);
                    hopDong.setTenKhachHang(tenKhachHang);
                    hopDong.setQueQuan(queQuan);
                    hopDong.setSoDienThoai(soDienthoai);
                    hopDong.setCCCD(cCCD);
                    hopDong.setMaDichVu(maDichVu);
                    hopDong.setTienDien(tienDien);
                    hopDong.setTienNuoc(tienNuoc);
                    hopDong.setTienVeSinh(tienVeSinh);
                    hopDong.setTienGuiXe(tienGuiXe);
                    hopDong.setTienWifi(tienWifi);
                    hopDong.setGiaPhong(giaphong);
                    if (checkboxTienCoc.isChecked()){
                        hopDong.setTrangThaitiencoc(1);
                    }else {
                        hopDong.setTrangThaitiencoc(0);
                    }
                        if (type == 0) {
                            if (dao.Insert(hopDong)) {
                                Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
                                //code update trạng thái
                                alertDialog.dismiss();
                                phongDAO.updateTrangThai(hopDong.getMaPhong(), 1);
                            } else {
                                Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            hopDong.setMaHopDong(Integer.parseInt(tvmaHopDong.getText().toString()));
                            if (dao.Updata(hopDong)) {
                                  Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                                alertDialog.dismiss();
                            } else {
                                Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        capNhatLV();
                     }
//                catch (Exception ex){
//                     Toast.makeText(getActivity(), "Nhập Đúng!", Toast.LENGTH_SHORT).show();
//                   }
//                }
            }
        });
        }
    public void setData(){
        tvTienCoc.setText("");
    }

    public int validate() {
        int check = 1;
        if (tvMAP.getText().length() == 0 && tvTENP.getText().length()==0) {
            Toast.makeText(getActivity(), "Vui lòng chọn phòng", Toast.LENGTH_SHORT).show();
            check = -1;
        } else if(tvMAKT.getText().length()==0&&tvTENKT.getText().length()==0) {
            Toast.makeText(getActivity(), "Vui lòng chọn khách thuê", Toast.LENGTH_SHORT).show();
            check =-1;
        } else if(tvmaDichVu.getText().length()==0) {
            Toast.makeText(getActivity(), "Vui lòng chọn dịch vụ", Toast.LENGTH_SHORT).show();
            check=-1;
        }

        if(txtNgayLam.getText().length()==0) {
            txtNgayLam.setError("Vui lòng chọn ngày làm hợp đồng");
            check=-1;
        }
        if(txtNgayKetThuc.getText().length()==0) {
            txtNgayKetThuc.setError("Vui lòng chọn ngày kết thúc");
            check=-1;
        }
        if(tvTienCoc.getText().length()==0) {
            tvTienCoc.setError("Vui lòng nhập tiền cọc");
            check=-1;
        }
        return check;
    }
    public void capNhatLV() {
        listHopDong = (ArrayList<HopDong>) dao.GetALL();
        adapter = new HopDong_Adapter(getContext(), this, (ArrayList<HopDong>) listHopDong);
        listViewHD.setAdapter(adapter);
    }
}