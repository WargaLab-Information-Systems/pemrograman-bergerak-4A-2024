package com.example.modul6

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.modul6.data.mediaData

class Data_Pemain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_pemain)

        val getData = intent.getParcelableExtra<mediaData>("player")!!

        val playerName: TextView = findViewById(R.id.nama_pemain)
        val playerNumber: TextView = findViewById(R.id.num_pemain)

        val playerGoals: TextView = findViewById(R.id.goal_pemain)
        val playerAssists: TextView = findViewById(R.id.assists_pemain)
        val playerRating: TextView = findViewById(R.id.rating_pemain)
        val playerPosition: TextView = findViewById(R.id.posisi_pemain)
        val playerDesc: TextView = findViewById(R.id.deskripsi_pemain)

        val playerClubLogo: ImageView = findViewById(R.id.logo_club)
        val playerImage: ImageView = findViewById(R.id.img_pemain)
        val background: ImageView = findViewById(R.id.bg)

        playerName.text = getData.name
        playerNumber.text = "#"+getData.number.toString()

        playerGoals.text = getData.goals.toString()
        playerDesc.text = getData.description
        playerAssists.text = getData.assists.toString()
        playerPosition.text = getData.position
        playerRating.text = getData.rating.toString()

        Glide.with(playerClubLogo.context).load(getData.club_logo).into(playerClubLogo)
        Glide.with(playerImage.context).load(getData.player_image).into(playerImage)
        Glide.with(background.context).load(getData.background_card).into(background)
    }

    fun balik(view: View) {
        val intent = Intent(view.context, Utama::class.java)
        view.context.startActivity(intent)
    }
}