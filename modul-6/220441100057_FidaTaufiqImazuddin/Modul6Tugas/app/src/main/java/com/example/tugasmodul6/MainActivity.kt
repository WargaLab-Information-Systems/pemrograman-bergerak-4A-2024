package com.example.tugasmodul6

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasmodul6.remote.Player
import com.example.tugasmodul6.remote.PlayerViewModel
import com.example.tugasmodul6.remote.PlayerViewModelFactory
import com.google.android.material.imageview.ShapeableImageView


class MainActivity : AppCompatActivity() {

    private lateinit var playerViewModel: PlayerViewModel
    private lateinit var adapter: PlayerAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageProfile = findViewById<ShapeableImageView>(R.id.icon_user)
        imageProfile.setOnClickListener {
            val intent = Intent(this, AuthorActivity::class.java)
            startActivity(intent)
        }

        val factory = PlayerViewModelFactory.getInstance()
        playerViewModel = ViewModelProvider(this, factory)[PlayerViewModel::class.java]

        recyclerView = findViewById(R.id.rv_player_retrofit)
        recyclerView.layoutManager = LinearLayoutManager(this)

        playerViewModel.getAllPlayer()
        playerViewModel.listPlayer.observe(this) { player ->
            if (player.isNotEmpty()) {
                adapter = PlayerAdapter(player)
                recyclerView.adapter = adapter

                adapter.setOnItemClickCallback(object :
                    PlayerAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: Player) {
                        showSelectedPlayer(data)
                    }
                })
            }
        }

    }

    private fun showSelectedPlayer(data: Player) {
        val navigateToDetail = Intent(this, DetailPlayerActivity::class.java)
        navigateToDetail.putExtra("players", data)
        startActivity(navigateToDetail)
    }
}


