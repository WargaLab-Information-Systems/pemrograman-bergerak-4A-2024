package com.vinz.latihanrecyclerview1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.vinz.latihanrecyclerview1.adapter.PlayerAdapter
import com.vinz.latihanrecyclerview1.adapter.PlayerAdapterGrid
import com.vinz.latihanrecyclerview1.data.PlaceData
import com.vinz.latihanrecyclerview1.data.PlayerDataList

class MainActivity : AppCompatActivity() {

    // Deklarasi variabel untuk adapter dan RecyclerView
    private lateinit var playerAdapter: PlayerAdapter
    private lateinit var playerAdapterGrid: PlayerAdapterGrid
    private lateinit var playerAdapterHorizontal: PlayerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerviewHorizontal: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mengambil data nama dari intent
        val getDataName = intent.getStringExtra("name")

        // Menampilkan teks sapaan dengan nama pengguna
        val displayTitle = findViewById<MaterialTextView>(R.id.greeting_text)
        displayTitle.text = "Halo, $getDataName"


        // Menghubungkan variabel dengan komponen di layout
        recyclerView = findViewById(R.id.rv_player)
        recyclerviewHorizontal = findViewById(R.id.rv_player_horizontal)

        // Menginisialisasi semua adapter dengan data
        playerAdapter = PlayerAdapter(PlayerDataList.placeDataStaggeredValues)
        playerAdapterGrid = PlayerAdapterGrid(PlayerDataList.placeDataStaggeredValues)
        playerAdapterHorizontal = PlayerAdapter(PlayerDataList.placeDataValues)

        // Menampilkan RecyclerView
        showRecyclerList()
    }

    // Fungsi untuk menampilkan RecyclerView Default
    private fun showRecyclerList() {

        recyclerView.layoutManager = GridLayoutManager(this, 2) // Mengubah menjadi GridLayoutManager dengan 2 kolom
        recyclerView.adapter = playerAdapterGrid

        // Mengatur layoutManager dan adapter untuk RecyclerView horizontal
        recyclerviewHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewHorizontal.adapter = playerAdapterHorizontal

        // Menetapkan aksi ketika item di RecyclerView diklik
        playerAdapter.setOnItemClickCallback(object : PlayerAdapter.OnItemClickCallback {
            override fun onItemClicked(data: PlaceData) {
                showSelectedPlayer(data)
            }
        })

        playerAdapterGrid.setOnItemClickCallback(object : PlayerAdapterGrid.OnItemClickCallback {
            override fun onItemClicked(data: PlaceData) {
                showSelectedPlayer(data)
            }
        })



        playerAdapterHorizontal.setOnItemClickCallback(object : PlayerAdapter.OnItemClickCallback {
            override fun onItemClicked(data: PlaceData) {
                showSelectedPlayer(data)
            }
        })
    }

    // Fungsi untuk menampilkan detail pemain yang dipilih
    private fun showSelectedPlayer(data: PlaceData) {
        // Membuat intent untuk berpindah ke DetailPlayerActivity
        val navigateToDetail = Intent(this, DetailPlaceActivity::class.java)

        // Menambahkan dan membawa data pemain ke intent dengan tujuan ke DetailPlayerActivity
        navigateToDetail.putExtra("name", data.name)
        navigateToDetail.putExtra("description", data.description)
        navigateToDetail.putExtra("image", data.image)

        // Memulai activity baru
        startActivity(navigateToDetail)
    }
}