package com.example.mod4.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PostViewModel(private val appRepository: PostRepository) : ViewModel() {

    fun insertPlayer(post: PostEntity) {
        appRepository.insertPlayer(post)
    }
    
    fun getAllPlayer(): LiveData<List<PostEntity>> {
        return appRepository.getAllPlayer()
    }
}