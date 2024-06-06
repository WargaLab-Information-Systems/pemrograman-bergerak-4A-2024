package com.example.tugasmodul6

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.tugasmodul6.remote.Player
import com.google.android.material.imageview.ShapeableImageView

class DetailPlayerActivity : AppCompatActivity(){
    // Fungsi ini dipanggil saat activity dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        // Mengatur layout untuk activity ini
        setContentView(R.layout.detail_player)

        val iconBackDetail = findViewById<ImageView>(R.id.btn_back_white)
        iconBackDetail.setOnClickListener {
            finish()
        }

        // Mendapatkan data makanan dari intent
        val getData = intent.getParcelableExtra<Player>("players")!!

        // Menghubungkan variabel dengan komponen di layout

        val playerBackground = findViewById<ShapeableImageView>(R.id.shapeableImageView2)
        val clubLogo = findViewById<ImageView>(R.id.detail_club_logo)
        val playerImage = findViewById<ImageView>(R.id.detail_player_image)

        val playerName = findViewById<TextView>(R.id.detail_player_name)
        val playerNumber = findViewById<TextView>(R.id.detail_player_number)
        val playerGoals = findViewById<TextView>(R.id.detail_player_goals)
        val playerAssists = findViewById<TextView>(R.id.detail_player_assist)
        val playerRatings = findViewById<TextView>(R.id.detail_player_rating)
        val playerPosition = findViewById<TextView>(R.id.detail_player_position)
        val playerDesc = findViewById<TextView>(R.id.detail_player_desc)

        // Menggunakan library Glide untuk memuat gambar dari URL dan menampilkannya di ImageView
        Glide.with(this)
            .load(getData.background_card)
            .into(playerBackground)

        Glide.with(this)
            .load(getData.club_logo)
            .into(clubLogo)

        Glide.with(this)
            .load(getData.player_image)
            .into(playerImage)

        // Mengatur teks untuk nama dan deskripsi makanan
        playerName.text = splitPlayerName(getData.name)
        playerNumber.text = "#" + getData.number.toString()
        playerGoals.text = getData.goals.toString()
        playerAssists.text = getData.assists.toString()
        playerRatings.text = getData.rating.toString()
        playerPosition.text = getData.position
        playerDesc.text = getData.description
    }

    private fun splitPlayerName(name: String): String {
        return if (name.contains(" ")) {
            name.replaceFirst(" ", "\n")
        } else {
            name
        }
    }
}