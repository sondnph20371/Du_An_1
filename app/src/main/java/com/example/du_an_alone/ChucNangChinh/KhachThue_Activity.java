package com.example.du_an_alone.ChucNangChinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.du_an_alone.Adapter.KhachThue_Adapter;
import com.example.du_an_alone.Adapter.KhachThue_Adapter_Activity;
import com.example.du_an_alone.DAO.KhachThueDAO;
import com.example.du_an_alone.DTO.KhachThue;
import com.example.du_an_alone.R;

import java.util.ArrayList;

public class KhachThue_Activity extends AppCompatActivity {
    ArrayList<KhachThue> listKhachThue;
    KhachThueDAO dao;
    final Context context = this;
    KhachThue_Adapter_Activity adapter;
    ListView listViewKhachThue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khach_thue);
        listViewKhachThue = findViewById(R.id.lvKhachThue);
        dao = new KhachThueDAO(getApplicationContext());
        adapter = new KhachThue_Adapter_Activity(getApplicationContext() , this , dao.GetALL());
        listViewKhachThue.setAdapter(adapter);
    }
}