package com.example.mod4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mod4.adapter.PostAdapterRoom
import com.example.mod4.room.PostEntity
import com.example.mod4.room.PostViewModel
import com.example.mod4.room.PostViewModelFactory

class MainActivity : AppCompatActivity() {
    // Mendeklarasikan ViewModel untuk interaksi dengan database
    private lateinit var appViewModel: PostViewModel
    // Mendeklarasikan adapter untuk RecyclerView
    private lateinit var playerAdapterRoom: PostAdapterRoom
    // Mendeklarasikan RecyclerView untuk menampilkan daftar pemain
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Mendapatkan instance ViewModel
        val factory = PostViewModelFactory.getInstance(this)
        appViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]

        // Menghubungkan variabel dengan komponen di layout
        recyclerView = findViewById(R.id.itemlayout)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Mengamati perubahan data pemain dan memperbarui RecyclerView
        appViewModel.getAllPlayer().observe(this) { playerData ->
            if (playerData != null) {
                playerAdapterRoom = PostAdapterRoom(playerData)
                recyclerView.adapter = playerAdapterRoom

                // Menangani aksi klik pada item di RecyclerView
                playerAdapterRoom.setOnItemClickCallback(object :
                    PostAdapterRoom.OnItemClickCallback {
                    override fun onItemClicked(data: PostEntity) {
                    }
                })
            }
        }
    }

    fun postfeed(view: View) {
        val intent = Intent(this, Post_Feed::class.java)
        startActivity(intent)
    }
    // Fungsi yang dipanggil ketika activity di-restart
    override fun onRestart() {
        super.onRestart()

        // Memperbarui daftar pemain
        appViewModel.getAllPlayer()
    }
}
