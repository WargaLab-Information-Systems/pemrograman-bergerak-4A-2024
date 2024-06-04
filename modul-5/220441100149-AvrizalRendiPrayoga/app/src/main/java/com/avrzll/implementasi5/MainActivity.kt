package com.avrzll.implementasi5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avrzll.implementasi5.adapter.PostAdapterRoom
import com.avrzll.implementasi5.room.PostDatabase
import com.avrzll.implementasi5.room.PostViewModel
import com.avrzll.implementasi5.room.PostViewModelFactory

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
                        override fun onItemMore(data: PostDatabase) {
                        PopUpPracticeFragment(data).show(supportFragmentManager, PopUpPracticeFragment.TAG)
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