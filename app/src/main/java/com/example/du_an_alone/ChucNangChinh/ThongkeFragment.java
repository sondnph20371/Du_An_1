package com.example.du_an_alone.ChucNangChinh;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.du_an_alone.DAO.HoaDonDAO;
import com.example.du_an_alone.DTO.HoaDon;
import com.example.du_an_alone.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class ThongkeFragment extends Fragment {
    Button btntungay , btndenngay , btndanhthu;
    TextView tvtungay ,tvdenngay ,tvdanhthu;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    int mYear , mMonth , mDay;
    public ThongkeFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thongke, container, false);
        btntungay = view.findViewById(R.id.btnStartDate);
        btndenngay = view.findViewById(R.id.btnEndDate);
        tvtungay = view.findViewById(R.id.tvStartDate);
        tvdenngay = view.findViewById(R.id.tvEndDate);
        btndanhthu = view.findViewById(R.id.btnThongKe);
        tvdanhthu = view.findViewById(R.id.tvDoanhThu);
        btntungay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog d = new DatePickerDialog(getActivity() , 0 , mDateTuNgay , mYear , mMonth , mDay);
            d.show();
            }
        });
        btndenngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog d = new DatePickerDialog(getActivity() , 0 , mDateTuDen , mYear , mMonth , mDay);
                d.show();
            }
        });
        return view;
    }
    DatePickerDialog.OnDateSetListener mDateTuNgay = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mYear  = year;
            mMonth = month;
            mDay = dayOfMonth;
            GregorianCalendar c = new GregorianCalendar(mYear , mMonth , mDay);
            tvtungay.setText(sdf.format(c.getTime()));
        }
    };
    DatePickerDialog.OnDateSetListener mDateTuDen = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mYear  = year;
            mMonth = month;
            mDay = dayOfMonth;
            GregorianCalendar c = new GregorianCalendar(mYear , mMonth , mDay);
            tvdenngay.setText(sdf.format(c.getTime()));
        }
    };
}