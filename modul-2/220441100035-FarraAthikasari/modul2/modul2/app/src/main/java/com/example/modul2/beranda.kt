package com.example.modul2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class beranda : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        val btnClick: ImageView = findViewById(R.id.image_kembali)
        btnClick.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.image_kembali -> {
                val pindah = Intent(this, profile::class.java)
                startActivity(pindah)
            }
        }
    }
}
