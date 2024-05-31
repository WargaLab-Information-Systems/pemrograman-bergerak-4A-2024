package com.example.modul4.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
/**
 * Kelas AppDatabase adalah kelas abstrak yang berfungsi sebagai holder database dan merupakan titik akses ke database SQLite yang mendasarinya.
 * Kelas ini mendeklarasikan database dengan entitas PlayerEntity dan versi 1.
 * Kelas ini juga menggunakan konverter tipe khusus (AppConverter) untuk mengubah tipe data File menjadi String dan sebaliknya.
 *
 * Fungsi appDao() adalah fungsi abstrak yang mengembalikan AppDao.
 *
 * Objek pendamping untuk AppDatabase dibuat di dalamnya, yang berisi variabel INSTANCE yang akan menyimpan instance dari AppDatabase.
 *

 *
 * Mengembalikan instance dari AppDatabase.
 */
// buat kelas abstrak baru sebagai dari aplikasi yang dibuat
// Mendeklarasikan database dengan entitas PlayerEntity dan versi 1
@Database(entities = [PostDatabase::class], version = 1)
// Menggunakan konverter tipe khusus untuk mengubah tipe data File menjadi String dan sebaliknya
@TypeConverters(AppConverter::class)
// Membuat kelas abstrak AppDatabase yang merupakan turunan dari RoomDatabase
abstract class AppDatabase : RoomDatabase() {
    // Mendeklarasikan fungsi abstrak yang mengembalikan postDao
    abstract fun postDao(): PostDao

    // Membuat objek pendamping untuk postDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "app_database"
                    )
                        .build()
                }
            }
            return INSTANCE as AppDatabase
        }
    }
}