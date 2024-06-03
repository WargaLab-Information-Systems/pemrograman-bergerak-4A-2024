package com.example.modul6pember

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul6pember.adapter.MainAdapter
import com.example.modul6pember.api.APIResponse
import com.example.modul6pember.api.PlayerViewModel
import com.example.modul6pember.api.ViewModelFactory
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {
    // Mendeklarasikan variabel untuk ViewModel
    private lateinit var exampleViewModel: PlayerViewModel
    // Mendeklarasikan variabel untuk adapter RecyclerView
    private lateinit var adapter: MainAdapter
    // Mendeklarasikan variabel untuk RecyclerView
    private lateinit var recyclerView: RecyclerView

    // Fungsi ini dipanggil saat activity dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Membuat instance dari ViewModel
        val factory = ViewModelFactory.getInstance()
        exampleViewModel = ViewModelProvider(this, factory)[PlayerViewModel::class.java]

        // Menghubungkan variabel recyclerView dengan komponen di layout
        recyclerView = findViewById(R.id.rv_player)
        // Mengatur layoutManager untuk recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Memanggil fungsi untuk mendapatkan semua pemain
        exampleViewModel.getAllPlayer()
        // Mengamati data pemain dari ViewModel
        exampleViewModel.listPlayer.observe(this) { listPlayer ->
            if (listPlayer != null && listPlayer.isNotEmpty()) {
                adapter = MainAdapter(listPlayer)
                recyclerView.adapter = adapter

                // Set up item click callback
                adapter.setOnItemClickCallback(object : MainAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: APIResponse) {
                        showSelectedPlayer(data)
                    }
                })
            }
        }

        // Mengamati data pemain dari ViewModel
        exampleViewModel.player.observe(this) { player ->
            // Jika player tidak null, memanggil fungsi untuk mendapatkan semua pemain
            if (player != null) {
                exampleViewModel.getAllPlayer()
            }
        }

        // Mengamati status loading dari ViewModel
        exampleViewModel.isLoading.observe(this) {
            // Menampilkan atau menyembunyikan loading berdasarkan status loading
            showLoading(it)
        }

        // aksi foto profil diklik
        val btnProfil = findViewById<ShapeableImageView>(R.id.profil)
        btnProfil.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }

    // Fungsi untuk menampilkan atau menyembunyikan loading
    private fun showLoading(isLoading: Boolean) {
        val loading = findViewById<ProgressBar>(R.id.progressBar)
        // Jika isLoading true, tampilkan loading. Jika false, sembunyikan loading
        loading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    // Fungsi untuk menampilkan pemain yang dipilih
    private fun showSelectedPlayer(data: APIResponse) {
        // Membuat intent untuk berpindah ke DetailPlayerActivity
        val navigateToDetail = Intent(this, Detail::class.java)

        // Menambahkan data pemain ke intent
        navigateToDetail.putExtra("playerAPI", data)

        // Memulai activity baru
        startActivity(navigateToDetail)
    }


    // Fungsi ini dipanggil saat activity di restart
    override fun onRestart() {
        super.onRestart()
        // Memanggil fungsi untuk mendapatkan semua pemain
        exampleViewModel.getAllPlayer()
    }
}