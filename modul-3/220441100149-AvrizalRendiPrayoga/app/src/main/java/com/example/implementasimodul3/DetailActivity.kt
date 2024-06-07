package com.example.implementasimodul3

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import androidx.core.content.FileProvider
import android.graphics.drawable.BitmapDrawable

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra("name")
        val desc = intent.getStringExtra("description")
        val image = intent.getIntExtra("image", 0)

        val displayName = findViewById<TextView>(R.id.judul_detail)
        val displayDesc = findViewById<TextView>(R.id.detail_desc)
        val displayImage = findViewById<ImageView>(R.id.detail_image)

        displayName.text = name
        displayDesc.text = desc
        displayImage.setImageResource(image)

        // Mendapatkan referensi ke tombol bagikan
        val btnShare = findViewById<ImageButton>(R.id.btn_share)

        // Menetapkan aksi ketika tombol bagikan diklik
        btnShare.setOnClickListener {

            // Simpan gambar ke cache directory
            val imageUri = saveImageToCache(image)

            if (imageUri != null) {
                // Membuat intent untuk berbagi gambar dan teks
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_STREAM, imageUri)
                    putExtra(Intent.EXTRA_TEXT, "$name\n\n$desc")
                    type = "image/*"
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }


                // Memeriksa apakah WhatsApp terinstal
                val whatsappInstalled =
                    isPackageInstalled("com.whatsapp") || isPackageInstalled("com.whatsapp.w4b")
                if (whatsappInstalled) {

                    // Jika WhatsApp terinstal, atur paket intent ke "com.whatsapp" dan mulai activity
                    sendIntent.setPackage("com.whatsapp")
                    startActivity(sendIntent)
                } else {

                    // Jika WhatsApp tidak terinstal, tampilkan pesan toast
                    Toast.makeText(this, "WhatsApp tidak terinstal.", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Tampilkan pesan kesalahan jika URI gambar null
                Toast.makeText(this, "Gagal menyimpan gambar.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Fungsi untuk memeriksa apakah paket tertentu terinstal
    private fun isPackageInstalled(packageName: String): Boolean {
        return try {
            // Mencoba mendapatkan informasi paket
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            // Jika paket tidak ditemukan, kembalikan false
            false
        }
    }

    // Fungsi untuk menyimpan gambar ke cache directory dan mendapatkan URI
    private fun saveImageToCache(imageResId: Int): Uri? {
        return try {
            val drawable = resources.getDrawable(imageResId, null)
            val bitmap = (drawable as BitmapDrawable).bitmap
            val cachePath = File(cacheDir, "images")
            cachePath.mkdirs()
            val file = File(cachePath, "shared_image.png")
            val fileOutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
            fileOutputStream.close()
            FileProvider.getUriForFile(this, "${applicationContext.packageName}.fileprovider", file)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}