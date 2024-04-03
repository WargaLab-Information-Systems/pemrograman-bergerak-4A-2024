package com.example.modul2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_beranda)

        val btnClick: ImageView = findViewById(R.id.klik)
        btnClick.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.klik -> {
                    val pindah = Intent(this,MainActivity3::class.java)
                    startActivity(pindah)
                }
            }
        }
    }
}
