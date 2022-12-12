package com.example.du_an_alone.ChucNangChinh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.du_an_alone.Adapter.HoaDon_Adapter;
import com.example.du_an_alone.Adapter.HoaDon_Adapter_Activity;
import com.example.du_an_alone.DAO.HoaDonDAO;
import com.example.du_an_alone.DTO.HoaDon;
import com.example.du_an_alone.R;

import java.util.ArrayList;

public class Hoa_Don_Activity extends AppCompatActivity {
    HoaDon_Adapter_Activity hoaDon_adapter;
    ArrayList<HoaDon> listHD;
    HoaDonDAO dao;
    ListView listViewHD;
    Button btntest;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        listViewHD= findViewById(R.id.lvHoaDon);
        dao = new HoaDonDAO(getApplicationContext());
        hoaDon_adapter = new HoaDon_Adapter_Activity(getApplicationContext() , this , dao.GetALL());
        listViewHD.setAdapter(hoaDon_adapter);
    }
}