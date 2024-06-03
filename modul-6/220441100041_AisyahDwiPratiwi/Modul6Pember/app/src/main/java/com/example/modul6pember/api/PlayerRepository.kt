package com.example.modul6pember.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayerRepository {
    // Mendeklarasikan variabel _listPlayer sebagai MutableLiveData yang berisi List dari ExampleAPIResponse
    private val _listPlayer = MutableLiveData<List<APIResponse>>()
    // Mendeklarasikan variabel listPlayer sebagai LiveData yang berisi List dari APIResponse
    var listPlayer: LiveData<List<APIResponse>> = _listPlayer

    // Mendeklarasikan variabel _isLoading sebagai MutableLiveData yang berisi Boolean
    private var _isLoading = MutableLiveData<Boolean>()
    // Mendeklarasikan variabel isLoading sebagai LiveData yang berisi Boolean
    var isLoading: LiveData<Boolean> = _isLoading

    // Mendeklarasikan variabel _player sebagai MutableLiveData yang berisi APIResponse
    private val _player = MutableLiveData<APIResponse>()
    // Mendeklarasikan variabel player sebagai LiveData yang berisi APIResponse
    var player: LiveData<APIResponse> = _player

    // Fungsi untuk mendapatkan semua pemain
    fun getAllPlayer() {
        // Mengubah nilai _isLoading menjadi true
        _isLoading.value = true
        // Mendapatkan layanan API
        val service = APIConfig.getApiService().getAllPlayers()
        // Mengirim request ke API
        service.enqueue(object : Callback<PlayerResponse> {
            // Fungsi ini dipanggil ketika mendapatkan response dari API
            override fun onResponse(
                call: Call<PlayerResponse>,
                response: Response<PlayerResponse>
            ) {
                // Mengubah nilai _isLoading menjadi false
                _isLoading.value = false

                // Mendapatkan body dari response
                val responseBody = response.body()
                // Jika response sukses dan responseBody tidak null, ubah nilai _listPlayer dengan responseBody
                if (response.isSuccessful && responseBody != null) {
                    _listPlayer.value = responseBody.data
                } else {
                    // Jika response gagal, log pesan error
                    Log.e("Error on Response", "onFailure: ${response.message()}")
                }
            }

            // Fungsi ini dipanggil ketika request ke API gagal
            override fun onFailure(call: Call<PlayerResponse>, t: Throwable) {
                // Mengubah nilai _isLoading menjadi false
                _isLoading.value = false
                // Log pesan error
                Log.e("Error on Failure", "onFailure: ${t.message}")
            }
        })
    }

    // Objek companion yang digunakan untuk membuat instance dari PlayerRepository
    companion object {
        @Volatile
        private var instance: PlayerRepository? = null
        // Fungsi untuk mendapatkan instance dari PlayerRepository
        fun getInstance(): PlayerRepository =
            instance ?: synchronized(this) {
                instance ?: PlayerRepository()
            }.also { instance = it }
    }
}



