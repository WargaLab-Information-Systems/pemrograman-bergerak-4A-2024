package com.example.modul4.room

import androidx.lifecycle.LiveData
import com.example.modul4.utils.AppExecutors
/// Kelas AppRepository adalah kelas yang berfungsi sebagai repositori untuk mengakses data dari database.
// Kelas ini memiliki konstruktor privat yang menerima AppDao dan AppExecutors sebagai parameter.

//membuat kelas repository untuk akses DAO
class PostRepository private constructor(private val postDao: PostDao, private val appExecutors: AppExecutors) {
    // Mendapatkan semua data postingan dari database
    fun getAllPost(): LiveData<List<PostDatabase>> = postDao.getAllPost()
    // Memasukkan data postingan ke dalam database
    fun insertPost(post: PostDatabase) {
        // Menjalankan operasi insert di thread yang berbeda
        appExecutors.diskIO().execute { postDao.insertPost(post) }
    }
    // menghapus data dari postingan di database
    fun deletePost(post: PostDatabase) {
        appExecutors.diskIO().execute { postDao.deletePost(post) }
    }
    // mengubah data di database
    fun updatePlayer(post: PostDatabase) {
        appExecutors.diskIO().execute { postDao.updatePlayer(post) }
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