package com.example.modul4.room

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.File

@Entity
data class PostEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    val image: File,
    val likeCount: Int
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
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(image.path)
        parcel.writeInt(likeCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PostEntity> {
        override fun createFromParcel(parcel: Parcel): PostEntity {
            return PostEntity(parcel)
        }

        override fun newArray(size: Int): Array<PostEntity?> {
            return arrayOfNulls(size)
        }
    }
}
