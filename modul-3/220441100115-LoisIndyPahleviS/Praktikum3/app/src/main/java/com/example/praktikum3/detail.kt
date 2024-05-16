package com.example.praktikum3

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import java.io.ByteArrayOutputStream

class detail: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Mengambil data nama, deskripsi, dan gambar dari intent
        val getDataName = intent.getStringExtra("name")
        val getDataDescription = intent.getStringExtra("description")
        val getDataImage = intent.getIntExtra("image", 0)

        // Menghubungkan variabel dengan komponen di layout
        val playerName = findViewById<MaterialTextView>(R.id.player_name1)
        val playerDescription = findViewById<MaterialTextView>(R.id.player_description)
        val playerImage = findViewById<ShapeableImageView>(R.id.player_image)

        // Menampilkan data pemain
        playerName.text = getDataName
        playerDescription.text = getDataDescription
        playerImage.setImageResource(getDataImage)

        // Mendapatkan referensi ke tombol bagikan
        val btnShare = findViewById<ImageButton>(R.id.bagikan_btn1)
        val imageView: ImageView = findViewById(R.id.player_image)

// Mendapatkan Drawable dari ImageView
        val drawable: Drawable? = imageView.drawable

        // Menetapkan aksi ketika tombol bagikan diklik
        btnShare.setOnClickListener {

            // Jika drawable tidak null, Anda dapat mengonversinya menjadi Bitmap
            if (drawable != null) {
                val bitmap: Bitmap = (drawable as BitmapDrawable).bitmap

                // Sekarang Anda dapat menggunakan bitmap ini dalam Intent untuk dibagikan
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "$getDataName, $getDataDescription")
                    putExtra(Intent.EXTRA_STREAM, getImageUri(this@detail, bitmap))
                    type = "image/*"
                }

                // Memulai aktivitas untuk memilih aplikasi untuk berbagi
                startActivity(Intent.createChooser(sendIntent, "Bagikan Konten Menggunakan:"))
            } else {
                // Handle jika drawable null
                Toast.makeText(this, "Gambar tidak tersedia", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun getImageUri(context: Context, bitmap: Bitmap): Uri? {
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path = MediaStore.Images.Media.insertImage(context.contentResolver, bitmap, "Title", null)
        return Uri.parse(path)
    }
}