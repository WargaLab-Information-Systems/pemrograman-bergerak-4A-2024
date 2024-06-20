package com.example.tugasmodul6.remote

import retrofit2.Call
import retrofit2.http.GET

interface PlayerAPIService {

    @GET("tugas")
    fun getAllPlayer() : Call<PlayerAPIResponse>


}