package com.example.implementasimodul3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.implementasimodul3.adapter.HorizontalAdapter
import com.example.implementasimodul3.adapter.VerticalGridAdapter
import com.example.implementasimodul3.datamodel.DataList
import com.example.implementasimodul3.datamodel.HotelModel
import com.example.implementasimodul3.datamodel.PlaceModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mengambil data nama dari intent
        val getDataName = intent.getStringExtra("name")

        // Menampilkan teks sapaan dengan nama pengguna
        val displayTitle = findViewById<TextView>(R.id.greeting)
        displayTitle.text = "Halo, $getDataName 👋"

        val horizontalAdapter = HorizontalAdapter(DataList.places, object: HorizontalAdapter.OnAdapterListener {
            override fun onClick(place: PlaceModel) {
                val navigateToDetail = Intent(applicationContext, DetailActivity::class.java)
                navigateToDetail.putExtra("name", place.name)
                navigateToDetail.putExtra("description", place.description)
                navigateToDetail.putExtra("image", place.image)
                startActivity(navigateToDetail)
            }
        })
        findViewById<RecyclerView>(R.id.horizontalRv).adapter = horizontalAdapter

        val vertikalAdapter = VerticalGridAdapter(DataList.hotels, object: VerticalGridAdapter.OnAdapterListener {
            override fun onClick(hotel: HotelModel) {
                val navigateToDetail = Intent(applicationContext, DetailActivity::class.java)
                navigateToDetail.putExtra("name", hotel.name)
                navigateToDetail.putExtra("description", hotel.description)
                navigateToDetail.putExtra("image", hotel.image)
                startActivity(navigateToDetail)
            }
        })
        findViewById<RecyclerView>(R.id.vertikalGridRv).adapter = vertikalAdapter
    }

}