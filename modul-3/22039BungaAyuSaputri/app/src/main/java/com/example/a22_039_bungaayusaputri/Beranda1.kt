package com.example.a22_039_bungaayusaputri


import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a22_039_bungaayusaputri.Adapter.ItemGrid
import com.example.a22_039_bungaayusaputri.Adapter.ItemHorizontal
import com.example.a22_039_bungaayusaputri.Data.Hotel
import com.example.a22_039_bungaayusaputri.Data.Wisata
import com.example.a22_039_bungaayusaputri.Data.ListItem

class Beranda1: AppCompatActivity() {

    private lateinit var itemGrid: ItemGrid
    private lateinit var itemHorizontal: ItemHorizontal
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerviewHorizontal: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda1)

        val getDataName = intent.getStringExtra("nama")
        val displayTitle = findViewById<TextView>(R.id.username)
        displayTitle.text = "Halo, $getDataName"

        recyclerView = findViewById(R.id.hotel)
        recyclerviewHorizontal = findViewById(R.id.wisata)
        itemGrid = ItemGrid(ListItem.Hotel)
        itemHorizontal = ItemHorizontal(ListItem.Wisata)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemHorizontal

        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = itemGrid

        recyclerviewHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewHorizontal.adapter = itemHorizontal

        itemGrid.setOnItemClickCallback(object : ItemGrid.OnItemClickCallback {
            override fun onItemClicked(data: Hotel) {
                showHotel(data)
            }
        })

        itemHorizontal.setOnItemClickCallback(object : ItemHorizontal.OnItemClickCallback {
            override fun onItemClicked(data: Wisata) {
                showWisata(data)
            }
        })
    }

    private fun showWisata(data: Wisata) {
        val navigateToDetail = Intent(this, Beranda2::class.java)
        navigateToDetail.putExtra("nama", data.namatempat)
        navigateToDetail.putExtra("deskripsi", data.deskripsitempat)
        navigateToDetail.putExtra("gambar", data.gambar)
        startActivity(navigateToDetail)
    }

    private fun showHotel(data: Hotel) {
        val navigateToDetail = Intent(this, Beranda2::class.java)
        navigateToDetail.putExtra("nama", data.namahotel)
        navigateToDetail.putExtra("deskripsi", data.deskripsi)
        navigateToDetail.putExtra("gambar", data.gambar)
        startActivity(navigateToDetail)
    }
}