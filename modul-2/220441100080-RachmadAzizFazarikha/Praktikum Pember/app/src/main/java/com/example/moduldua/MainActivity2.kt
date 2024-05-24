package com.example.moduldua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beranda)

        val btnClick: ImageButton = findViewById(R.id.imageButton)

        btnClick.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v != null ){
            when(v.id){
                R.id.imageButton -> {
                    val pindah = Intent(this,MainActivity3::class.java)
                    startActivity(pindah)
                }
            }
        }

    }
}