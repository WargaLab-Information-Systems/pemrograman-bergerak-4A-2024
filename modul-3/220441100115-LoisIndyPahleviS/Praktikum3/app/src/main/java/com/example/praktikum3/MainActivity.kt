package com.example.praktikum3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.praktikum3.adapter.AdapterGrid
import com.example.praktikum3.adapter.AdapterHotel
import com.example.praktikum3.data.HotelData
import com.example.praktikum3.data.HotelList
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    // Deklarasi variabel untuk adapter dan RecyclerView
    private lateinit var hotelAdapter: AdapterHotel
    private lateinit var playerAdapterGrid: AdapterGrid
    private lateinit var playerAdapterHorizontal: AdapterHotel
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
        hotelAdapter = AdapterHotel(HotelList.Data)
        playerAdapterGrid = AdapterGrid(HotelList.Grid)

        // Menampilkan RecyclerView
        showRecyclerList()
    }

    fun Ini(view: View) {
        val intent = Intent(this, HotPlace::class.java)
        startActivity(intent)
    }
    fun Ini2(view: View) {
        val intent = Intent(this, BestHotel::class.java)
        startActivity(intent)
    }

    // Fungsi untuk menampilkan RecyclerView Default
    private fun showRecyclerList() {
        // Mengatur GridLayoutManager dengan 2 kolom untuk RecyclerView
        val layoutManager = GridLayoutManager(this, 2)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = playerAdapterGrid

        recyclerviewHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewHorizontal.adapter = hotelAdapter

        hotelAdapter.setOnItemClickCallback(object : AdapterHotel.OnItemClickCallback {
            override fun onItemClicked(data: HotelData) {
                showSelectedPlayer(data)
            }
        })

        playerAdapterGrid.setOnItemClickCallback(object : AdapterGrid.OnItemClickCallback {
            override fun onItemClicked(data: HotelData) {
                showSelectedPlayer(data)
            }
        })
    }

    private fun showSelectedPlayer(data: HotelData) {
        val navigateToDetail = Intent(this, detail::class.java)
        navigateToDetail.putExtra("name", data.name)
        navigateToDetail.putExtra("description", data.description)
        navigateToDetail.putExtra("image", data.image)
        navigateToDetail.putExtra("tempat", data.tempat)
        startActivity(navigateToDetail)
    }
}