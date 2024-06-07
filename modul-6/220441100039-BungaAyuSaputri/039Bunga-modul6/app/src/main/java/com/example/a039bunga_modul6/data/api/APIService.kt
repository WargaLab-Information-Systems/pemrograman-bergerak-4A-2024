package com.example.a039bunga_modul6.data.api

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("tugas")
    fun getAllPlayer(): Call<APIResponse>
}