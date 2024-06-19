package com.example.modul4.room

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.File
/**
 * Kelas PostDatabase adalah kelas data yang berfungsi sebagai entitas dalam database Room.
 * Kelas ini memiliki beberapa properti yang mewakili kolom dalam tabel database.
 *
 * Anotasi @Entity digunakan untuk memberi tahu Room bahwa kelas ini adalah tabel dalam database.
 *
 * Anotasi @PrimaryKey digunakan untuk menentukan bahwa properti id adalah kunci utama dalam tabel.
 * autoGenerate = true berarti Room akan menghasilkan nilai id secara otomatis setiap kali kita memasukkan entitas baru ke dalam tabel.
 *
 * Anotasi @ColumnInfo digunakan untuk menentukan nama kolom dalam tabel.
 *
 * Kelas ini juga mengimplementasikan Parcelable, yang memungkinkan kita untuk mempassing objek PlayerEntity antar komponen Android.
 */
// buat entity / data class baru sebagai tabel dari database yang di buat
@Entity
data class PostDatabase(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "post_title")
    val name: String,

    @ColumnInfo(name = "post_desc")
    val description: String,

    @ColumnInfo(name = "post_image")
    val image: File,

    @ColumnInfo(name = "post_like")
    var like: Int = 0,


) : Parcelable {
    // Konstruktor sekunder untuk membuat objek PostDatabase dari Parcel
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        File(parcel.readString()!!),
        parcel.readInt(),
    )
    // Fungsi untuk menulis data objek PostDatabase ke Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(image.path)
        parcel.writeInt(like)
    }
    // Fungsi untuk mendeskripsikan jenis konten khusus yang ditangani oleh Parcelable
    override fun describeContents(): Int {
        return 0
    }
    // Objek pendamping untuk PostDatabase yang berisi fungsi untuk membuat objek PostDatabase dari Parcel dan Array
    companion object CREATOR : Parcelable.Creator<PostDatabase> {
        override fun createFromParcel(parcel: Parcel): PostDatabase {
            return PostDatabase(parcel)
        }
        // Fungsi untuk membuat array dari objek PostDatabase
        override fun newArray(size: Int): Array<PostDatabase?> {
            return arrayOfNulls(size)
        }
    }
}