package com.example.modul6.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.modul6.R
import com.example.modul6.data.PlayerData
import com.google.android.material.imageview.ShapeableImageView

class PlayerAdapter (private var player: List<PlayerData>) : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {
    // Deklarasi variabel untuk callback ketika item diklik
    private lateinit var onItemClickCallback: OnItemClickCallback

    // Fungsi untuk mengatur callback ketika item diklik
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Interface untuk callback ketika item diklik
    interface OnItemClickCallback {
        fun onItemClicked(data: PlayerData)
    }

    // Kelas ViewHolder untuk menyimpan referensi view yang digunakan dalam RecyclerView
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerName: TextView = itemView.findViewById(R.id.nama_pemain)
        val playerPosition: TextView = itemView.findViewById(R.id.posisi)
        val playerGa: TextView = itemView.findViewById(R.id.ga_pemain)
        val playerNumber: TextView = itemView.findViewById(R.id.num_pemain)
        val playerRating: TextView = itemView.findViewById(R.id.rate_pemain)

        val playerClubLogo: ShapeableImageView = itemView.findViewById(R.id.logo_club)
        val playerImage: ImageView = itemView.findViewById(R.id.img_pemain)
        val background: ConstraintLayout = itemView.findViewById(R.id.background)
    }

    // Fungsi untuk membuat ViewHolder (Melakukan setting untuk XML yang akan kita gunakan untuk menampilkan data)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pemain, parent, false)
        return ViewHolder(view)
    }

    // Fungsi untuk mengikat data dengan ViewHolder (memasukkan data yang kita miliki ke dalam XML ViewHolder)
    // nah ni buat nyimpen isinya ygy

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = player[position]

        holder.playerName.text = data.name
        holder.playerPosition.text = data.position
        holder.playerGa.text = data.ga
        holder.playerNumber.text = "#"+data.number.toString()
        holder.playerRating.text = data.rating.toString()

        Glide.with(holder.playerClubLogo.context)
            .load(data.club_logo)
            .into(holder.playerClubLogo)
        Glide.with(holder.playerImage.context)
            .load(data.player_image)
            .into(holder.playerImage)
        Glide.with(holder.background.context)
            .load(data.background_card)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    holder.background.background = resource
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                }
            })

        // Mengatur aksi ketika item diklik
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(player[holder.absoluteAdapterPosition]) }
    }

    // Fungsi untuk mendapatkan jumlah item
    override fun getItemCount(): Int = player.size

    // Fungsi untuk memendekkan teks jika melebihi panjang maksimum
    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}
