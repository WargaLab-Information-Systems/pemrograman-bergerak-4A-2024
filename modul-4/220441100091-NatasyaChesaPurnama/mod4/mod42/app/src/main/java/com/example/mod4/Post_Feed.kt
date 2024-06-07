package com.example.mod4

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.ReturnMode
import com.esafirm.imagepicker.features.registerImagePicker
import com.example.mod4.room.PostEntity
import com.example.mod4.room.PostViewModel
import com.example.mod4.room.PostViewModelFactory
import com.example.mod4.utils.reduceFileImage
import com.example.mod4.utils.uriToFile
import com.google.android.material.textfield.TextInputEditText

class Post_Feed : AppCompatActivity() {
    private var currentImageUri: Uri? = null
    private lateinit var img: ImageView
    private lateinit var appViewModel: PostViewModel
    private lateinit var titlepost: TextInputEditText
    private lateinit var descpost: TextInputEditText
    private lateinit var bimg: Button

    // image picker untuk memilih gambar dari galeri
    private val imagePickerLauncher = registerImagePicker {
        val firstImage = it.firstOrNull() ?: return@registerImagePicker
        if (firstImage.uri.toString().isNotEmpty()) {
            // Menampilkan ImageView jika gambar berhasil dipilih
            img.visibility = View.VISIBLE
            // Menyimpan URI gambar yang dipilih
            currentImageUri = firstImage.uri
            // Menampilkan pesan bahwa gambar berhasil dimasukkan
            bimg.setText("Gambar berhasil dimasukkan")
            // Menggunakan library Glide untuk menampilkan gambar yang dipilih
            Glide.with(img)
                .load(firstImage.uri)
                .into(img)
            // Menyembunyikan TextInputEditText setelah gambar dipilih
            bimg.visibility = View.GONE
        } else {
            // Menyembunyikan ImageView jika tidak ada gambar yang dipilih
            img.visibility = View.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_feed)
        enableEdgeToEdge()

        val factory = PostViewModelFactory.getInstance(this)
        appViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]

        img = findViewById(R.id.postimg)
        titlepost = findViewById(R.id.postjudul)
        descpost = findViewById(R.id.postdesc)
        bimg = findViewById(R.id.bChange)

        onClick()
    }

    private fun onClick() {
        val openImagePicker = findViewById<Button>(R.id.bChange)
        openImagePicker.setOnClickListener {
            imagePickerLauncher.launch(
                ImagePickerConfig {
                    mode = ImagePickerMode.SINGLE
                    returnMode = ReturnMode.ALL
                    isFolderMode = true
                    folderTitle = "Galeri"
                    isShowCamera = false
                    imageTitle = "Tekan untuk memilih gambar"
                    doneButtonText = "Selesai"
                }
            )
        }

        val btnSavedPlayer = findViewById<Button>(R.id.saved_player)
        btnSavedPlayer.setOnClickListener {
            // Memvalidasi input dan menyimpan data jika valid
            if (validateInput()) {
                savedData()
            }
        }
    }

    private fun validateInput(): Boolean {
        var error = 0

        if (titlepost.text.toString().isEmpty()) {
            error++
            titlepost.error = "Nama pemain tidak boleh kosong"
        }

        if (descpost.text.toString().isEmpty()) {
            error++
            descpost.error = "Deskripsi pemain tidak boleh kosong"
        }

        if (bimg.text.toString().isEmpty()) {
            error++
            bimg.error = "Gambar tidak boleh kosong"
        }

        return error == 0
    }

    private fun savedData() {
        // Mengubah URI gambar menjadi file dan mengurangi ukuran file
        val imageFile = currentImageUri?.let { uriToFile(it, this).reduceFileImage() }

        // Membuat objek pemain dengan data yang diinputkan
        val post = imageFile?.let {
            PostEntity(
                id = 0,
                judul = titlepost.text.toString(),
                desc = descpost.text.toString(),
                image = imageFile,
                like = 0
            )
        }
        if (post != null) appViewModel.insertPlayer(post)

        Toast.makeText(
            this@Post_Feed,
            "Berhasil meng-upload",
            Toast.LENGTH_SHORT
        ).show()

        // Mengakhiri activity
        finish()
    }
}
