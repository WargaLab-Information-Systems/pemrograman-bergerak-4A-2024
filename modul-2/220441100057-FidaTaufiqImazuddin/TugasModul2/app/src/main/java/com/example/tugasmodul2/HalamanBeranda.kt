package com.example.tugasmodul2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class HalamanBeranda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_beranda)

        val appAuthor = findViewById<ImageButton>(R.id.logo_utm)
        appAuthor.setOnClickListener{
            val intent = Intent(this,HalamanProfile::class.java)
            startActivity(intent)
        }
    }
}