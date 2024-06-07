package com.example.tgsmdl6.data
//isinya data class sesuai dengan API nya. ada variable data itu isinya list objek. jadi untuk mendapatkan
// list objeknya itu, membuat data class baru Bernama'player'
import com.google.gson.annotations.SerializedName

data class PracticeAPIResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("count")
    val count: Int,

    @field:SerializedName("data")
    val data:List<Player>
)
