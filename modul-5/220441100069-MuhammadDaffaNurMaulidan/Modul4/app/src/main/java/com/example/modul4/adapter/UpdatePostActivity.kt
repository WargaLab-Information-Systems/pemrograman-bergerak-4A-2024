package com.example.modul4.adapter

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.ReturnMode
import com.esafirm.imagepicker.features.registerImagePicker
import com.example.modul4.R
import com.example.modul4.room.PostDatabase
import com.example.modul4.room.PostViewModel
import com.example.modul4.room.PostViewModelFactory
import com.example.modul4.utils.reduceFileImage
import com.example.modul4.utils.uriToFile
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

import java.io.File

class UpdatePostActivity : AppCompatActivity() {
    // Mendeklarasikan variabel untuk menyimpan URI gambar saat ini dan foto lama.
    private var currentImageUri: Uri? = null
    private var oldPhoto: File? = null

    // Mendeklarasikan ViewModel untuk interaksi dengan database dan komponen UI lainnya.
    private lateinit var appViewModel: PostViewModel
    private lateinit var playerImage: ImageView
    private lateinit var playerDescription: TextInputEditText
    private lateinit var getData: PostDatabase

    // Mendeklarasikan imagePickerLauncher untuk memilih gambar dari galeri atau kamera.

    private val imagePickerLauncher = registerImagePicker {
        val firstImage = it.firstOrNull() ?: return@registerImagePicker
        if (firstImage.uri.toString().isNotEmpty()) {
            playerImage.visibility = View.VISIBLE
            currentImageUri = firstImage.uri
            Glide.with(playerImage)
                .load(firstImage.uri)
                .into(playerImage)
        } else {
            View.GONE
        }
    }

    // Fungsi onCreate dipanggil ketika activity dibuat.
    // Fungsi ini digunakan untuk melakukan inisialisasi awal untuk activity.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_post)

        // Mendapatkan data pemain dari intent.
        getData = intent.getParcelableExtra("post")!!

        // Mendapatkan instance ViewModel.
        val factory = PostViewModelFactory.getInstance(this)
        appViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]

        // Menghubungkan variabel dengan komponen di layout.
        playerImage = findViewById(R.id.post_img_edit)
        playerDescription = findViewById(R.id.post_desc_edit)

        // Mengatur teks untuk setiap komponen TextInputEditText.
        playerDescription.setText(getData.description)

        // Mendapatkan foto lama dari data pemain.
        oldPhoto = getData.image

        // Menggunakan Glide untuk memuat gambar ke ImageView.
        Glide.with(playerImage)
            .load(getData.image)
            .into(playerImage)

        // Menangani aksi klik.
        onClick()
    }

    // Fungsi onClick digunakan untuk menangani aksi klik pada tombol dan TextInputEditText.
    private fun onClick() {

            val openImagePicker = findViewById<ImageView>(R.id.post_img_edit)
            openImagePicker.setOnClickListener {
                imagePickerLauncher.launch(
                    ImagePickerConfig {
                        mode = ImagePickerMode.SINGLE
                        returnMode = ReturnMode.ALL
                        isFolderMode = true
                        folderTitle = "Galeri"
                        isShowCamera = false
                        imageTitle = "Click untuk pilih gambar"
                        doneButtonText = "Done"
                    }
                )
            }
            val btnSavedPlayer = findViewById<Button>(R.id.btn_savedPost)
            btnSavedPlayer.setOnClickListener {
                // Jika semua input valid, simpan data.
                if (validateInput()) {
                    savedData()
                }
        }
    }

    // Fungsi validateInput digunakan untuk memvalidasi input dari pengguna.
    private fun validateInput(): Boolean {
        var error = 0

        if (playerDescription.text.toString().isEmpty()) {
            error++
            playerDescription.error = "Deskripsi tidak boleh kosong"
        }


        // Jika tidak ada error, kembalikan true. Jika ada, kembalikan false.
        return error == 0
    }

    // Fungsi savedData digunakan untuk menyimpan data pemain yang diperbarui ke database.
    private fun savedData() {
        // Mengurangi ukuran file gambar.
        val imageFile = currentImageUri?.let { uriToFile(it, this).reduceFileImage() }

        // Membuat objek PlayerEntity baru dengan data yang diperbarui.
        val player = (if (currentImageUri != null) imageFile else oldPhoto)?.let {
            val descriptionText = playerDescription.text.toString()
            val words = descriptionText.split(" ")
            val firstTwoWords = words.take(2).joinToString(" ")
            PostDatabase(
                id = getData.id,
                name = firstTwoWords,
                description = playerDescription.text.toString(),
                image = it,
                like = getData.like
            )
        }

        // Memperbarui data  di database.
        if (player != null) appViewModel.updatePlayer(player)

        // Menampilkan pesan bahwa data  berhasil diubah.
        Toast.makeText(
            this@UpdatePostActivity,
            "Data Postingan berhasil diubah",
            Toast.LENGTH_SHORT
        ).show()

        // Menutup activity.
        finish()
    }
}