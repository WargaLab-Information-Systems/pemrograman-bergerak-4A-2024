package com.example.tugaspraktikummodul2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMove: Button = findViewById(R.id.btn_lanjut)
        buttonMove.setOnClickListener {
            // Pindah ke Activity Kedua
            val intent = Intent(this@MainActivity, HomePage::class.java)
            startActivity(intent)
        }
    }
}