package com.example.mod4.room

import androidx.lifecycle.LiveData
import com.example.mod4.utils.AppExecutors

class PostRepository private constructor(private val appDao: PostDao, private val appExecutors: AppExecutors) {

    fun getAllPost(): LiveData<List<PostEntity>> = appDao.getAllPost()

    fun insertPost(post: PostEntity) {
        appExecutors.diskIO().execute { appDao.insertPost(post) }
    }

    fun updatePost(post: PostEntity){
        appExecutors.diskIO().execute{appDao.updatePost(post) }
    }

    fun deletePost(post: PostEntity){
        appExecutors.diskIO().execute{appDao.deletePost(post) }
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
