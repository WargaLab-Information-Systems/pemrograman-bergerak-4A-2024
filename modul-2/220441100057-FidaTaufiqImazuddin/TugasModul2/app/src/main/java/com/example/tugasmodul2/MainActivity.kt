package com.example.tugasmodul2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hhalamanBeranda = findViewById<MaterialButton>(R.id.login_btn)
        hhalamanBeranda.setOnClickListener{
            val intent = Intent(this,HalamanBeranda::class.java)
            startActivity(intent)
        }
    }
}