package com.fira.tugas_modul6.data.remote

data class APIResponse(
    val error: Boolean,
    val message: String,
    val count: Int,
    val data: List<PlayerData>
)