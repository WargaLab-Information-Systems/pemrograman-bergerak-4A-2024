package com.example.modul4.room
// untuk menampilkan di data di halaman beranda dan berhubungan dengan adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PeopleViewModel(private val appRepository: PeopleRepository) : ViewModel() {

    // Memasukkan data pemain ke dalam database
    fun insertPlayer(player: PeopleEntity) {
        appRepository.insertPlayer(player)
    }

    // Mendapatkan semua data pemain dari database
    fun getAllPlayer(): LiveData<List<PeopleEntity>> {
        return appRepository.getAllPlayer()
    }


    fun updatePeople(people: PeopleEntity) {
        viewModelScope.launch {
            appRepository.updatePeople(people)
        }
}

    fun deletePeople(people: PeopleEntity){
        appRepository.deletePeople(people)
        }

    }