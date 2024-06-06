package com.example.tugasmodul6

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView

class AuthorActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.author)

        val iconBackCreator = findViewById<ImageButton>(R.id.imageButton)
        iconBackCreator.setOnClickListener {
            finish()
        }
    }
}