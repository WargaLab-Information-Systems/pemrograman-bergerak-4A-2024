package com.example.modul6.data.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import com.example.modul6.data.PlayerData

class PlayerViewModel(private val APIRepository: APIRepository) : ViewModel() {
    val listPlayer: LiveData<List<PlayerData>> = APIRepository.listPlayer

    val isLoading: LiveData<Boolean> = APIRepository.isLoading

    fun getAllPlayer() {
        APIRepository.getAllPlayer()
    }
}
