package com.example.a039_bunga_modul4.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPost(postEntity: PostEntity)

    @Query("SELECT * FROM postentity ORDER BY name ASC")
    fun getAllPost() : LiveData<List<PostEntity>>

    @Delete
    fun deletePost(postEntity: PostEntity)

    @Update
    fun updatePost(postEntity: PostEntity)
}