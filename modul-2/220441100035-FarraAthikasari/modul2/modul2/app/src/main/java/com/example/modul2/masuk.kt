package com.example.modul2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class masuk : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)      //memanggil implementasi
        setContentView(R.layout.activity_masuk)

        val btnClick: Button = findViewById (R.id.btn_lanjut)   //inialisasi untuk mencari view sesuai id
        btnClick.setOnClickListener(this)   //menmbahkan listener ke tmbl btn
    }

    override fun onClick(v: View?) {
        if(v != null ) {
            when (v.id) {       //seleksi
                R.id.btn_lanjut -> {
                    val pindah = Intent(this, beranda::class.java)
                    startActivity(pindah)
                }
            }
        }
    }

}
