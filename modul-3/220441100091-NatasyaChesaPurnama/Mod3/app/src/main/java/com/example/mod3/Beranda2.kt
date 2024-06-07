package com.example.mod3

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.TextView
import android.widget.Toast
import com.example.mod3.R
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView
import java.io.ByteArrayOutputStream

class Beranda2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda2)
        enableEdgeToEdge()

        val getDataName = intent.getStringExtra("nama")
        val getDataDescription = intent.getStringExtra("deskripsi")
        val getDataImage = intent.getIntExtra("gambar", 0)

        val namaHotel = findViewById<TextView>(R.id.nama)
        val deskripsi = findViewById<TextView>(R.id.dekripsi)
        val gambar = findViewById<ShapeableImageView>(R.id.img)

        namaHotel.text = getDataName
        deskripsi.text = getDataDescription
        gambar.setImageResource(getDataImage)

        val bShare = findViewById<ShapeableImageView>(R.id.share)

        bShare.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nama Tempat/Hotel: $getDataName\nDeskripsi: $getDataDescription")
                val foto = BitmapFactory.decodeResource(resources, getDataImage)
                type = "image/*"
                putExtra(Intent.EXTRA_STREAM, BitmapkeUri(foto))
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

    private fun BitmapkeUri(bitmap: Bitmap): Uri {
        val byte = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byte)
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