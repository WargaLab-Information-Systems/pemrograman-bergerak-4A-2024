package com.example.modul4.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul4.R
import com.example.modul4.room.PostEntity
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class PostAdapterRoom (private var postList: List<PostEntity>) :
    RecyclerView.Adapter<PostAdapterRoom.PeopleViewHolder>() {

    // Deklarasi variabel untuk callback ketika item diklik
    private lateinit var onItemClickCallback: OnItemClickCallback

    // Fungsi untuk mengatur callback ketika item diklik
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Interface untuk callback ketika item diklik
    interface OnItemClickCallback {
        fun onItemClicked(data: PostEntity)
        fun onItemMore(data: PostEntity)
    }

    // Kelas ViewHolder untuk menyimpan referensi view yang digunakan dalam RecyclerView
    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val PeopleName: MaterialTextView = itemView.findViewById(R.id.judul)
        val PeopleDescription: MaterialTextView = itemView.findViewById(R.id.descpost)
        val PeopleImage: ShapeableImageView = itemView.findViewById(R.id.imgpost)
        val loveImageView: ImageView = itemView.findViewById(R.id.love)
        val likeTextView: TextView = itemView.findViewById(R.id.like)
        val bMore: ImageView = itemView.findViewById(R.id.menu)
    }

    // Fungsi untuk membuat ViewHolder (Melakukan setting untuk XML yang akan kita gunakan untuk menampilkan data)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeopleViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_postingan, parent, false)
        return PeopleViewHolder(view)
    }

    // Fungsi untuk mengikat data dengan ViewHolder (memasukkan data yang kita miliki ke dalam XML ViewHolder)
    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val data = postList[position]

        holder.PeopleName.text = data.name
        holder.PeopleDescription.text = data.description.shorten(85)

        // Mengatur image
        val uri = Uri.fromFile(data.image)
        holder.PeopleImage.setImageURI(uri)

        // Mengatur aksi ketika item diklik
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(postList[holder.absoluteAdapterPosition]) }
        holder.bMore.setOnClickListener { onItemClickCallback.onItemMore(postList[holder.bindingAdapterPosition]) }

        var isLiked = false // variabel untuk menandai apakah tombol "like" sudah ditekan atau belum
        var like = holder.likeTextView.text.toString().toInt()

        holder.loveImageView.setOnClickListener {
            if (!isLiked) {
                like++
                holder.likeTextView.text = like.toString()
                holder.loveImageView.setImageResource(R.drawable.ic_love2) // mengubah sumber daya ImageView menjadi versi merah
                isLiked = true // Setelah tombol "like" ditekan, tandai bahwa sudah ditekan
            } else {
                like--
                holder.likeTextView.text = like.toString()
                holder.loveImageView.setImageResource(R.drawable.ic_love) // mengubah sumber daya ImageView menjadi versi putih
                isLiked = false // Setelah tombol "like" ditekan kembali, tandai bahwa sudah tidak ditekan
            }
        }
    }

    // Fungsi untuk mendapatkan jumlah item
    override fun getItemCount(): Int = postList.size

    // Fungsi untuk memendekkan teks jika melebihi panjang maksimum
    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..." }
}