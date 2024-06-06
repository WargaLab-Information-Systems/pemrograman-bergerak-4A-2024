package com.example.uts;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.media.MediaPlayer;
public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    @Override
    protected void onResume() {
        super.onResume();
        // Memulai pemutaran lagu hanya jika belum dimulai sebelumnya
        if (!isPlaying) {
            mediaPlayer = MediaPlayer.create(this, R.raw.lagu);
            mediaPlayer.start();
            isPlaying = true;
        }
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        // Menghentikan pemutaran lagu saat tombol kembali ditekan
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            isPlaying = false;
        }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Melepaskan sumber daya MediaPlayer
            mediaPlayer = null;
        }
    }
    public void halaman2(View view) {
        Intent intent = new Intent(MainActivity.this,halaman2.class);
        startActivity(intent);
    }
}
