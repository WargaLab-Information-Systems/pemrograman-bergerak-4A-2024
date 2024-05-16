package com.example.latihanrecyclerviewpraktikum

import android.app.LauncherActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanrecyclerviewpraktikum.adapter.Grid
import com.example.latihanrecyclerviewpraktikum.adapter.Horizontal
import com.example.latihanrecyclerviewpraktikum.data.DataList
import com.example.latihanrecyclerviewpraktikum.data.HotelData
import com.example.latihanrecyclerviewpraktikum.data.TravelData

class HomePage : AppCompatActivity() {
    private lateinit var itemGrid: Grid
    private lateinit var itemHorizontal: Horizontal
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerviewHorizontal: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val getDataName = intent.getStringExtra("nama")
        val displayTitle = findViewById<TextView>(R.id.uname)
        displayTitle.text = "Halo, $getDataName"

        recyclerView = findViewById(R.id.hotel)
        recyclerviewHorizontal = findViewById(R.id.wisata)
        itemGrid = Grid(DataList.HotelData)
        itemHorizontal = Horizontal(DataList.TravelData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemHorizontal

        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = itemGrid

        recyclerviewHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewHorizontal.adapter = itemHorizontal

        itemGrid.setOnItemClickCallback(object : Grid.OnItemClickCallback {
            override fun onItemClicked(data: HotelData) {
                showHotel(data)
            }
        })

        itemHorizontal.setOnItemClickCallback(object : Horizontal.OnItemClickCallback {
            override fun onItemClicked(data: TravelData) {
                showWisata(data)
            }
        })
    }

    private fun showWisata(data: TravelData) {
        val navigateToDetail = Intent(this, HomePage2::class.java)
        navigateToDetail.putExtra("nama", data.NamaTempat)
        navigateToDetail.putExtra("deskripsi", data.DeskripsiTempat)
        navigateToDetail.putExtra("gambar", data.Gambar)
        startActivity(navigateToDetail)
    }

    private fun showHotel(data: HotelData) {
        val navigateToDetail = Intent(this, HomePage2::class.java)
        navigateToDetail.putExtra("nama", data.NamaHotel)
        navigateToDetail.putExtra("deskripsi", data.Deskripsi)
        navigateToDetail.putExtra("gambar", data.Gambar)
        startActivity(navigateToDetail)
    }
}