package com.avrzll.implementasi5.utils

import android.content.Context
import com.avrzll.implementasi5.room.AppDatabase
import com.avrzll.implementasi5.room.PostRepository

object DependencyInjection {
    fun provideRepository(context: Context): PostRepository {
        val database = AppDatabase.getDatabase(context)
        val appExecutors = AppExecutors()
        val dao = database.postDao()
        return PostRepository.getInstance(dao, appExecutors)
    }
}