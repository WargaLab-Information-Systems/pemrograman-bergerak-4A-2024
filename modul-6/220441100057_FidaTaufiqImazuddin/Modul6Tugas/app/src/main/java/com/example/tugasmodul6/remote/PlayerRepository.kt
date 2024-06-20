package com.example.tugasmodul6.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlayerRepository {
    private val _listPlayer = MutableLiveData<List<Player>>()
    var listPlayer: LiveData<List<Player>> = _listPlayer
    private var _isLoading = MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading
    // Fungsi untuk mendapatkan semua pemain

    private val _player = MutableLiveData<PlayerAPIResponse>()
    // Mendeklarasikan variabel player sebagai LiveData yang berisi ExampleAPIResponse
    var player: LiveData<PlayerAPIResponse> = _player

    fun getAllPlayer() {
        // Mengubah nilai _isLoading menjadi true
        _isLoading.value = true
        // Mendapatkan layanan API
        val service = PlayerAPIConfig.getApiService().getAllPlayer()
        // Mengirim request ke API
        service.enqueue(object : Callback<PlayerAPIResponse> {
            // Fungsi ini dipanggil ketika mendapatkan response dari API
            override fun onResponse(
                call: Call<PlayerAPIResponse>,
                response: Response<PlayerAPIResponse>
            ) {
                // Mengubah nilai _isLoading menjadi false
                _isLoading.value = false
                // Mendapatkan body dari response
                val responseBody = response.body()
                // Jika response sukses dan responseBody tidak null, ubah nilai _listPlayer
                responseBody
                        if (response.isSuccessful && responseBody != null) {
                            _listPlayer.value = response.body()!!.data
                        } else {
                            // Jika response gagal, log pesan error
                            Log.e("Error on Response", "onFailure: ${response.message()}")
                        }
            }
            // Fungsi ini dipanggil ketika request ke API gagal
            override fun onFailure(call: Call<PlayerAPIResponse>, t: Throwable) {
                // Mengubah nilai _isLoading menjadi false
                _isLoading.value = false
                // Log pesan error
                Log.e("Error on Failure", "onFailure: ${t.message}")
            }
        })
    }
}
