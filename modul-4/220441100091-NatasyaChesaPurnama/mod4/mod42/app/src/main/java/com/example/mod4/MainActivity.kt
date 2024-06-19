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
    private lateinit var appViewModel: PostViewModel
    private lateinit var postAdapterRoom: PostAdapterRoom
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val factory = PostViewModelFactory.getInstance(this)
        appViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]
        recyclerView = findViewById(R.id.itemlayout)
        recyclerView.layoutManager = LinearLayoutManager(this)
        appViewModel.getAllPlayer().observe(this) { playerData ->
            if (playerData != null) {
                postAdapterRoom = PostAdapterRoom(playerData)
                recyclerView.adapter = postAdapterRoom

                postAdapterRoom.setOnItemClickCallback(object :
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

    override fun onRestart() {
        super.onRestart()

        appViewModel.getAllPlayer()
    }
}
