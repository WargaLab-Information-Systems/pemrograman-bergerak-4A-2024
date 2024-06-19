package com.example.modul6.data.api

import com.example.modul6.data.PlayerData
import com.google.gson.annotations.SerializedName

data class APIRequest(
    @field:SerializedName("error") val error: Boolean,
    @field:SerializedName("message") val message: String,
    @field:SerializedName("count") val count: Int,
    @field:SerializedName("data") val data: List<PlayerData>
)
