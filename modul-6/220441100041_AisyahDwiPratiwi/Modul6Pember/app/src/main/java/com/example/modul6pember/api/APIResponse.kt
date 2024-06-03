package com.example.modul6pember.api

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class APIResponse(

    // Anotasi SerializedName digunakan untuk mapping antara variabel dan field JSON saat proses serialisasi dan deserialisasi

    // Variabel "id" akan dipetakan ke field JSON "id"
    @field:SerializedName("id")
    val id: String,

    // Variabel "name" akan dipetakan ke field JSON "name"
    @field:SerializedName("name")
    val name: String,

    // Variabel "description" akan dipetakan ke field JSON "description"
    @field:SerializedName("description")
    val description: String,

    // Variabel "position" akan dipetakan ke field JSON "avatar"
    @field:SerializedName("position")
    val position: String,

    @field:SerializedName("goals")
    val goals: Int,

    @field:SerializedName("assists")
    val assists: Int,

    @field:SerializedName("ga")
    val ga: String,

    @field:SerializedName("number")
    val number: Int,

    @field:SerializedName("rating")
    val rating: Float,

    @field:SerializedName("club_logo")
    val clublogo: String,

    @field:SerializedName("player_image")
    val playerimage: String,

    @field:SerializedName("background_card")
    val backgroundcard: String,


) : Parcelable {
    // Konstruktor ini digunakan saat membaca data dari Parcel
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,  // Membaca string "id" dari Parcel
        parcel.readString()!!, // Membaca string "name" dari Parcel
        parcel.readString()!!, // Membaca string "description" dari Parcel
        parcel.readString()!!, // Membaca string "position" dari Parcel
        parcel.readInt(), // Membaca string "goals" dari Parcel
        parcel.readInt(), // Membaca string "assists" dari Parcel
        parcel.readString()!!, // Membaca string "ga" dari Parcel
        parcel.readInt(), // Membaca string "number" dari Parcel
        parcel.readFloat(), // Membaca string "rating" dari Parcel
        parcel.readString()!!, // Membaca string "clublogo" dari Parcel
        parcel.readString()!!, // Membaca string "playerimage" dari Parcel
        parcel.readString()!!, // Membaca string "backgroundcard" dari Parcel
    )

    // Fungsi ini digunakan untuk menulis data ke Parcel
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id) // Menulis string "id" ke Parcel
        dest.writeString(name) // Menulis string "name" ke Parcel
        dest.writeString(description) // Menulis string "description" ke Parcel
        dest.writeString(position) // Menulis string "position" ke Parcel
        dest.writeInt(goals) // Menulis string "goals" ke Parcel
        dest.writeInt(assists) // Menulis string "assists" ke Parcel
        dest.writeString(ga) // Menulis string "ga" ke Parcel
        dest.writeInt(number) // Menulis string "number" ke Parcel
        dest.writeFloat(rating) // Menulis string "rating" ke Parcel
        dest.writeString(clublogo) // Menulis string "clublogo" ke Parcel
        dest.writeString(playerimage) // Menulis string "playerimage" ke Parcel
        dest.writeString(backgroundcard) // Menulis string "backgroundcard" ke Parcel
    }

    // Fungsi ini digunakan untuk mendeskripsikan jenis konten khusus yang ditangani oleh Parcelable instance
    override fun describeContents(): Int {
        return 0
    }

    // Objek CREATOR digunakan untuk membuat instance baru dari Parcelable class, baik dari Parcel yang telah ada atau array baru
    companion object CREATOR : Parcelable.Creator<APIResponse> {
        // Membuat instance baru dari Parcelable class dari Parcel yang telah ada
        override fun createFromParcel(parcel: Parcel): APIResponse {
            return APIResponse(parcel)
        }

        // Membuat array baru dari Parcelable class
        override fun newArray(size: Int): Array<APIResponse?> {
            return arrayOfNulls(size)
        }
    }
}

data class PlayerResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("count")
    val count: Int,

    @SerializedName("data")
    val data: List<APIResponse>
)