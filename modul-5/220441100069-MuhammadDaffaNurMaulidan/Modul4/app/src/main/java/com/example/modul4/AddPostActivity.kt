package com.example.modul4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.ReturnMode
import com.esafirm.imagepicker.features.registerImagePicker
import com.example.modul4.room.PostDatabase
import com.example.modul4.room.PostViewModel
import com.example.modul4.room.PostViewModelFactory
import com.example.modul4.utils.reduceFileImage
import com.example.modul4.utils.uriToFile
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.random.Random

class AddPostActivity : AppCompatActivity() {

    // Mendeklarasikan ViewModel untuk interaksi dengan database dan komponen UI lainnya.
    private var currentImageUri: Uri? = null
    private lateinit var postViewModel: PostViewModel
    private lateinit var vPostDesc: TextInputEditText
    private lateinit var vPostImage: ImageView
    private lateinit var vText_img: TextView

    // Mendeklarasikan imagePickerLauncher untuk memilih gambar dari galeri atau kamera.
    private val imagePickerLauncher = registerImagePicker {
        val firstImage = it.firstOrNull() ?: return@registerImagePicker
        if (firstImage.uri.toString().isNotEmpty()) {
            vPostImage.visibility = View.VISIBLE
            currentImageUri = firstImage.uri
            vText_img.setText("change")
            Glide.with(vPostImage)
                .load(firstImage.uri)
                .into(vPostImage)
        } else {
            View.GONE
        }
    }

    // Fungsi onCreate dipanggil ketika activity dibuat.
    // Fungsi ini digunakan untuk melakukan inisialisasi awal untuk activity.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)
        val factory = PostViewModelFactory.getInstance(this)
        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]

        // Menghubungkan variabel dengan komponen di layout.
        vPostImage = findViewById(R.id.post_img_edit)
        vPostDesc = findViewById(R.id.post_desc_edit)
        vText_img = findViewById(R.id.text_img)

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

        // Jika semua input valid, simpan data.
        val btnSavedPlayer = findViewById<Button>(R.id.btn_savedPost)
        btnSavedPlayer.setOnClickListener {
            if (validateInput()) {
                savedData()
            }
        }
    }

    private fun validateInput(): Boolean {
        var error = 0
        // Fungsi validateInput digunakan untuk memvalidasi input dari pengguna.
        if (vPostDesc.text.toString().isEmpty()) {
            error++
            vPostDesc.error = "Deskripsi Tidak Boleh Kosong"
        }
        if (vText_img.text.toString() == "add") {
            error++
            vText_img.error = "Gambar Tidak Boleh Kosong"
        }

        // Jika tidak ada error, kembalikan true. Jika ada, kembalikan false.
        return error == 0
    }

    // Fungsi savedData digunakan untuk menyimpan data ke database.
    private fun savedData() {
        // Mengurangi ukuran file gambar.
        val imageFile = currentImageUri?.let { uriToFile(it, this).reduceFileImage() }

        // Membuat objek Postdatabase dengan insert data.
        val post = imageFile?.let {
            val descriptionText = vPostDesc.text.toString()
            val words = descriptionText.split(" ")
            val firstTwoWords = words.take(2).joinToString(" ")
            PostDatabase(
                id = 0,
                name = firstTwoWords,
                description = descriptionText,
                image = imageFile,
                like = 1
            )
        }
        // Memperbarui data di database.
        if (post != null) postViewModel.insertPost(post)

        // Menampilkan pesan bahwa data  berhasil diubah.
        Toast.makeText(
            this@AddPostActivity,
            "Data Berhasil Ditambahkan",
            Toast.LENGTH_SHORT
        ).show()

        finish()
    }

    fun toMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}