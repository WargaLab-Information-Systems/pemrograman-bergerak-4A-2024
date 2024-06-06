package com.example.modul6.data.remote
// APIResponse adalah data class yang memetakan struktur respons dari server.
//Ini berisi informasi tentang status error, pesan, jumlah data, dan daftar objek
//PlayerData.
data class APIResponse(
    val error: Boolean,
    val message: String,
    val count: Int,
    val data: List<PlayerData>
)