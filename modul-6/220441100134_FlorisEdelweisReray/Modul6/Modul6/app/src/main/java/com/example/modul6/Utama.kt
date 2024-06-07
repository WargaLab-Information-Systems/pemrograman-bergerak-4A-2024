package com.example.modul6

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul6.adapter.mediaAdapter
import com.example.modul6.data.api.PlayerViewModel
import com.example.modul6.data.api.ViewModelFactory
import com.example.modul6.data.mediaData

class Utama : AppCompatActivity() {

    private lateinit var playerViewModel: PlayerViewModel
    private lateinit var adapter: mediaAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_utama)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
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
                adapter = mediaAdapter(player)
                recyclerView.adapter = adapter
                adapter.setOnItemClickCallback(object :
                    mediaAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: mediaData) {
                        showSelectedPlayer(data)
                    }
                })
            }
        }
    }

    fun author(view: View) {
        val intent = Intent(view.context, Kreator::class.java)
        view.context.startActivity(intent)
    }

    private fun showSelectedPlayer(data: mediaData) {
        val navigateToDetail = Intent(this, Data_Pemain::class.java)
        navigateToDetail.putExtra("player", data)
        startActivity(navigateToDetail)
    }
}