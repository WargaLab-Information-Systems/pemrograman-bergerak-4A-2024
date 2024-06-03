package com.example.a039_bunga_modul4

import android.content.Intent
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
import com.example.a039_bunga_modul4.room.PostEntity
import com.example.a039_bunga_modul4.room.PostViewModel
import com.example.a039_bunga_modul4.room.PostViewModelFactory
import com.example.a039_bunga_modul4.utils.reduceFileImage
import com.example.a039_bunga_modul4.utils.uriToFile
import com.google.android.material.textfield.TextInputEditText

class Post_Postingan : AppCompatActivity() {

    // Mendeklarasikan variabel untuk menyimpan URI gambar yang dipilih
    private var currentImageUri: Uri? = null

    // Mendeklarasikan ImageView untuk menampilkan gambar yang dipilih
    private lateinit var postfoto: ImageView

    // Mendeklarasikan ViewModel untuk interaksi dengan database
    private lateinit var appViewModel: PostViewModel

    // Mendeklarasikan EditText untuk input nama pemain
    private lateinit var inputjudul: TextInputEditText

    // Mendeklarasikan EditText untuk input deskripsi pemain
    private lateinit var postdeskripsi: TextInputEditText

    // Mendeklarasikan EditText untuk input gambar pemain
    private lateinit var tombolinput: Button

    // image picker untuk memilih gambar dari galeri
    private val imagePickerLauncher = registerImagePicker {
        val firstImage = it.firstOrNull() ?: return@registerImagePicker
        if (firstImage.uri.toString().isNotEmpty()) {
            // Menampilkan ImageView jika gambar berhasil dipilih
            postfoto.visibility = View.VISIBLE
            // Menyimpan URI gambar yang dipilih
            currentImageUri = firstImage.uri
            // Menampilkan pesan bahwa gambar berhasil dimasukkan
            tombolinput.setText("Gambar berhasil dimasukkan")
            // Menggunakan library Glide untuk menampilkan gambar yang dipilih
            Glide.with(postfoto)
                .load(firstImage.uri)
                .into(postfoto)
            // Menyembunyikan TextInputEditText setelah gambar dipilih
            tombolinput.visibility = View.GONE
        } else {
            // Menyembunyikan ImageView jika tidak ada gambar yang dipilih
            postfoto.visibility = View.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_feed)
        enableEdgeToEdge()

        val factory = PostViewModelFactory.getInstance(this)
        appViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]

        postfoto = findViewById(R.id.postgambar)
        inputjudul = findViewById(R.id.postjudul)
        postdeskripsi = findViewById(R.id.postdesc)
        tombolinput = findViewById(R.id.bUbah)

        onClick()
    }

    private fun onClick() {
        // Menangani aksi klik pada button untuk membuka galeri
        val openImagePicker = findViewById<Button>(R.id.bUbah)
        openImagePicker.setOnClickListener {
            imagePickerLauncher.launch(
                ImagePickerConfig {
                    mode = ImagePickerMode.SINGLE
                    returnMode = ReturnMode.ALL
                    isFolderMode = true
                    folderTitle = "Galeri"
                    isShowCamera = false
                    imageTitle = "Klik untuk menambahkan gambar"
                    doneButtonText = "Selesai"
                }
            )
        }

        // Menangani aksi klik pada tombol simpan
        val tombolpost = findViewById<Button>(R.id.bPostingan)
        tombolpost.setOnClickListener {
            // Memvalidasi input dan menyimpan data jika valid
            if (validateInput()) {
                savedData()
            }
        }
    }

    // Fungsi untuk memvalidasi input
    private fun validateInput(): Boolean {
        var error = 0

        // Memeriksa apakah nama pemain kosong
        if (inputjudul.text.toString().isEmpty()) {
            error++
            inputjudul.error = "Judul tidak boleh kosong"
        }

        // Memeriksa apakah deskripsi pemain kosong
        if (postdeskripsi.text.toString().isEmpty()) {
            error++
            postdeskripsi.error = "Deskripsi tidak boleh kosong"
        }

        // Memeriksa apakah gambar pemain kosong
        if (tombolinput.text.toString().isEmpty()) {
            error++
            tombolinput.error = "Gambar tidak boleh kosong"
        }

        // Mengembalikan true jika tidak ada error, false jika ada error
        return error == 0
    }

    // Fungsi untuk menyimpan data pemain
    private fun savedData() {
        // Mengubah URI gambar menjadi file dan mengurangi ukuran file
        val imageFile = currentImageUri?.let { uriToFile(it, this).reduceFileImage() }

        // Membuat objek pemain dengan data yang diinputkan
        val post = imageFile?.let {
            PostEntity(
                id = 0,
                name = inputjudul.text.toString(),
                description = postdeskripsi.text.toString(),
                image = imageFile,
                likeCount = 0
            )
        }

        // Menyimpan data pemain ke database
        if (post != null) appViewModel.insertPost(post)

        // Menampilkan pesan bahwa data pemain berhasil ditambahkan
        Toast.makeText(
            this@Post_Postingan,
            "Postingan berhasil di-upload",
            Toast.LENGTH_SHORT
        ).show()

        // Mengakhiri activity
        finish()
    }
    fun balik(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
