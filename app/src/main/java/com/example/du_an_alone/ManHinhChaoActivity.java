package com.example.du_an_alone;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_alone.Function_Login.DangNhap;

public class ManHinhChaoActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chao);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.sound_);
        mediaPlayer.start();
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(ManHinhChaoActivity.this , DangNhap.class));
        }
    },3000);
    }
}