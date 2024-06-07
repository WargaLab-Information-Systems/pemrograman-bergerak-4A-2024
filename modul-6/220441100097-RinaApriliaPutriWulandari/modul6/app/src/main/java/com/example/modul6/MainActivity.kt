package com.example.modul6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul6.adapter.PlayerAdapter
import com.example.modul6.data.PlayerData
import com.example.modul6.data.api.PlayerViewModel
import com.example.modul6.data.api.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var playerViewModel: PlayerViewModel
    private lateinit var adapter: PlayerAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val factory = ViewModelFactory.getInstance()
        playerViewModel = ViewModelProvider(this, factory)[PlayerViewModel::class.java]
        recyclerView = findViewById(R.id.rv_pemain)
        recyclerView.layoutManager = LinearLayoutManager(this)
        playerViewModel.getAllPlayer()
        playerViewModel.listPlayer.observe(this) { player ->
            if (player.isNotEmpty()) {
                adapter = PlayerAdapter(player)
                recyclerView.adapter = adapter
                adapter.setOnItemClickCallback(object :
                    PlayerAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: PlayerData) {
                        showSelectedPlayer(data)
                    }
                })
            }
        }
    }

    fun author(view: View) {
        val intent = Intent(view.context, Author::class.java)
        view.context.startActivity(intent)
    }

    private fun showSelectedPlayer(data: PlayerData) {
        val navigateToDetail = Intent(this, DetailPemain::class.java)
        navigateToDetail.putExtra("player", data)
        startActivity(navigateToDetail)
    }
}