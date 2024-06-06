package com.example.mod6.data.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import com.example.mod6.data.playerData

class PlayerViewModel(private val APIRepository: APIRepository) : ViewModel() {
    val listPlayer: LiveData<List<playerData>> = APIRepository.listPlayer

    val isLoading: LiveData<Boolean> = APIRepository.isLoading

    fun getAllPlayer() {
        APIRepository.getAllPlayer()
    }
}