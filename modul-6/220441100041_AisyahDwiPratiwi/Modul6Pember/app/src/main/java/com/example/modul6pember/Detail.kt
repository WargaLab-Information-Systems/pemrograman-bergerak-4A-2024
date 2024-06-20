package com.example.modul6pember

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.modul6pember.api.APIResponse
import com.google.android.material.imageview.ShapeableImageView

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val getDataPlayerAPI = intent.getParcelableExtra<APIResponse>("playerAPI")

        // Menghubungkan variabel dengan komponen di layout
        val playerName = findViewById<TextView>(R.id.name)
        val playerDescription = findViewById<TextView>(R.id.description)
        val playerPosition = findViewById<TextView>(R.id.position)
        val playerGoal = findViewById<TextView>(R.id.goal)
        val playerAssists = findViewById<TextView>(R.id.assist)
        val playerNumber = findViewById<TextView>(R.id.number)
        val playerClub = findViewById<ShapeableImageView>(R.id.club_logo)
        val playerImage = findViewById<ShapeableImageView>(R.id.player_image)
        val playerBackground = findViewById<ShapeableImageView>(R.id.background)

        // Menampilkan data pemain
        when {
            getDataPlayerAPI != null -> {
                playerName.text = getDataPlayerAPI.name
                playerDescription.text = getDataPlayerAPI.description
                playerPosition.text = getDataPlayerAPI.position
                playerGoal.text = getDataPlayerAPI.goals.toString()
                playerAssists.text = getDataPlayerAPI.assists.toString()
                playerNumber.text = getDataPlayerAPI.number.toString()
                Glide.with(playerClub)
                    .load(getDataPlayerAPI.clublogo)
                    .into(playerClub)
                Glide.with(playerImage)
                    .load(getDataPlayerAPI.playerimage)
                    .into(playerImage)
                Glide.with(playerBackground)
                    .load(getDataPlayerAPI.backgroundcard)
                    .into(playerBackground)
            }
        }

        // aksi tombol kembali
        val btnKembali = findViewById<ImageView>(R.id.btn_kembali)
        btnKembali.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}