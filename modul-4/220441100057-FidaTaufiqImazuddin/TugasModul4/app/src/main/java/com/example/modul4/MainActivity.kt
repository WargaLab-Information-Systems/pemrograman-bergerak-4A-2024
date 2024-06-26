package com.example.modul4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul4.adapter.PostAdapterRoom
import com.example.modul4.room.PostDatabase
import com.example.modul4.room.PostViewModel
import com.example.modul4.room.PostViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var postAdapterRoom: PostAdapterRoom
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = PostViewModelFactory.getInstance(this)
        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]
        recyclerView = findViewById(R.id.rv_post)
        recyclerView.layoutManager = LinearLayoutManager(this)

        postViewModel.getAllPost().observe(this) { postData ->
            if (postData != null) {
                postAdapterRoom = PostAdapterRoom(postData)
                recyclerView.adapter = postAdapterRoom

                postAdapterRoom.setOnItemClickCallback(object :
                    PostAdapterRoom.OnItemClickCallback {
                    override fun onItemClicked(data: PostDatabase) {
                    }
                })
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        postViewModel.getAllPost()
    }

    fun toAddPost(view: View) {
        val intent = Intent(this, AddPostActivity::class.java)
        startActivity(intent)
    }
}