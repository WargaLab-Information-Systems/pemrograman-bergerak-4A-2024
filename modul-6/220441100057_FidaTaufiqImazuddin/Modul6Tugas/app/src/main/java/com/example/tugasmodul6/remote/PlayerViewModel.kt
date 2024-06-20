package com.example.tugasmodul6.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PlayerViewModel (private val playerRepository: PlayerRepository) : ViewModel() {
    val listPlayer: LiveData<List<Player>> = playerRepository.listPlayer
    val isLoading: LiveData<Boolean> = playerRepository.isLoading

    fun getAllPlayer() {
        playerRepository.getAllPlayer()
    }
}