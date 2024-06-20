package com.example.a039bunga_modul6

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
import com.example.a039bunga_modul6.adapter.playerAdapter
import com.example.a039bunga_modul6.data.api.PlayerViewModel
import com.example.a039bunga_modul6.data.api.ViewModelFactory
import com.example.a039bunga_modul6.data.playerData

class MainActivity : AppCompatActivity() {

    private lateinit var playerViewModel: PlayerViewModel
    private lateinit var adapter: playerAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_beranda)
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
                adapter = playerAdapter(player)
                recyclerView.adapter = adapter
                adapter.setOnItemClickCallback(object :
                    playerAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: playerData) {
                        showSelectedPlayer(data)
                    }
                })
            }
        }
    }

    fun author(view: View) {
        val intent = Intent(view.context, Profil::class.java)
        view.context.startActivity(intent)
    }

    private fun showSelectedPlayer(data: playerData) {
        val navigateToDetail = Intent(this, DetailPemain::class.java)
        navigateToDetail.putExtra("player", data)
        startActivity(navigateToDetail)
    }
}