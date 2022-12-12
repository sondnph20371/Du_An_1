package com.example.du_an_alone.ChucNangChinh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.du_an_alone.Adapter.DichVu_Adapter;
import com.example.du_an_alone.Adapter.DichVu_Adapter_Activity;
import com.example.du_an_alone.Adapter.LoaiPhong_Adapter;
import com.example.du_an_alone.DAO.DichVuDAO;
import com.example.du_an_alone.DAO.LoaiPhongDAO;
import com.example.du_an_alone.DTO.DichVu;
import com.example.du_an_alone.DTO.LoaiPhong;
import com.example.du_an_alone.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DichVu_Activity extends AppCompatActivity {

    DichVuDAO dao;
    DichVu_Adapter_Activity adapter;
    ListView lvDichVu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dich_vu);
        lvDichVu = findViewById(R.id.lvdichvu);
        dao = new DichVuDAO(getApplicationContext());
        adapter = new DichVu_Adapter_Activity(getApplicationContext() , this , dao.SelectAll());
        lvDichVu.setAdapter(adapter);
    }
}