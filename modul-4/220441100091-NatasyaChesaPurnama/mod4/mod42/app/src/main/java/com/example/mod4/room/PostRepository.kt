package com.example.mod4.room

import androidx.lifecycle.LiveData
import com.example.mod4.utils.AppExecutors

class PostRepository private constructor(private val appDao: PostDao, private val appExecutors: AppExecutors) {

    fun getAllPlayer(): LiveData<List<PostEntity>> = appDao.getAllPeople()
    fun insertPlayer(post: PostEntity) {
        appExecutors.diskIO().execute { appDao.insertPeople(post) }
    }

    companion object {
        @Volatile
        private var instance: PostRepository? = null
        fun getInstance(
            appDao: PostDao,
            appExecutors: AppExecutors
        ): PostRepository =
            instance ?: synchronized(this) {
                instance ?: PostRepository(appDao, appExecutors)
            }.also { instance=it}
    }
}
