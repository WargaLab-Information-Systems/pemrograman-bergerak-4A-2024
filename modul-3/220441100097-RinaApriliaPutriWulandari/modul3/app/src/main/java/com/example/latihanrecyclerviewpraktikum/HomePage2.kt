package com.example.latihanrecyclerviewpraktikum

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.google.android.material.imageview.ShapeableImageView
import java.io.ByteArrayOutputStream

class HomePage2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page2)
        enableEdgeToEdge()

        val getDataName = intent.getStringExtra("nama")
        val getDataDescription = intent.getStringExtra("deskripsi")
        val getDataImage = intent.getIntExtra("gambar", 0)

        val NamaHotel = findViewById<TextView>(R.id.nama)
        val Deskripsi = findViewById<TextView>(R.id.dekripsi)
        val Gambar = findViewById<ShapeableImageView>(R.id.img)

        NamaHotel.text = getDataName
        Deskripsi.text = getDataDescription
        Gambar.setImageResource(getDataImage)

        val btnShare = findViewById<ShapeableImageView>(R.id.share)

        btnShare.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nama Tempat/Hotel: $getDataName\nDeskripsi: $getDataDescription")
                val foto = BitmapFactory.decodeResource(resources, getDataImage)
                type = "image/*"
                putExtra(Intent.EXTRA_STREAM, getUriFromBitmap(foto))
            }

            val whatsappInstalled =
                isPackageInstalled("com.whatsapp") || isPackageInstalled("com.whatsapp.web")
            if (whatsappInstalled) {
                sendIntent.setPackage("com.whatsapp")
                startActivity(sendIntent)
            } else {
                Toast.makeText(this, "WhatsApp tidak terinstal.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getUriFromBitmap(bitmap: Bitmap): Uri? {
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path = MediaStore.Images.Media.insertImage(contentResolver, bitmap,null,null)
        return Uri.parse(path)
    }

    private fun isPackageInstalled(packageName: String): Boolean {
        return try {
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}