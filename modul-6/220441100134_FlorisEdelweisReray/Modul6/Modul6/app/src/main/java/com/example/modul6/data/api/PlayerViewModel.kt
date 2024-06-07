package com.example.modul6.data.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import com.example.modul6.data.mediaData

class PlayerViewModel(private val APIRepository: APIRepository) : ViewModel() {
    val listPlayer: LiveData<List<mediaData>> = APIRepository.listPlayer

    val isLoading: LiveData<Boolean> = APIRepository.isLoading

    fun getAllPlayer() {
        APIRepository.getAllPlayer()
    }
}
