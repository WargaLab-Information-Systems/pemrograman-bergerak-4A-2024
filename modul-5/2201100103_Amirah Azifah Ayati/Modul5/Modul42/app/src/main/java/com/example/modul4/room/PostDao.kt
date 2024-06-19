package com.example.modul4.room

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
    fun insertPeople(postEntity: PostEntity)

    @Query("SELECT * FROM postentity ORDER BY name ASC")
    fun getAllPeople() : LiveData<List<PostEntity>>

    @Delete
    fun deletePeople(postEntity: PostEntity)

    @Update
    fun updatePeople(postEntity: PostEntity)
}