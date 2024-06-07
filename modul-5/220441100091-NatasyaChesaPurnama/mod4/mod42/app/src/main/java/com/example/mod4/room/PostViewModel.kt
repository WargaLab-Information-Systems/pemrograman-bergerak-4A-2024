package com.example.mod4.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PostViewModel(private val appRepository: PostRepository) : ViewModel() {

    fun insertPost(post: PostEntity) {
        appRepository.insertPost(post)
    }

    fun getAllPost(): LiveData<List<PostEntity>> {
        return appRepository.getAllPost()
    }

    fun updatePost(post: PostEntity) {
        appRepository.updatePost(post)
    }

    fun deletePost(post: PostEntity) {
        appRepository.deletePost(post)
    }
}