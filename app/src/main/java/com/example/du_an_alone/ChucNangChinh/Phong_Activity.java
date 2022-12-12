package com.example.du_an_alone.ChucNangChinh;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_alone.Adapter.Phong_Adapter;
import com.example.du_an_alone.Adapter.Phong_Adapter_Activity;
import com.example.du_an_alone.DAO.PhongDAO;
import com.example.du_an_alone.R;
import com.example.du_an_alone.SQLiteHelper.SQLite_PhongTro;

public class Phong_Activity extends AppCompatActivity {
    ListView listViewPhong;
    Phong_Adapter_Activity adapter;
    PhongDAO dao;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong);
        listViewPhong = findViewById(R.id.lvphongdemo);

        dao = new PhongDAO(getApplicationContext());
        SQLite_PhongTro sqLite_phongTro = new SQLite_PhongTro(getApplicationContext());
        adapter= new Phong_Adapter_Activity(getApplicationContext() , this , dao.GetAll());
        listViewPhong.setAdapter(adapter);
    }

}