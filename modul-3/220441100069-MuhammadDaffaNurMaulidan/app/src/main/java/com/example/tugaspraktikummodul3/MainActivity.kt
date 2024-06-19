package com.example.tugaspraktikummodul3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspraktikummodul3.adapter.WisataAdapter
import com.example.tugaspraktikummodul3.adapter.WisataAdapterGrid
import com.example.tugaspraktikummodul3.data.DataHotel
import com.example.tugaspraktikummodul3.data.DataWisata
import com.example.tugaspraktikummodul3.data.WisataDataList
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    // Deklarasi variabel untuk adapter dan RecyclerView
    private lateinit var wisataAdapterHorizontal: WisataAdapter
    private  lateinit var wisataAdaptergrid: WisataAdapterGrid
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
        recyclerView = findViewById(R.id.rv_wisata)
        recyclerviewHorizontal = findViewById(R.id.rv_wisata_horizontal)

        // Menginisialisasi semua adapter dengan data
        wisataAdapterHorizontal = WisataAdapter(WisataDataList.WisataDataValue)
        wisataAdaptergrid = WisataAdapterGrid(WisataDataList.dataHotelValue)

        // Menampilkan RecyclerView
        showRecyclerList()

    }
    // Fungsi untuk menampilkan RecyclerView Default
    private fun showRecyclerList() {
        // Mengatur layoutManager dan adapter untuk RecyclerView
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = wisataAdaptergrid

        // Mengatur layoutManager dan adapter untuk RecyclerView horizontal
        recyclerviewHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewHorizontal.adapter = wisataAdapterHorizontal

        // Menetapkan aksi ketika item di RecyclerView diklik
        wisataAdapterHorizontal.setOnItemClickCallback(object : WisataAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DataWisata) {
                showSelectedWisata(data)
            }
        })
        // Menetapkan aksi ketika item di RecyclerView diklik
        wisataAdaptergrid.setOnItemClickCallback(object : WisataAdapterGrid.OnItemClickCallback {
            override fun onItemClicked(data: DataHotel) {
                showSelectedWisata1(data)
            }
        })
    }

    // Fungsi untuk menampilkan detail wisata yang dipilih
    private fun showSelectedWisata(data: DataWisata) {
        // Membuat intent untuk berpindah ke DetailwisataActivity
        val navigateToDetail = Intent(this, DetailActivityWisata::class.java)

        // Menambahkan dan membawa data wisata ke intent dengan tujuan ke DetailwisataActivity
        navigateToDetail.putExtra("name", data.name)
        navigateToDetail.putExtra("image", data.image)
        navigateToDetail.putExtra("description", data.deskripsi)
        // Memulai activity baru
        startActivity(navigateToDetail)
    }
    // Fungsi untuk menampilkan detail pemain yang dipilih
    private fun showSelectedWisata1(data: DataHotel) {
        // Membuat intent untuk berpindah ke DetailwisataActivity
        val navigateToDetail = Intent(this, DetailActivityWisata::class.java)

        // Menambahkan dan membawa data wisata ke intent dengan tujuan ke DetailwisataActivity
        navigateToDetail.putExtra("name", data.nama)
        navigateToDetail.putExtra("image", data.image)
        navigateToDetail.putExtra("description", data.deskripsi)
        // Memulai activity baru
        startActivity(navigateToDetail)
    }

}