package com.example.tugasmodul6

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
import com.example.tugasmodul6.remote.Player

class PlayerAdapter(private var players: List<Player>) :
    RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    // Deklarasi variabel untuk callback ketika item diklik
    private lateinit var onItemClickCallback: OnItemClickCallback

    // Fungsi untuk mengatur callback ketika item diklik
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Interface untuk callback ketika item diklik
    interface OnItemClickCallback {
        fun onItemClicked(data: Player)
    }

    // Kelas ViewHolder untuk menyimpan referensi view yang digunakan dalam RecyclerView
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val backgroundCard: ConstraintLayout = itemView.findViewById(R.id.player_container)
        val playerImage: ImageView = itemView.findViewById(R.id.player_image)
        val clubLogo: ImageView = itemView.findViewById(R.id.club_logo)

        val playerRating: TextView = itemView.findViewById(R.id.player_rating)
        val playerNumber:TextView = itemView.findViewById(R.id.player_number)
        val playerName: TextView = itemView.findViewById(R.id.player_name)
        val playerPosition: TextView = itemView.findViewById(R.id.player_position)
        val playerGa: TextView = itemView.findViewById(R.id.player_ga)

    }

    // Fungsi untuk membuat ViewHolder (Melakukan setting untuk XML yang akan kita gunakan untuk menampilkan data)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_player_room, parent, false)
        return ViewHolder(view)
    }

    // Fungsi untuk mengikat data dengan ViewHolder (memasukkan data yang kita miliki ke dalam XML ViewHolder)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = players[position]

        holder.playerRating.text = data.rating.toString()
        holder.playerNumber.text = "#" + data.number.toString()
        holder.playerName.text = splitPlayerName(data.name)
        holder.playerPosition.text = data.position
        holder.playerGa.text = data.ga
        holder.playerImage.loadImage(data.player_image)
        holder.clubLogo.loadImage(data.club_logo)

        // Mengatur image
        Glide.with(holder.backgroundCard.context)
            .load(data.background_card) // replace with your image URL
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in
                Drawable>?) {
                    holder.backgroundCard.background = resource
                }
                override fun onLoadCleared(placeholder: Drawable?) {
                    // handle cleanup here
                }
            })
        // Mengatur aksi ketika item diklik
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(players[holder.absoluteAdapterPosition]) }
    }

    // Fungsi untuk mendapatkan jumlah item
    override fun getItemCount(): Int = players.size

    private fun ImageView.loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    this@loadImage.setImageDrawable(resource)
                }
                override fun onLoadCleared(placeholder: Drawable?) {
                    // handle cleanup here
                }
            })
    }

    private fun splitPlayerName(name: String): String {
        return if (name.contains(" ")) {
            name.replaceFirst(" ", "\n")
        } else {
            name
        }
    }
}