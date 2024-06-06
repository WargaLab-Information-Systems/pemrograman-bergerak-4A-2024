package com.example.modul6pember.data
// untuk mendapatkan API tugasnya
import retrofit2.Call
import retrofit2.http.GET

interface PracticeAPIService {
    @GET("tugas")
    fun getAllPlayer(): Call<PracticeAPIResponse>
}