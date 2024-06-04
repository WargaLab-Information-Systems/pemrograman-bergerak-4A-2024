package com.avrzll.implementasi5

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.avrzll.implementasi5.room.PostDatabase
import com.avrzll.implementasi5.room.PostViewModel
import com.avrzll.implementasi5.room.PostViewModelFactory
import com.avrzll.implementasi5.utils.reduceFileImage
import com.avrzll.implementasi5.utils.uriToFile
import com.bumptech.glide.Glide
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.ReturnMode
import com.esafirm.imagepicker.features.registerImagePicker
import com.google.android.material.textfield.TextInputEditText
import java.io.File

class UpdatePostActivity : AppCompatActivity() {

    // Mendeklarasikan variabel untuk menyimpan URI gambar saat ini dan foto lama.
    private var currentImageUri: Uri? = null
    private var oldPhoto: File? = null

    private lateinit var postViewModel: PostViewModel
    private lateinit var vPostDesc: TextInputEditText
    private lateinit var vPostImage: ImageView
    private lateinit var vText_img: TextView
    private lateinit var getDataPost: PostDatabase

    // Mendeklarasikan imagePickerLauncher untuk memilih gambar dari galeri atau kamera.
    private val imagePickerLauncher = registerImagePicker {
        val firstImage = it.firstOrNull() ?: return@registerImagePicker
        if (firstImage.uri.toString().isNotEmpty()) {
            vPostImage.visibility = View.VISIBLE
            currentImageUri = firstImage.uri

            // Menggunakan Glide untuk memuat gambar ke ImageView.
            Glide.with(vPostImage)
                .load(firstImage.uri)
                .into(vPostImage)
        } else {
            View.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_post)

        getDataPost = intent.getParcelableExtra("post")!!

        val factory = PostViewModelFactory.getInstance(this)
        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]

        vPostImage = findViewById(R.id.post_img_edit)
        vPostDesc = findViewById(R.id.post_desc_edit)
        vText_img = findViewById(R.id.text_img)

        vPostDesc.setText(getDataPost!!.description)
        vText_img.setText("change")
        Glide.with(this)
            .load(getDataPost.image)
            .into(vPostImage)

        oldPhoto = getDataPost.image

        onClick()
    }

    private fun onClick() {
        val savedBtn = findViewById<Button>(R.id.btn_savedPost)
        savedBtn.setOnClickListener {
            if (validateInput()) {
                savedData()
            }
        }
        val btnBack = findViewById<ImageView>(R.id.back_btn)
        btnBack.setOnClickListener {
            finish()
        }

        // Menangani aksi klik pada TextInputEditText untuk membuka image picker.
        val openImagePicker = findViewById<ImageView>(R.id.post_img_edit)
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
    }

    private fun validateInput(): Boolean {
        var error = 0

        // Jika input kosong, tambahkan pesan error.
        if (vPostDesc.text.toString().isEmpty()) {
            error++
            vPostDesc.error = "Deskripsi tidak boleh kosong!"
        }

        // Jika tidak ada error, kembalikan true. Jika ada, kembalikan false.
        return error == 0
    }

    private fun savedData() {
        // Mengurangi ukuran file gambar.
        val imageFile = currentImageUri?.let { uriToFile(it, this).reduceFileImage() }

        // Membuat objek PlayerEntity baru dengan data yang diperbarui.
        val post = (if (currentImageUri != null) imageFile else oldPhoto)?.let {
            val descriptionText = vPostDesc.text.toString()
            val words = descriptionText.split(" ")
            val firstTwoWords = words.take(2).joinToString(" ")
            PostDatabase(
                id = getDataPost.id,
                name = firstTwoWords,
                description = descriptionText,
                image = it,
            )
        }

        Log.d("post", post.toString())

        // Memperbarui data pemain di database.
        if (post != null) postViewModel.updatePost(post)

        // Menampilkan pesan bahwa data pemain berhasil diubah.
        Toast.makeText(
            this@UpdatePostActivity,
            "Data berhasil diubah",
            Toast.LENGTH_SHORT
        ).show()

        // Menutup activity.
        finish()
    }
}