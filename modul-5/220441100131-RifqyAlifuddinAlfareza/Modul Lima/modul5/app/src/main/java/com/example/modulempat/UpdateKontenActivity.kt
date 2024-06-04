package com.example.modulempat

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.ReturnMode
import com.esafirm.imagepicker.features.registerImagePicker
import com.example.modulempat.room.kontenDatabase
import com.example.modulempat.room.kontenViewModel
import com.example.modulempat.room.kontenViewModelFactory
import com.example.modulempat.utils.reduceFileImage
import com.example.modulempat.utils.uriToFile
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.io.File

class UpdateKontenActivity : AppCompatActivity() {
    private var currentImageUri: Uri? = null
    private var oldImageUri: File? = null

    private lateinit var kontenImage: ImageView

    private lateinit var appViewModel: kontenViewModel

    private lateinit var kontenDeskripsi: TextInputEditText

    private lateinit var kontenGambar: TextInputEditText

    private lateinit var getData: kontenDatabase

    private val imagePickerLauncher = registerImagePicker {
        val firstImage = it.firstOrNull() ?: return@registerImagePicker
        if (firstImage.uri.toString().isNotEmpty()) {
            // Menampilkan ImageView jika gambar berhasil dipilih
            kontenImage.visibility = View.VISIBLE
            // Menyimpan URI gambar yang dipilih
            currentImageUri = firstImage.uri
            // Menampilkan pesan bahwa gambar berhasil dimasukkan
            kontenGambar.setText("Change")
            kontenImage.setImageURI(currentImageUri)

            // Menggunakan library Glide untuk menampilkan gambar yang dipilih
//            Glide.with(kontenImage)
//                .load(firstImage.uri)
//                .into(kontenImage)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_konten)

        getData = intent.getParcelableExtra("id")!!

        val factory = kontenViewModelFactory.getInstance(this)
        appViewModel = ViewModelProvider(this, factory)[kontenViewModel::class.java]

        kontenImage = findViewById(R.id.up_gambar)
        kontenDeskripsi = findViewById(R.id.unggah_deskripsi)
        kontenGambar = findViewById(R.id.unggah_foto)

        kontenDeskripsi.setText(getData.deskripsi)
        kontenGambar.setText("Change")

        oldImageUri = getData.image
        val uri = Uri.fromFile(oldImageUri)
        kontenImage.setImageURI(uri)
        kontenImage.visibility = View.VISIBLE


        onClick()
    }

    private fun onClick(){
        val btnSave = findViewById<MaterialButton>(R.id.tombol_update)
        btnSave.setOnClickListener {
            if(validateInput()){
                savedData()
            }
        }

        val openImagePicker = findViewById<TextInputEditText>(R.id.unggah_foto)
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


        val btnBack = findViewById<ImageButton>(R.id.back_button)
        btnBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun validateInput(): Boolean {
        var error = 0

        // Memeriksa apakah nama pemain kosong
        if (kontenDeskripsi.text.toString().isEmpty()) {
            error++
            kontenDeskripsi.error = "Nama pemain tidak boleh kosong"
        }


        // Memeriksa apakah gambar pemain kosong
        if (kontenGambar.text.toString().isEmpty()) {
            error++
            kontenGambar.error = "Gambar tidak boleh kosong"
        }

        // Mengembalikan true jika tidak ada error, false jika ada error
        return error == 0

    }

    private fun savedData() {
        // Mengubah URI gambar menjadi file dan mengurangi ukuran file
        val imageFile = currentImageUri?.let { uriToFile(it, this).reduceFileImage() }

        // Membuat objek pemain dengan data yang diinputkan
        val konten = (if (currentImageUri != null) imageFile else oldImageUri)?.let {
            kontenDatabase(
                id = getData.id,
                deskripsi = kontenDeskripsi.text.toString(),
                image = it
            )
        }

        // Menyimpan data pemain ke database
        if (konten != null) appViewModel.updateKonten(konten)

        // Menampilkan pesan bahwa data pemain berhasil ditambahkan
        Toast.makeText(
            this@UpdateKontenActivity,
            "Konten berhasil diubah",
            Toast.LENGTH_SHORT
        ).show()

        // Mengakhiri activity
        finish()
    }
}