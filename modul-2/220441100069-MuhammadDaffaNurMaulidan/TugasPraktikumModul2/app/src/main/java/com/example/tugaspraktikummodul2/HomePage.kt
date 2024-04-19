package com.example.tugaspraktikummodul2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val profileButton: ImageButton = findViewById(R.id.logobtn)
        profileButton.setOnClickListener {
            // Pindah ke halaman profil
            val intent = Intent(this@HomePage, ProfilePage::class.java)
            startActivity(intent)
        }
    }
}