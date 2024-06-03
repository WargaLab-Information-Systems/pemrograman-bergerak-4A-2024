package com.example.modul6pember.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    // Fungsi ini digunakan untuk mendapatkan semua pemain sepak bola
    @GET("tugas")
    fun getAllPlayers(): Call<PlayerResponse>
}