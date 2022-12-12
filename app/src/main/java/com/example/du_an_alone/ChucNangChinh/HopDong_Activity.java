package com.example.du_an_alone.ChucNangChinh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.example.du_an_alone.Adapter.HopDong_Adapter;
import com.example.du_an_alone.Adapter.HopDong_Adapter_Activity;
import com.example.du_an_alone.DAO.HopDongDAO;
import com.example.du_an_alone.R;

public class HopDong_Activity extends AppCompatActivity {
    ListView lvHopDong;
    HopDong_Adapter_Activity adapter;
    HopDongDAO dao;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop_dong);
        lvHopDong = findViewById(R.id.lvHopDong_Activity);

        dao = new HopDongDAO(getApplicationContext());
        adapter= new HopDong_Adapter_Activity(getApplicationContext() , this , dao.GetALL());
        lvHopDong.setAdapter(adapter);
    }
}