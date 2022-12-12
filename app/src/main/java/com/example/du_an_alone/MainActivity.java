package com.example.du_an_alone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.du_an_alone.ChucNangChinh.DichVuCT_Fragment;
import com.example.du_an_alone.ChucNangChinh.DichVu_Activity;
import com.example.du_an_alone.ChucNangChinh.DichVu_Fragment;
import com.example.du_an_alone.ChucNangChinh.Fragment_ThanhLiPhong;
import com.example.du_an_alone.ChucNangChinh.Hoa_DonFragment;
import com.example.du_an_alone.ChucNangChinh.Hoa_Don_Activity;
import com.example.du_an_alone.ChucNangChinh.Home_Fragment;
import com.example.du_an_alone.ChucNangChinh.HopDong_Activity;
import com.example.du_an_alone.ChucNangChinh.HopDong_Fragment;
import com.example.du_an_alone.ChucNangChinh.KhachThue_Activity;
import com.example.du_an_alone.ChucNangChinh.LoaiPhong_Activity;
import com.example.du_an_alone.ChucNangChinh.Phong_Activity;
import com.example.du_an_alone.ChucNangChinh.ThemKhachThue_Fragment;
import com.example.du_an_alone.ChucNangChinh.ThemLoaiPhong_Fragment;
import com.example.du_an_alone.ChucNangChinh.ThemPhong_Fragment;
import com.example.du_an_alone.ChucNangChinh.ThongkeFragment;
import com.example.du_an_alone.DTO.DangNhap;
import com.example.du_an_alone.Function_Login.DangKi;
import com.example.du_an_alone.SQLiteHelper.SQLife;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ImageButton imgPhong, imgLoaiPhong , imgDichVu , imgHoaDon , imgKhachThue , imghopdong;
    Intent intent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerlayout);
        setSupportActionBar(toolbar);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Home_Fragment home_fragment = new Home_Fragment();
        fragmentManager.beginTransaction().replace(R.id.fragment_main , home_fragment).commit();

        NavigationView nav =findViewById(R.id.nav_view);
        View headerLayout = nav.getHeaderView(0);

        TextView tvName = headerLayout.findViewById(R.id.nav_name);
        TextView tvPhone = headerLayout.findViewById(R.id.nav_phone);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this , drawerLayout , toolbar , R.string.navigationdrawer_open , R.string.navigationdrawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                Class fragmenClass = null;
                switch (item.getItemId()){

                    case R.id.nav_khachthue:
                        fragmenClass = ThemKhachThue_Fragment.class;
                        break;
                    case R.id.nav_home:
                        fragmenClass = Home_Fragment.class;
                        break;
                    case R.id.nav_phong:
                        fragmenClass = ThemPhong_Fragment.class;
                        break;
                    case R.id.nav_loaiphong:
                        fragmenClass = ThemLoaiPhong_Fragment.class;
                        break;
                    case R.id.nav_dichvu:
                        fragmenClass = DichVu_Fragment.class;
                        break;
                    case R.id.nav_hopdong:
                        fragmenClass = HopDong_Fragment.class;
                        break;
                    case R.id.nav_hoadon:
                        fragmenClass = Hoa_DonFragment.class;
                        break;
                    case R.id.nav_thongke:
                        fragmenClass = ThongkeFragment.class;
                        break;
                    case R.id.nav_dangxuat:
                        dangXuat();
                        break;
                    case R.id.nav_dangky:
                        dangky();
                        break;
                    case R.id.nav_thanhLi:
                        fragmenClass = Fragment_ThanhLiPhong.class;
                        break;

                    default:
                        fragmenClass = Home_Fragment.class;
                        break;
                }

                try {
                    fragment =(Fragment) fragmenClass.newInstance();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_main , fragment).commit();
                    setTitle(item.getTitle());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }catch (Exception exception){

                }
                return true;
            }
        });

        SharedPreferences share = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        String name = share.getString("name", "");
        String phone = share.getString("phone", "");
        tvName.setText("" + name);
        tvPhone.setText(""+phone);
    }
public void dangXuat() {
    Intent intent = new Intent(MainActivity.this, DangNhap.class);
    startActivity(intent);
    Toast.makeText(this, "Đăng Xuất Thành Công", Toast.LENGTH_SHORT).show();
}
public void dangky(){
        Intent intent = new Intent(MainActivity.this , DangKi.class);
        startActivity(intent);
    Toast.makeText(this, "Đăng Ký", Toast.LENGTH_SHORT).show();
 }

}