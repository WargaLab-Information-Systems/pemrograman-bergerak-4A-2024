package com.example.modul6pember.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.modul6pember.utils.DependencyInjection

// Kelas ini digunakan untuk membuat instance dari ViewModel
class ViewModelFactory private constructor(private val exampleRepository: PlayerRepository) :
    ViewModelProvider.NewInstanceFactory() {

    // Fungsi ini digunakan untuk membuat instance dari ViewModel
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Jika modelClass adalah atau merupakan subclass dari ExampleViewModel
        if (modelClass.isAssignableFrom(PlayerViewModel::class.java)) {
            // Membuat dan mengembalikan instance dari ExampleViewModel
            return PlayerViewModel(exampleRepository) as T
        }
        // Jika modelClass bukan ExampleViewModel atau subclass dari ExampleViewModel, lemparkan pengecualian
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    // Objek companion yang digunakan untuk membuat instance dari ExampleViewModelFactory
    companion object {
        // Variabel instance digunakan untuk menyimpan instance dari ExampleViewModelFactory
        @Volatile
        private var instance: ViewModelFactory? = null

        // Fungsi ini digunakan untuk mendapatkan instance dari ExampleViewModelFactory
        fun getInstance(): ViewModelFactory =
        // Jika instance tidak null, kembalikan instance
            // Jika instance null, buat instance baru
            instance ?: synchronized(this) {
                instance
                    ?: ViewModelFactory(DependencyInjection.provideExampleRepository())
            }.also { instance = it }
    }
}