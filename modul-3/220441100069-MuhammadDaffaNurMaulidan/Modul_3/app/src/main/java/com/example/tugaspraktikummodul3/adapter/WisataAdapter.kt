package com.example.tugaspraktikummodul3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspraktikummodul3.R
import com.example.tugaspraktikummodul3.data.DataWisata
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class WisataAdapter (private val playerList: ArrayList<DataWisata>) : RecyclerView.Adapter<WisataAdapter.PlayerViewHolder>() {

        // Deklarasi variabel untuk callback ketika item diklik
        private lateinit var onItemClickCallback: OnItemClickCallback

        // Fungsi untuk mengatur callback ketika item diklik
        fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback
        }

        // Interface untuk callback ketika item diklik
        interface OnItemClickCallback {
            fun onItemClicked(data: DataWisata)
        }

        // Kelas ViewHolder untuk menyimpan referensi view yang digunakan dalam RecyclerView
        class PlayerViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
            val wisataName: MaterialTextView = itemView.findViewById(R.id.wisata_name)
            val wisataDescription: MaterialTextView = itemView.findViewById(R.id.location_value)
            val wisataImage: ShapeableImageView = itemView.findViewById(R.id.wisata_picture)

        }

        // Fungsi untuk membuat ViewHolder (Melakukan setting untuk XML yang akan kita gunakan untuk menampilkan data)
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): PlayerViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
            return PlayerViewHolder(view)
        }

        // Fungsi untuk mengikat data dengan ViewHolder (memasukkan data yang kita miliki ke dalam XML ViewHolder)
        override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
            val data = playerList[position]

            holder.wisataName.text = data.name
            holder.wisataDescription.text = data.location
            holder.wisataImage.setImageResource(data.image)

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
