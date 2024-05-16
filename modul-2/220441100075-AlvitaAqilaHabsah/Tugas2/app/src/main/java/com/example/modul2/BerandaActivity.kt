package com.example.modul2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class BerandaActivity : AppCompatActivity() {
    private lateinit var imageViewUTM: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)
        // Inisialisasi ImageView
        imageViewUTM = findViewById(R.id.imageView4)

        // Menambahkan onClickListener pada ImageView logo UTM
        imageViewUTM.setOnClickListener {
            // Memulai aktivitas profil
            navigateToProfilActivity()
        }
    }

    private fun navigateToProfilActivity() {
        // Menyiapkan Intent untuk berpindah ke aktivitas profil
        val intent = Intent(this, ProfilActivity::class.java)
        // Memulai aktivitas profil
        startActivity(intent)
    }
}