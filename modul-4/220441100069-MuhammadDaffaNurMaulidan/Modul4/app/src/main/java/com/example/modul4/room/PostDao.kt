package com.example.modul4.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Interface AppDao adalah Data Access Object (DAO) yang berfungsi sebagai jembatan antara aplikasi dan database SQLite.
 * DAO berisi metode yang menyediakan akses ke operasi database seperti insert dan query.
 *
 * Anotasi @Dao digunakan untuk memberi tahu Room bahwa interface ini adalah DAO.
 */
@Dao
interface PostDao {

    /**
     * Fungsi insertPost digunakan untuk memasukkan data postingan ke dalam database.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPost(postDatabase: PostDatabase)

    /**
     * Fungsi getAllPost digunakan untuk mendapatkan semua data postingan dari database.
     */
    @Query("SELECT * FROM postdatabase ORDER BY post_title ASC")
    fun getAllPost() : LiveData<List<PostDatabase>>


}