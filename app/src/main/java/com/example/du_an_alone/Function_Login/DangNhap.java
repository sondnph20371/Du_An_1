package com.example.du_an_alone.Function_Login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.du_an_alone.MainActivity;
import com.example.du_an_alone.R;
import com.example.du_an_alone.SQLiteHelper.SQLife;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DangNhap extends AppCompatActivity {
    Button btnDangKi,btnDangNhap;
    EditText edTaiKhoan,edMatKhau;
    CheckBox chkRem;
    TextView tvQuen;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKi = findViewById(R.id.btnDangKi);
        edTaiKhoan = findViewById(R.id.edTaiKhoan);
        edMatKhau = findViewById(R.id.edMatKhau);
        chkRem = findViewById(R.id.chk_remember);
        tvQuen = findViewById(R.id.tvQuenMatKhau);

        SharedPreferences share = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        String user = share.getString("USERNAME", "");
        String pass = share.getString("PASSWORD", "");
        Boolean rem = share.getBoolean("REMEMBER", false);


        edTaiKhoan.setText(user);
        edMatKhau.setText(pass);
        chkRem.setChecked(rem);

        tvQuen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangNhap.this, ForgotPassWord.class));
            }
        });


        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TaiKhoan = edTaiKhoan.getText().toString();
                String MatKhau = edMatKhau.getText().toString();
                SQLife sqLife = new SQLife(getApplicationContext());
                ArrayList<com.example.du_an_alone.DTO.DangNhap> dangNhaps = new ArrayList<>();
                dangNhaps = sqLife.getALLNV();
                boolean check = false;
                    for (int i = 0; i< dangNhaps.size(); i++)
                    {
                        String TaiKhoan2 = dangNhaps.get(i).getUserName();
                        String MatKhau2 = dangNhaps.get(i).getPassWord();

                        if (TaiKhoan.toString().equals(TaiKhoan2.toString())==true)
                        {
                            if (MatKhau.toString().equals(MatKhau2.toString())==true)
                            {
                                Intent intent = new Intent(DangNhap.this, MainActivity.class);
                                ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
                                remember(TaiKhoan, MatKhau, chkRem.isChecked());
                                sqLife.checkLogin(TaiKhoan, MatKhau);
                                startActivity(intent);
                                return;
                            }
                            if (MatKhau.toString().equals(MatKhau2.toString())==false)
                            {
                                Toast.makeText(DangNhap.this, "Mật Khẩu Chưa Chính Xác", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                        check = false;
                    }
                if (check==false)
                {
                    Toast.makeText(DangNhap.this, "Tài Khoản Không Tồn Tại", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this,DangKi.class);
                startActivity(intent);
            }
        });
    }

    public void remember(String u, String p, boolean status) {
        SharedPreferences share = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        if(!status) {
//            xóa tình trạng lưu trữ trước đó
            editor.clear();
        }  else {
//            lưu dữ liêu
            editor.putString("USERNAME", u);
            editor.putString("PASSWORD", p);
            editor.putBoolean("REMEMBER", status);
        }
        editor.commit();
    }
}