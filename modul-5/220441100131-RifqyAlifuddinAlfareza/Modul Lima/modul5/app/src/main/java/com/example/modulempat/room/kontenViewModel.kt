package com.example.modulempat.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class kontenViewModel(private val repoSitory: repoSitory) : ViewModel() {
    fun insertKonten(konten: kontenDatabase){
        repoSitory.insertKonten(konten)
    }

    fun getAllKonten(): LiveData<List<kontenDatabase>>{
        return repoSitory.getAllKonten()
    }

    fun deleteKonten(konten: kontenDatabase) {
        repoSitory.deleteKonten(konten)
    }

    fun updateKonten(konten: kontenDatabase){
        repoSitory.updateKonten(konten)
    }
}