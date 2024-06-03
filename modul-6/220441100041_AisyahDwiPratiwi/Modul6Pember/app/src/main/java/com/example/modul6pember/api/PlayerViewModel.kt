package com.example.modul6pember.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

// Kelas ini digunakan untuk mengelola data dan berinteraksi dengan repository
class PlayerViewModel(private val repository: PlayerRepository) : ViewModel() {

    // Mendeklarasikan variabel listPlayer yang berisi LiveData dari List ExampleAPIResponse dari repository
    val listPlayer: LiveData<List<APIResponse>> = repository.listPlayer

    // Mendeklarasikan variabel isLoading yang berisi LiveData dari Boolean (status loading) dari repository
    val isLoading: LiveData<Boolean> = repository.isLoading

    // Mendeklarasikan variabel player yang berisi LiveData dari ExampleAPIResponse dari repository
    val player: LiveData<APIResponse> = repository.player

    // Fungsi untuk mendapatkan semua pemain dari repository
    fun getAllPlayer() {
        repository.getAllPlayer()
    }
}