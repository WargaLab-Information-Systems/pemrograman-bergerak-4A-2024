package com.example.tgsmdl6.data
// untuk mendapatkan API tugasnya. APIConfig
// hanya memanggil keseluruhan. memanggil tugas
import retrofit2.Call
import retrofit2.http.GET

interface PracticeAPIService {
    @GET("tugas")
    fun getAllPlayer(): Call<PracticeAPIResponse>
}