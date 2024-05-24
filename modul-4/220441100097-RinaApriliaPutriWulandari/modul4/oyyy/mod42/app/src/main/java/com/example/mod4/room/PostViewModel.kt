package com.example.mod4.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PostViewModel(private val appRepository: PostRepository) : ViewModel() {

    // Memasukkan data pemain ke dalam database
    fun insertPlayer(post: PostEntity) {
        appRepository.insertPlayer(post)
    }

    // Mendapatkan semua data pemain dari database
    fun getAllPlayer(): LiveData<List<PostEntity>> {
        return appRepository.getAllPlayer()
    }
}