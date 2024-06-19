package com.example.modul6.data.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.modul6.data.PlayerData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APIRepository {
    // Mendeklarasikan variabel _listPlayer sebagai MutableLiveData yang berisi List dari ExampleAPIResponse
    private val _listPlayer = MutableLiveData<List<PlayerData>>()
    // Mendeklarasikan variabel listPlayer sebagai LiveData yang berisi List dari ExampleAPIResponse
    var listPlayer: LiveData<List<PlayerData>> = _listPlayer

    // Mendeklarasikan variabel _isLoading sebagai MutableLiveData yang berisi Boolean
    private var _isLoading = MutableLiveData<Boolean>()
    // Mendeklarasikan variabel isLoading sebagai LiveData yang berisi Boolean
    var isLoading: LiveData<Boolean> = _isLoading

    // Mendeklarasikan variabel _player sebagai MutableLiveData yang berisi ExampleAPIResponse
    private val _player = MutableLiveData<PlayerData>()
    // Mendeklarasikan variabel player sebagai LiveData yang berisi ExampleAPIResponse
    var player: LiveData<PlayerData> = _player

    // Fungsi untuk mendapatkan semua pemain
    fun getAllPlayer() {
        // Mengubah nilai _isLoading menjadi true
        _isLoading.value = true
        // Mendapatkan layanan API > buat manggil
        val service = APIConfig.getApiService().getAllPlayer()
        // Mengirim request ke API
        service.enqueue(object : Callback<APIRequest> {
            // Fungsi ini dipanggil ketika mendapatkan response dari API
            override fun onResponse(
                call: Call<APIRequest>,
                response: Response<APIRequest>
            ) {
                // Mengubah nilai _isLoading menjadi false
                _isLoading.value = false

                // Mendapatkan body dari response
                val responseBody = response.body()
                // Jika response sukses dan responseBody tidak null, ubah nilai _listPlayer dengan responseBody
                if (response.isSuccessful && responseBody != null) {
                    _listPlayer.value = response.body()!!.data
                    //kenapa harus dikasi !! ?? ini buat INI BENERAN GA NULL
                } else {
                    // Jika response gagal, log pesan error
                    Log.e("Error on Response", "onFailure: ${response.message()}")
                }
            }

            // Fungsi ini dipanggil ketika request ke API gagal
            override fun onFailure(call: Call<APIRequest>, t: Throwable) {
                // Mengubah nilai _isLoading menjadi false
                _isLoading.value = false
                // Log pesan error
                Log.e("Error on Failure", "onFailure: ${t.message}")
            }
        })
    }
}