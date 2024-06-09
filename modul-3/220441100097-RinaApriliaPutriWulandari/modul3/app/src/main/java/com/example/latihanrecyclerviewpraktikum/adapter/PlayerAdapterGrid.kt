package com.example.latihanrecyclerviewpraktikum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanrecyclerviewpraktikum.R
import com.example.latihanrecyclerviewpraktikum.data.PeopleData
import com.example.latihanrecyclerviewpraktikum.data.PlayerData
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class PlayerAdapterGrid (private val playerList: List<PeopleData>) : RecyclerView.Adapter<PlayerAdapterGrid.PlayerViewHolder>() {
    // Deklarasi variabel untuk callback ketika item diklik
    private lateinit var onItemClickCallback: OnItemClickCallback

    // Fungsi untuk mengatur callback ketika item diklik
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Interface untuk callback ketika item diklik
    interface OnItemClickCallback {
        fun onItemClicked(data: PeopleData)
    }

    // Kelas ViewHolder untuk menyimpan referensi view yang digunakan dalam RecyclerView
    class PlayerViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val peopleName: MaterialTextView = itemView.findViewById(R.id.people_name)
        val peopleDescription: MaterialTextView = itemView.findViewById(R.id.people_desc)
//        val playerImage: ShapeableImageView = itemView.findViewById(R.id.player_image)
    }

    // Fungsi untuk membuat ViewHolder (Melakukan setting untuk XML yang akan kita gunakan untuk menampilkan data)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        return PlayerViewHolder(view)
    }

    // Fungsi untuk mengikat data dengan ViewHolder (memasukkan data yang kita miliki ke dalam XML ViewHolder)
    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val data = playerList[position]

        holder.peopleName.text = data.name
        holder.peopleDescription.text = data.description.shorten(85)
//        holder.playerImage.setImageResource(data.image)

        // Mengatur aksi ketika item diklik
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(playerList[holder.adapterPosition]) }
    }

    // Fungsi untuk mendapatkan jumlah item
    override fun getItemCount(): Int = playerList.size

    // Fungsi untuk memendekkan teks jika melebihi panjang maksimum
    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}