package com.example.latihanrecyclerviewpraktikum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        usernameInput = findViewById(R.id.iusername)
        passwordInput = findViewById(R.id.ipass)

        val loginBtn = findViewById<Button>(R.id.blogin)

        loginBtn.setOnClickListener {
            if (validateInput()) {
                val intent = Intent(this, HomePage::class.java)
                intent.putExtra("nama", usernameInput.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Tolong masukkan inputan dengan benar!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun validateInput() : Boolean{
        var error = 0
        if(usernameInput.text.toString().isEmpty()) {
            error++
            usernameInput.error = "Tolong masukkan username kamu!"
        }
        if (passwordInput.text.toString().isEmpty()) {
            error++
            passwordInput.error = "Tolong masukkan password kamu!"
        }
        return error == 0
    }
}