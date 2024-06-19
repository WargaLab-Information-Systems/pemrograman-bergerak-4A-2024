package com.example.modul3

import android.content.Intent
import android.widget.TextView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul3.Adapter.ItemGrid
import com.example.modul3.Adapter.ItemHorizontal
import com.example.modul3.Data.DataWisata
import com.example.modul3.Data.DataHotel
import com.example.modul3.Data.ListItem

class Beranda: AppCompatActivity() {
    private lateinit var itemGrid: ItemGrid
    private lateinit var itemHorizontal: ItemHorizontal
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerviewHorizontal: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        val getDataName = intent.getStringExtra("nama")
        val displayTitle = findViewById<TextView>(R.id.uname)
        displayTitle.text = "Halo, $getDataName"

        recyclerView = findViewById(R.id.hotel)
        recyclerviewHorizontal = findViewById(R.id.wisata)
        itemGrid = ItemGrid(ListItem.DataHotel)
        itemHorizontal = ItemHorizontal(ListItem.DataWisata)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemHorizontal

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = itemGrid

        recyclerviewHorizontal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewHorizontal.adapter = itemHorizontal

        itemGrid.setOnItemClickCallback(object : ItemGrid.OnItemClickCallback {
            override fun onItemClicked(data: DataHotel) {
                showHotel(data)
            }
        })

        itemHorizontal.setOnItemClickCallback(object : ItemHorizontal.OnItemClickCallback {
            override fun onItemClicked(data: DataWisata) {
                showWisata(data)
            }
        })
    }

    private fun showWisata(data: DataWisata) {
        val navigateToDetail = Intent(this, Beranda2::class.java)
        navigateToDetail.putExtra("nama", data.namaTempat)
        navigateToDetail.putExtra("deskripsi", data.deskripsiTempat)
        navigateToDetail.putExtra("gambar", data.gambar)
        startActivity(navigateToDetail)
    }

    private fun showHotel(data: DataHotel) {
        val navigateToDetail = Intent(this, Beranda2::class.java)
        navigateToDetail.putExtra("nama", data.namaHotel)
        navigateToDetail.putExtra("deskripsi", data.deskripsi)
        navigateToDetail.putExtra("gambar", data.gambar)
        startActivity(navigateToDetail)
    }
}