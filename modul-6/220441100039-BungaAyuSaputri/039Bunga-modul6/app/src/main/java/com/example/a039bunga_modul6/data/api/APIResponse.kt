package com.example.a039bunga_modul6.data.api

import com.example.a039bunga_modul6.data.playerData
import com.google.gson.annotations.SerializedName

data class APIResponse(
    @field:SerializedName("error") val error: Boolean,
    @field:SerializedName("message") val message: String,
    @field:SerializedName("count") val count: Int,
    @field:SerializedName("data") val data: List<playerData>
)
