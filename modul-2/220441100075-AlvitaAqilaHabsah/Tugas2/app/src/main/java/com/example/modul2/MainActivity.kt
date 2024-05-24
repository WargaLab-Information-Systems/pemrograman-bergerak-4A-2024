package com.example.modul2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editTextNama: EditText
    private lateinit var buttonLanjut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Inisialisasi views
        editTextNama = findViewById(R.id.editTextText)
        buttonLanjut = findViewById(R.id.app_author)

        // Menambahkan onClickListener pada tombol "Lanjut"
        buttonLanjut.setOnClickListener {
            // Memeriksa apakah pengguna telah memasukkan nama
            val nama = editTextNama.text.toString().trim()
            if (nama.isNotEmpty()) {
                // Jika nama telah dimasukkan, navigasi ke aktivitas berikutnya
                navigateToNextActivity(nama)
            } else {
                // Jika nama belum dimasukkan, tampilkan pesan kesalahan
                editTextNama.error = "Masukkan nama Anda"
            }
        }
    }

    private fun navigateToNextActivity(nama: String) {
        // Menyiapkan Intent untuk navigasi ke aktivitas berikutnya
        val intent = Intent(this, BerandaActivity::class.java)
        // Menambahkan data nama ke Intent
        intent.putExtra("nama", nama)
        // Memulai aktivitas berikutnya
        startActivity(intent)
        // Mengakhiri aktivitas saat ini (opsional, tergantung pada kebutuhan Anda)
        finish()
    }
}