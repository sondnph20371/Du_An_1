package com.example.du_an_alone.Function_Login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.du_an_alone.DTO.DangNhap;
import com.example.du_an_alone.R;
import com.example.du_an_alone.SQLiteHelper.SQLife;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class ForgotPassWord extends AppCompatActivity {
    EditText user, newPass, rePass;
    SQLife sqLife;
    TextView tvError;
    Button btnSave, btnCancel;
    ArrayList<DangNhap> list;
    String taiKhoan;
    TextInputLayout ipTk, ipNewPass, ipRepass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass_word);
        user = findViewById(R.id.forgot_edtTaiKhoan);
        newPass = findViewById(R.id.forgot_edtNewMatKhau);
        rePass = findViewById(R.id.forgot_edtNhapLaiMK);
        tvError = findViewById(R.id.forgot_tvError);
        btnCancel = findViewById(R.id.forgot_btnCancel);
        btnSave = findViewById(R.id.forgot_btnSave);
        ipTk = findViewById(R.id.forgot_ipTk);
        ipNewPass = findViewById(R.id.forgot_ipNewPass);
        ipRepass = findViewById(R.id.forgot_ipRePass);


        list = new ArrayList<>();
        sqLife = new SQLife(this);
        list = sqLife.getALLNV();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("USER_FILE", MODE_PRIVATE);
                taiKhoan = sharedPreferences.getString("USERNAME", "");
                String matKhau1 = newPass.getText().toString();


                if (validate() > 0) {
                    boolean check = sqLife.forgotPass(user.getText().toString(), matKhau1);
                    if (check) {
                        Toast.makeText(ForgotPassWord.this, "C???p nh???t m???t kh???u th??nh c??ng", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ForgotPassWord.this, com.example.du_an_alone.Function_Login.DangNhap.class));
                    } else {
                        Toast.makeText(ForgotPassWord.this, "C???p nh???t m???t kh???u th???t b???i", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPassWord.this , com.example.du_an_alone.Function_Login.DangNhap.class);
                startActivity(intent);
            }
        });
    }

    public int validate() {
        int check = 1;
        if (user.getText().length() == 0) {
            ipTk.setError("T??i kho???n kh??ng ???????c ????? tr???ng");
            check = -1;
        } else if (user.getText().length() > 0) {
            if (!user.getText().toString().equals(taiKhoan)) {
                ipTk.setError("T??i kho???n kh??ng t???n t???i");
                check = -1;
            } else {
                ipTk.setError(null);
            }
        } else {
            ipTk.setError(null);
        }

        if (newPass.getText().length() == 0) {
            ipNewPass.setError("M???t kh???u kh??ng ???????c ????? tr???ng");
            check = -1;
        } else if (newPass.getText().length() < 7) {
            ipNewPass.setError("M???t kh???u ph???i d??i h??n 8 k?? t???");
            check = -1;
        } else {
            ipNewPass.setError(null);
        }

        if (rePass.getText().length() == 0) {
            ipRepass.setError("Nh???p l???i m???t kh???u");
            check = -1;
        } else if (!newPass.getText().toString().equals(rePass.getText().toString())) {
            ipRepass.setError("M???t kh???u kh??ng tr??ng kh???p");
            check = -1;
        } else {
            ipRepass.setError(null);
        }

        return check;
    }

}