package com.example.modul4.room

import androidx.lifecycle.LiveData
import com.example.modul4.utils.AppExecutors

class PostRepository private constructor(private val appDao: PostDao, private val appExecutors: AppExecutors) {

    // Mendapatkan semua data pemain dari database
    fun getAllPeople(): LiveData<List<PostEntity>> = appDao.getAllPeople()

    // Memasukkan data pemain ke dalam database
    fun insertPeople(post: PostEntity) {
        // Menjalankan operasi insert di thread yang berbeda
        appExecutors.diskIO().execute { appDao.insertPeople(post) }
    }

    fun updatePeople(post: PostEntity){
        appExecutors.diskIO().execute{appDao.updatePeople(post) }
    }

    fun deletePeople(post: PostEntity){
        appExecutors.diskIO().execute{appDao.deletePeople(post) }
    }

    companion object {
        // Variabel untuk menyimpan instance dari AppRepository
        @Volatile
        private var instance: PostRepository? = null

        // Mendapatkan instance dari AppRepository
        fun getInstance(
            appDao: PostDao,
            appExecutors: AppExecutors
        ): PostRepository =
            // Jika instance null, maka akan dibuat instance baru
            instance ?: synchronized(this) {
                instance ?: PostRepository(appDao, appExecutors)
            }.also { instance=it}
    }
}