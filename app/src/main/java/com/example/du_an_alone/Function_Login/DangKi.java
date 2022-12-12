package com.example.du_an_alone.Function_Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_alone.DTO.DangNhap;
import com.example.du_an_alone.R;
import com.example.du_an_alone.SQLiteHelper.SQLife;
import com.google.android.material.textfield.TextInputLayout;


import java.util.ArrayList;

public class DangKi extends AppCompatActivity {
    EditText edTaiKhoan,edMatKhau,edMatKhau2;
    Button btnNext;
    TextInputLayout ipTK, ipMK, ipRePass;
    String taiKhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);

        edTaiKhoan = findViewById(R.id.edAddTaiKhoan);
        edMatKhau = findViewById(R.id.edAddMatKhau);
        edMatKhau2 = findViewById(R.id.edNhapLaiMK);
        btnNext = findViewById(R.id.btnNext_DK);

        ipRePass = findViewById(R.id.dangKi_ipRepass);
        ipMK = findViewById(R.id.dangKi_ipMK);
        ipTK = findViewById(R.id.dangKi_ipTK);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TaiKhoan = edTaiKhoan.getText().toString();
                String MatKhau = edMatKhau.getText().toString();
                String MatKhau2 = edMatKhau2.getText().toString();
                SQLife sqLife = new SQLife(getApplicationContext());
                ArrayList<DangNhap> dangNhaps = new ArrayList<>();
                dangNhaps = sqLife.getALLNV();
//                for (int i = 0; i< dangNhaps.size(); i++)
//                {
//                    String TaiKhoan2 = dangNhaps.get(i).getUserName();
//                    if (TaiKhoan.toString().equals(TaiKhoan2.toString())==true)
//                    {
//                        Toast.makeText(DangKi.this, "Tài Khoản Đã Tồn Tại" , Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                }
                SharedPreferences sharedPreferences = getSharedPreferences("USER_FILE", MODE_PRIVATE);
                taiKhoan = sharedPreferences.getString("USERNAME", "");

                if(validate()>0) {
                    Intent intent = new Intent(DangKi.this,StepDangKi.class);
                    intent.putExtra("TaiKhoan",TaiKhoan);
                    intent.putExtra("MatKhau",MatKhau);
                    startActivity(intent);
                }

            }
        });
    }

    public int validate() {
        int check = 1;
        if (edTaiKhoan.getText().length() == 0) {
            ipTK.setError("Tài khoản không được để trống");
//            ipTK.setErrorTextColor(ColorStateList.valueOf(Color.WHITE));
            check = -1;
        } else if (edTaiKhoan.getText().length() > 0) {
            if (edTaiKhoan.getText().toString().equals(taiKhoan)) {
                ipTK.setError("Tên tài khoản đã tồn tại");
//                ipAddTK.setErrorTextColor(ColorStateList.valueOf(Color.WHITE));
                check = -1;
            } else {
                ipTK.setError(null);
            }
        } else {
            ipTK.setError(null);
        }

        if (edMatKhau.getText().length() == 0) {
            ipMK.setError("Mật khẩu không được để trống");
//            ipMK.setErrorTextColor(ColorStateList.valueOf(Color.WHITE));
            check = -1;
        } else if (edMatKhau.getText().length() < 7) {
            ipMK.setError("Mật khẩu phải dài hơn 8 kí tự");
//            ipMK.setErrorTextColor(ColorStateList.valueOf(Color.WHITE));
            check = -1;
        } else {
            ipMK.setError(null);
        }

        if (edMatKhau2.getText().length() == 0) {
            ipRePass.setError("Nhập lại mật khẩu");
            ipRePass.setErrorTextColor(ColorStateList.valueOf(Color.WHITE));
            check = -1;
        } else if (!edMatKhau.getText().toString().equals(edMatKhau2.getText().toString())) {
            ipRePass.setError("Mậ khẩu không trùng khớp");
            ipRePass.setErrorTextColor(ColorStateList.valueOf(Color.WHITE));
            check = -1;
        } else {
            ipRePass.setError(null);
        }

        return check;
    }

}