package com.example.modul4.room

import androidx.lifecycle.LiveData
import com.example.modul4.utils.AppExecutors

class PostRepository private constructor(private val postDao: PostDao, private val appExecutors: AppExecutors) {
    // Mendapatkan semua data postingan dari database
    fun getAllPost(): LiveData<List<PostDatabase>> = postDao.getAllPost()
    // Memasukkan data postingan ke dalam database
    fun insertPost(post: PostDatabase) {
        // Menjalankan operasi insert di thread yang berbeda
        appExecutors.diskIO().execute { postDao.insertPost(post) }
    }


    companion object {
        // Variabel untuk menyimpan instance dari PostRepository
        @Volatile
        private var instance: PostRepository? = null

        // Mendapatkan instance dari PostRepository
        fun getInstance(
            postDao: PostDao,
            appExecutors: AppExecutors
        ): PostRepository = instance ?: synchronized(this) {
            // Jika instance null, maka akan dibuat instance baru
                instance ?: PostRepository(postDao, appExecutors)
            }.also { instance = it }
    }
}