package com.example.modul4room.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 * Kelas AppViewModel adalah kelas yang berfungsi sebagai ViewModel dalam arsitektur MVVM (Model-View-ViewModel).
 * Kelas ini memiliki konstruktor yang menerima AppRepository sebagai parameter.
 *
 * Fungsi insertPlayer(player: PlayerDatabase) digunakan untuk memasukkan data pemain ke dalam database.
 * Fungsi ini memanggil fungsi insertPlayer di AppRepository.
 *
 * Fungsi getAllPlayer() digunakan untuk mendapatkan semua data pemain dari database.
 * Fungsi ini memanggil fungsi getAllPlayer di AppRepository dan mengembalikan LiveData yang berisi daftar semua pemain.
 */
class AppViewModel(private val appRepository: AppRepository) : ViewModel() {

    // Memasukkan data pemain ke dalam database
    fun insertPost(post: PostDatabase) {
        appRepository.insertPost(post)
    }

    // Mendapatkan semua data pemain dari database
    fun getAllPost(): LiveData<List<PostDatabase>> {
        return appRepository.getAllPost()
    }
}