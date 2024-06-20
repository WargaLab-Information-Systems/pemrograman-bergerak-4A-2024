package com.example.tugasmodul6.remote

import com.google.gson.annotations.SerializedName

data class PlayerAPIResponse(

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("count")
    val count: Int,

    @field:SerializedName("data")
    val data: List<Player>
)
