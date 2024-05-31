package com.example.modul4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.io.File

class UpdatePostActivity : AppCompatActivity() {

    private var currentImageUri: Uri? = null
    private var oldPhoto: File? = null

    private lateinit var postViewModel: PostViewModel
    private lateinit var vPostDesc: TextInputEditText
    private lateinit var vPostImage: ImageView
    private lateinit var vGetDataPost: PostDatabase
    private lateinit var vText_img: TextView

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_posting)

        vGetDataPost = intent.getParcelableExtra("Posting")!!

        val factory = PostViewModelFactory.getInstance(this)
        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]

        vPostImage = findViewById(R.id.post_img_edit)
        vPostDesc = findViewById(R.id.post_desc_edit)
        vText_img = findViewById(R.id.text_img)

        vPostDesc.setText(vGetDataPost.description)
        vText_img.setText("Gambar Berhasil ditambahakan")



        oldPhoto = vGetDataPost.image

        Glide.with(vPostImage)
            .load(vGetDataPost.image)
            .into(vPostImage)

        onClick()
    }

    private fun onClick(){
        val saveBtn = findViewById<Button>(R.id.btn_savedPost)
        saveBtn.setOnClickListener{

            if(validateInput()) {
                saveData()
            }
        }

//        vText_img.setOnClickListener {
//            imagePickerLauncher.launch(
//                ImagePickerConfig {
//                    mode = ImagePickerMode.SINGLE
//                    returnMode = ReturnMode.ALL
//                    isFolderMode = true
//                    folderTitle = "Galeri"
//                    isShowCamera = false
//                    imageTitle = "Click to choice the image"
//                    doneButtonText = "Done"
//                }
//            )
//        }

        val openImagePicker = findViewById<TextView>(R.id.text_img)
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

    private fun validateInput() : Boolean {
        var error = 0

        if (vPostDesc.text.toString().isEmpty()) {
            error++
            vPostDesc.error = "Deskripsi tidak boleh kosong!"
        }
        if (vText_img.text.toString() == "add") {
            error++
            vText_img.error = "Gambar tidak boleh kosong!"
        }

        return error == 0

    }

    private fun saveData() {

        val imageFile = currentImageUri?.let { uriToFile(it, this).reduceFileImage() }


//        val post = imageFile?.let {
//            val descriptionText = vPostDesc.text.toString()
//            val words = descriptionText.split(" ")
//            val firstTwoWords = words.take(2).joinToString(" ")
//            PostDatabase(
//                id = vGetDataPost.id,
//                name = firstTwoWords,
//                description = vPostDesc.toString(),
//                image = imageFile,
//            )
//        }

        val post = (if (currentImageUri != null) imageFile else oldPhoto)?.let {
            PostDatabase(
                id = vGetDataPost.id,
                name = vPostDesc.text.toString(),
                description = vPostDesc.text.toString(),
                image = it
            )
        }

        if (post != null) postViewModel.updatePost(post)

        Toast.makeText(
            this@UpdatePostActivity,
            "Sukses Memperbarui!",
            Toast.LENGTH_SHORT
        ).show()

        finish()

    }
    fun toMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}