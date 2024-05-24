package com.example.mod4.room

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.File

@Entity
data class PostEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val judul: String,
    val desc: String,
    val image: File,
    val like: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        File(parcel.readString() ?: "",),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(judul)
        parcel.writeString(desc)
        parcel.writeString(image.path)
        parcel.writeInt(like)
    }

    // Fungsi untuk mendeskripsikan jenis konten khusus yang ditangani oleh Parcelable
    override fun describeContents(): Int {
        return 0
    }

    // Objek pendamping untuk PlayerDatabase yang berisi fungsi untuk membuat objek PlayerDatabase dari Parcel dan Array
    companion object CREATOR : Parcelable.Creator<PostEntity> {
        // Fungsi untuk membuat objek PlayerDatabase dari Parcel
        override fun createFromParcel(parcel: Parcel): PostEntity {
            return PostEntity(parcel)
        }

        // Fungsi untuk membuat array dari objek PlayerDatabase
        override fun newArray(size: Int): Array<PostEntity?> {
            return arrayOfNulls(size)
        }
    }
}
