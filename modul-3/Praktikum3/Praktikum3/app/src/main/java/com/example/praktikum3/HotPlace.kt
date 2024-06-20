package com.example.praktikum3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.praktikum3.adapter.AdapterGrid
import com.example.praktikum3.adapter.AdapterHotel
import com.example.praktikum3.data.HotelData
import com.example.praktikum3.data.HotelList

class HotPlace : AppCompatActivity() {

    // Deklarasi variabel untuk adapter dan RecyclerView
    private lateinit var hotelAdapter: AdapterHotel
    private lateinit var playerAdapterGrid: AdapterGrid
    //    private lateinit var playerAdapterStaggered: PlayerAdapterStaggered
    private lateinit var playerAdapterHorizontal: AdapterHotel
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerviewHorizontal: RecyclerView
//    private lateinit var btnChangeRecyclerView: Button
//    private var changeRV = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_place)


        recyclerView = findViewById(R.id.rv_player)
        hotelAdapter = AdapterHotel(HotelList.Data)

        showRecyclerList()



    }

    private fun showRecyclerList() {
        // Mengatur GridLayoutManager dengan 2 kolom untuk RecyclerView
        val layoutManager = GridLayoutManager(this, 1)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = hotelAdapter

//        recyclerviewHorizontal.layoutManager = layoutMan

        hotelAdapter.setOnItemClickCallback(object : AdapterHotel.OnItemClickCallback {
            override fun onItemClicked(data: HotelData) {
                showSelectedPlayer(data)
            }
        })

//        playerAdapterGrid.setOnItemClickCallback(object : AdapterGrid.OnItemClickCallback {
//            override fun onItemClicked(data: HotelData) {
//                showSelectedPlayer(data)
//            }
//        })
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