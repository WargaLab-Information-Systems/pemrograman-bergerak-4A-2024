package com.example.modul6pember.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.modul6pember.api.APIResponse
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.example.modul6pember.R

class MainAdapter(private var playerList: List<APIResponse>) :
    RecyclerView.Adapter<MainAdapter.PlayerViewHolder>() {

    // Deklarasi variabel untuk callback ketika item diklik
    private lateinit var onItemClickCallback: OnItemClickCallback

    // Fungsi untuk mengatur callback ketika item diklik
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Interface untuk callback ketika item diklik
    interface OnItemClickCallback {
        fun onItemClicked(data: APIResponse)
    }

    // Kelas ViewHolder untuk menyimpan referensi view yang digunakan dalam RecyclerView
    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerName: TextView = itemView.findViewById(R.id.name)
        val playerPosition: TextView = itemView.findViewById(R.id.position)
        val playerGa: TextView = itemView.findViewById(R.id.goalassist)
        val playerNumber: TextView = itemView.findViewById(R.id.number)
        val playerRating: TextView = itemView.findViewById(R.id.rating)
        val playerClub: ShapeableImageView = itemView.findViewById(R.id.club_logo)
        val playerImage: ShapeableImageView = itemView.findViewById(R.id.player_image)
        val playerBackground: ShapeableImageView = itemView.findViewById(R.id.background)
    }

    // Fungsi untuk membuat ViewHolder (Melakukan setting untuk XML yang akan kita gunakan untuk menampilkan data)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.player_layout, parent, false)
        return PlayerViewHolder(view)
    }

    // Fungsi untuk mengikat data dengan ViewHolder (memasukkan data yang kita miliki ke dalam XML ViewHolder)
    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val data = playerList[position]

        holder.playerName.text = data.name
        holder.playerPosition.text = data.position
        holder.playerGa.text = data.ga
        holder.playerNumber.text = data.number.toString()
        holder.playerRating.text = data.rating.toString()

        // Mengatur image
        Glide.with(holder.playerClub)
            .load(data.clublogo)
            .into(holder.playerClub)

        Glide.with(holder.playerImage)
            .load(data.playerimage)
            .into(holder.playerImage)

        Glide.with(holder.playerBackground)
            .load(data.backgroundcard)
            .into(holder.playerBackground)

        // Mengatur aksi ketika item diklik
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(playerList[holder.absoluteAdapterPosition]) }
    }

    // Fungsi untuk mendapatkan jumlah item
    override fun getItemCount(): Int = playerList.size

    // Fungsi untuk memendekkan teks jika melebihi panjang maksimum
    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}