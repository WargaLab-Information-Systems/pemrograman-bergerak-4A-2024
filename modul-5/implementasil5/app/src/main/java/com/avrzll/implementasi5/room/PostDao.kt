package com.avrzll.implementasi5.room

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
    fun insertPost(postDatabase: PostDatabase)

    @Query("SELECT * FROM postdatabase ORDER BY post_title ASC")
    fun getAllPost() : LiveData<List<PostDatabase>>

    @Update
    fun updatePost(postDatabase: PostDatabase)

    @Delete
    fun deletePost(postDatabase: PostDatabase)

}