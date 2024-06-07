package com.example.a039bunga_modul6

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.a039bunga_modul6.data.playerData

class DetailPemain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.detail_pemain)

        val getData = intent.getParcelableExtra<playerData>("player")!!

        val namaplayer: TextView = findViewById(R.id.namapemain)
        val nomorplayer: TextView = findViewById(R.id.nomor)

        val goalplayer: TextView = findViewById(R.id.goalpemain)
        val assistpemain: TextView = findViewById(R.id.assistspemain)
        val ratingpemain: TextView = findViewById(R.id.ratingpemain)
        val posisipemain: TextView = findViewById(R.id.posisipemain)
        val deskripsipemain: TextView = findViewById(R.id.deskripsipemain)

        val logoclub: ImageView = findViewById(R.id.logo_club)
        val fotoplayer: ImageView = findViewById(R.id.fotoplayer)
        val background: ImageView = findViewById(R.id.bg)

        namaplayer.text = getData.name
        nomorplayer.text = "#"+getData.number.toString()

        goalplayer.text = getData.goals.toString()
        deskripsipemain.text = getData.description
        assistpemain.text = getData.assists.toString()
        posisipemain.text = getData.position
        ratingpemain.text = getData.rating.toString()

        Glide.with(logoclub.context).load(getData.club_logo).into(logoclub)
        Glide.with(fotoplayer.context).load(getData.player_image).into(fotoplayer)
        Glide.with(background.context).load(getData.background_card).into(background)
    }

    fun balik(view: View) {
        val intent = Intent(view.context, MainActivity::class.java)
        view.context.startActivity(intent)
    }
}