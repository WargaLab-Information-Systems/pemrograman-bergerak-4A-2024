package com.example.a22_039_bungaayusaputri

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameInput = findViewById(R.id.uusername)
        passwordInput = findViewById(R.id.passwordd)

        val loginBtn = findViewById<Button>(R.id.blogin)

        loginBtn.setOnClickListener {
            if (validateInput()) {
                val intent = Intent(this, Beranda1::class.java)
                intent.putExtra("nama", usernameInput.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Masukkan inputan dengan benar!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun validateInput() : Boolean{
        var error = 0
        if(usernameInput.text.toString().isEmpty()) {
            error++
            usernameInput.error = "Masukkan username terlebih dahulu!"
        }
        if (passwordInput.text.toString().isEmpty()) {
            error++
            passwordInput.error = "Masukkan password terlebih dahulu!"
        }
        return error == 0
    }
}