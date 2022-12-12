package com.example.du_an_alone.ChucNangChinh;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.du_an_alone.Adapter.HoaDon_Adapter;
import com.example.du_an_alone.DAO.DichVuDAO;
import com.example.du_an_alone.DAO.HoaDonDAO;
import com.example.du_an_alone.DAO.HopDongDAO;
import com.example.du_an_alone.DAO.KhachThueDAO;
import com.example.du_an_alone.DAO.PhongDAO;
import com.example.du_an_alone.DTO.DichVu;
import com.example.du_an_alone.DTO.HoaDon;
import com.example.du_an_alone.DTO.HopDong;
import com.example.du_an_alone.DTO.KhachThue;
import com.example.du_an_alone.DTO.Phong;
import com.example.du_an_alone.R;
import com.example.du_an_alone.SelectTable.AdapterSelect_DichVu;
import com.example.du_an_alone.SelectTable.AdapterSelect_HD;
import com.example.du_an_alone.SelectTable.AdapterSelect_KT;
import com.example.du_an_alone.SelectTable.AdapterSelect_P;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

public class Hoa_DonFragment extends Fragment {
    ArrayList<HopDong> listHopDong;
    HopDongDAO hopDongDAO;
    HoaDon hoaDon;
    ArrayList<Phong> listPhong;
    Button btnSelectHD, btnSelectKT, getBtnSelectDV;
    ArrayList<KhachThue> listKhachThue;
    ImageView fab;
    PhongDAO phongDAO;
    KhachThueDAO khachThueDAO;
    ArrayList<DichVu> listDichVu;
    DichVuDAO dichVuDAO;
    HoaDonDAO dao;
    ArrayList<HoaDon> listHoaDon;
    EditText edtTenHopDong;
    ListView lvHoaDon;
    EditText edtmaHoaDon;
    HoaDon_Adapter adapter;
    int position;
    TextView tvmaDichVu, tvMAKT, tvTONGTIENTHANHTOAN, tvNgayThu, errorNgayThu , tvTenKhachThue , tvMaPhong , tvTenPhong , tvTienPhong;
    int maPhong , maKhachThue , tienPhong , maDichVu , TienDien , TienNuoc , TienVeSinh , TienGuiXe , TienWifi , TongTienThanhToan;
    public Hoa_DonFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hoa__don, container, false);
        fab = view.findViewById(R.id.fab_hoadonFM);
        lvHoaDon = view.findViewById(R.id.lvHoaDonFM);
        dao = new HoaDonDAO(getActivity());
        capNhatLV();
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingInflatedId")
            @Override
            public void onClick(View view) {
                openDialog(getActivity() , 0);
            }
        });
        lvHoaDon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                hoaDon = listHoaDon.get(i);
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
        TextView  tvTENKT,  tvMAP, tvTENP,  tvTrangThai, tvTienPhong, tvTienDien, tvTienNuoc, tvTienVeSinh, tvTienGiuXe, tvTienWifi;
        View viewshow = inflater.inflate(R.layout.dialog_haodon, null);
        builder.setView(viewshow);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        edtmaHoaDon = viewshow.findViewById(R.id.edtMaHoaDon_dialogHoaDon);

        tvMAKT = viewshow.findViewById(R.id.tvHD_MAKT_Add_HoaDon);

        tvTENKT = viewshow.findViewById(R.id.tvHD_TENKT_Add_HoaDon);

        tvNgayThu = viewshow.findViewById(R.id.tvHD_NGAYTHU_Add);
        errorNgayThu = viewshow.findViewById(R.id.hoaDon_errorNgay);

        tvMAP = viewshow.findViewById(R.id.tvHD_MAP_Add_HoaDon);

        tvTENP = viewshow.findViewById(R.id.tvHD_TENP_Add_HoaDon);

        tvTienPhong = viewshow.findViewById(R.id.tvHD_TIENP_Add_HoaDon);

        edtmaHoaDon.setEnabled(false);


        tvmaDichVu = viewshow.findViewById(R.id.tvHD_MADV_Add);
        tvTienDien = viewshow.findViewById(R.id.tvHD_TIENDIEN_Add);
        tvTienNuoc = viewshow.findViewById(R.id.tvHD_TIENNUOC_Add);
        tvTienVeSinh = viewshow.findViewById(R.id.tvHD_TIENVESINH_Add);
        tvTienGiuXe = viewshow.findViewById(R.id.tvHD_TIENGUIXE_Add);
        tvTienWifi = viewshow.findViewById(R.id.tvHD_TIENWIFI_Add);
        tvTONGTIENTHANHTOAN = viewshow.findViewById(R.id.tvHD_TONGTIEN_Add);
        tvTrangThai = viewshow.findViewById(R.id.tvHD_TRANGTHAI_Add);
        edtTenHopDong = viewshow.findViewById(R.id.edtTenHopDOng_dialogHoaDon);
        listPhong = new ArrayList<Phong>();
        phongDAO = new PhongDAO(getActivity());
        listPhong = phongDAO.GetAll();
        Button btnTrue = viewshow.findViewById(R.id.btnHD_True_Add);
        Button btnFalse = viewshow.findViewById(R.id.btnHD_False_Add);
        Button btnSave = viewshow.findViewById(R.id.btnHD_Save);
        btnSelectHD = viewshow.findViewById(R.id.btnHD_SelectHD_Add);
        btnSelectKT = viewshow.findViewById(R.id.btnHD_SelectKT_Add);
        getBtnSelectDV = viewshow.findViewById(R.id.btnHD_SelectDV_Add);
        Button btnSelectNgayThu = viewshow.findViewById(R.id.btnHD_SelectNGAYThu_Add);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTrangThai.setTextColor(Color.BLUE);
                tvTrangThai.setText("Đã Thanh Toán");
                btnTrue.setBackgroundColor(Color.BLUE);
                btnFalse.setBackgroundColor(Color.WHITE);

            }
        });
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTrangThai.setTextColor(Color.RED);
                tvTrangThai.setText("Chưa Thanh Toán");
                btnFalse.setBackgroundColor(Color.BLUE);
                btnTrue.setBackgroundColor(Color.WHITE);
            }
        });


        listHopDong = new ArrayList<>();
        hopDongDAO = new HopDongDAO(getActivity());
        listHopDong = hopDongDAO.GetALL();
        btnSelectHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(view.getContext());
                View view1 = LayoutInflater.from(view.getContext()).inflate(R.layout.select_table_hoadon, null);
                builder1.setView(view1);
                Dialog dialog1 = builder1.create();
                dialog1.show();
                AdapterSelect_HD adapterSelect_hd = new AdapterSelect_HD(listHopDong);
                ListView lvShowP = view1.findViewById(R.id.lvShowSelectHoaDon);
                lvShowP.setAdapter(adapterSelect_hd);
                lvShowP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        maKhachThue = listHopDong.get(i).getMaKhachThue();
                        String maKhachThues = tvMAKT.getText().toString();
                        maKhachThues += " " + maKhachThue;
                        tvMAKT.setText(maKhachThues);
                        String tenKhachThue = listHopDong.get(i).getTenKhachHang();
                        String tenKhachThues = tvTENKT.getText().toString();
                        tenKhachThues += " " + tenKhachThue;
                        tvTENKT.setText(tenKhachThues);

                        maPhong = listHopDong.get(i).getMaPhong();
                        String txtmaPhong = tvMAP.getText().toString();
                        txtmaPhong += " " + maPhong;
                        tvMAP.setText(txtmaPhong);

                        String tenPhong = listHopDong.get(i).getTenPhong();
                        String txttenPhong = tvTENP.getText().toString();
                        txttenPhong += " " + tenPhong;
                        tvTENP.setText(txttenPhong);

                        tienPhong = listHopDong.get(i).getGiaPhong();
                        String tienPhongs = tvTienPhong.getText().toString();
                        tienPhongs += " " + tienPhong;
                        tvTienPhong.setText(" " + tienPhongs + "VNĐ"    );
                        dialog1.dismiss();
                    }
                });
            }
        });
        listDichVu = new ArrayList<DichVu>();
        dichVuDAO = new DichVuDAO(getActivity());
        listDichVu = dichVuDAO.SelectAll();
        getBtnSelectDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(view.getContext());
                View view1 = LayoutInflater.from(view.getContext()).inflate(R.layout.select_table_dichvu, null);
                builder1.setView(view1);
                Dialog dialog1 = builder1.create();
                dialog1.show();
                AdapterSelect_DichVu adapterSelect_dichVu = new AdapterSelect_DichVu(listDichVu);
                ListView lvDichVu = view1.findViewById(R.id.lvShowSelectDV);
                lvDichVu.setAdapter(adapterSelect_dichVu);
                EditText soDien, soNuoc, veSinh, guiXe, wifi;
                soDien = view1.findViewById(R.id.edSoDien_Select);
                soNuoc = view1.findViewById(R.id.edSoNuoc_Select);
                veSinh = view1.findViewById(R.id.edVeSinh_Select);
                guiXe = view1.findViewById(R.id.edGuiXe_Select);
                wifi = view1.findViewById(R.id.edWifi_Select);
                lvDichVu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        try {
                            int soDienTD = Integer.parseInt(soDien.getText().toString());
                            int soNuocTD = Integer.parseInt(soNuoc.getText().toString());
                            int veSinhTD = Integer.parseInt(veSinh.getText().toString());
                            int guiXeTD = Integer.parseInt(guiXe.getText().toString());
                            int wifiTD = Integer.parseInt(wifi.getText().toString());
                            if (soDienTD < 0 && soNuocTD < 0 && veSinhTD < 0 && guiXeTD < 0 && wifiTD < 0) {
                                Toast.makeText(getActivity(), "Số Lượng phải >= 0", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            maDichVu = listDichVu.get(i).getMaDichVu();
                            String maDichVus = tvmaDichVu.getText().toString();
                            maDichVus += " " + maDichVu;
                            tvmaDichVu.setText(maDichVus);
                            TienDien = soDienTD * (listDichVu.get(i).getTienDien());
                            tvTienDien.setText("Tiền Điện: " + TienDien + " VNĐ");
                            TienNuoc = soNuocTD * (listDichVu.get(i).getTienNuoc());
                            tvTienNuoc.setText("Tiền Nước: " + TienNuoc + " VNĐ");
                            TienVeSinh = veSinhTD * (listDichVu.get(i).getTienVeSinh());
                            tvTienVeSinh.setText("Tiền Vệ Sinh: " + TienVeSinh + " VNĐ");
                            TienGuiXe = guiXeTD * (listDichVu.get(i).getTienGuiXe());
                            tvTienGiuXe.setText("Tiền Gữi Xe: " + TienGuiXe + "VNĐ");
                            TienWifi = wifiTD * (listDichVu.get(i).getTienWifi());
                            tvTienWifi.setText("Tiền WiFi: " + TienWifi + "VNĐ");
                            int TienPhong = listPhong.get(i).getGiaPhong();
                            int TongTien = TienDien + TienNuoc + TienGuiXe + TienWifi + TienVeSinh + TienPhong;
                            TongTienThanhToan = Integer.parseInt(tvTONGTIENTHANHTOAN.getText().toString());
                            TongTienThanhToan += TongTien;
                            tvTONGTIENTHANHTOAN.setText("" + TongTienThanhToan);
                            dialog1.dismiss();
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), "Nhập Đúng!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        btnSelectNgayThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                DatePickerDialog dialog = new DatePickerDialog(
                        v.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                int nam = i;
                                int thang = i1;
                                int ngay = i2;
                                tvNgayThu.setText(nam + "-" + (thang + 1) + "-" + ngay);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DATE)
                );
                dialog.show();
            }
        });
        edtmaHoaDon.setEnabled(false);
        if (type!=0){
            edtmaHoaDon.setText(String.valueOf(hoaDon.getMaHoaDon()));
            tvMAKT.setText(String.valueOf(hoaDon.getMaKhachThue()));
            tvTENKT.setText(String.valueOf(hoaDon.getTenKhachThue()));
            tvNgayThu.setText(hoaDon.getNgayThu());
            tvTENP.setText(hoaDon.getTenPhong());
            tvMAP.setText(String.valueOf(hoaDon.getMaPhong()));
            tvTienPhong.setText(String.valueOf(hoaDon.getTienPhong()));
//            tvmaDichVu.setText(String.valueOf(hoaDon.getMaDichVu()));
            edtTenHopDong.setText(hoaDon.getTenHoaDon());
//            tvTienDien.setText(String.valueOf(hoaDon.getSoDien()));
//            tvTienNuoc.setText(String.valueOf(hoaDon.getSoDien()));
//            tvTienVeSinh.setText(String.valueOf(hoaDon.getVeSinh()));
//            tvTienGiuXe.setText(String.valueOf(hoaDon.getGuiXe()));
//            tvTienWifi.setText(String.valueOf(hoaDon.getWifi()));
//            tvTONGTIENTHANHTOAN.setText(String.valueOf());
            btnSave.setText("updata");
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                try {
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setTenHoaDon(edtTenHopDong.getText().toString());
                    hoaDon.setMaPhong(maPhong);
                    hoaDon.setTenPhong(tvTENP.getText().toString());
                    hoaDon.setMaKhachThue(maKhachThue);
                    hoaDon.setTenKhachThue(tvTENKT.getText().toString());
                    hoaDon.setTienPhong(tienPhong);
                    hoaDon.setMaDichVu(maDichVu);
                    hoaDon.setSoDien(TienDien);
                    hoaDon.setSoNuoc(TienNuoc);
                    hoaDon.setVeSinh(TienVeSinh);
                    hoaDon.setGuiXe(TienGuiXe);
                    hoaDon.setWifi(TienWifi);
                    hoaDon.setTongTienThanhToan(TongTienThanhToan);
                    hoaDon.setTrangThai(tvTrangThai.getText().toString());
                    hoaDon.setNgayThu(tvNgayThu.getText().toString());
                    if (validate() > 0) {
                        if (type == 0) {
                            if (dao.Insert(hoaDon)) {
                                Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
                                alertDialog.dismiss();
                            } else {
                                Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            hoaDon.setMaHoaDon(Integer.parseInt(edtmaHoaDon.getText().toString()));
                            if (dao.Updata(hoaDon)) {
                                Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                                alertDialog.dismiss();
                            } else {
                                Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        capNhatLV();
                    }
//                }
//                catch (Exception e) {
//                    Toast.makeText(getActivity(), "Nhập Đúng", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

    public void xoa(final String Id) {
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

    public int validate() {
        int check = 1;
        if (edtTenHopDong.getText().length() == 0 ) {
            edtTenHopDong.setError("Nhập tháng thu tiền");
            check = -1;
        }
        if(tvMAKT.getText().length()==0) {
            Toast.makeText(getActivity(), "Vui lòng chọn phòng", Toast.LENGTH_SHORT).show();
            check=-1;
        }
        if(tvmaDichVu.getText().length()==0) {
            Toast.makeText(getActivity(), "Vui lòng chọn dịch vụ", Toast.LENGTH_SHORT).show();
            check=-1;
        }
        if(tvNgayThu.getText().length()==0) {
            errorNgayThu.setVisibility(View.VISIBLE);
            check=-1;
        } else {
            errorNgayThu.setVisibility(View.GONE);
        }
        return check;
    }

    public void capNhatLV() {
        listHoaDon = (ArrayList<HoaDon>) dao.GetALL();
        adapter = new HoaDon_Adapter(getContext(), this, (ArrayList<HoaDon>) listHoaDon);
        lvHoaDon.setAdapter(adapter);
    }
}