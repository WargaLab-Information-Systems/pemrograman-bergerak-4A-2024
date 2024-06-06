package com.example.tgsmdl6.data
//membuat instance dari view model. mendapatkan instance dari Repositori.
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PracticeViewModel (private val practiceRepository: PracticeRepository) : ViewModel() {

    // Mendeklarasikan variabel listPlayer yang berisi LiveData dari List ExampleAPIResponse dari repository
    val listPlayer: LiveData<List<Player>> = practiceRepository.listPlayer

    // Mendeklarasikan variabel isLoading yang berisi LiveData dari Boolean (status loading) dari repository
    val isLoading: LiveData<Boolean> = practiceRepository.isLoading

    // Fungsi untuk mendapatkan semua pemain dari repository
    fun getAllPlayer() {
        practiceRepository.getAllPlayer()
    }
}