package com.example.modul6.data.remote

import retrofit2.Call
import retrofit2.http.GET
// endpoint
interface APIService {
    @GET("tugas")
    fun getAllPlayer() : Call<APIResponse>
}