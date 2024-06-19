package com.example.a039_bunga_modul4.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a039_bunga_modul4.R
import com.example.a039_bunga_modul4.room.PostEntity
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class PostAdapterRoom (private var postList: List<PostEntity>) :
    RecyclerView.Adapter<PostAdapterRoom.PeopleViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: PostEntity)
        fun onItemMore(data: PostEntity)
    }

    // Kelas ViewHolder untuk menyimpan referensi view yang digunakan dalam RecyclerView
    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val judul: MaterialTextView = itemView.findViewById(R.id.judul)
        val deskripsi: MaterialTextView = itemView.findViewById(R.id.deskripsipost)
        val fotopostt: ShapeableImageView = itemView.findViewById(R.id.imgpost)
        val bsuka: ImageView = itemView.findViewById(R.id.love)
        val bsuka2: TextView = itemView.findViewById(R.id.love2)
        val btitik3: ImageView = itemView.findViewById(R.id.menu)
        val waktu: TextView = itemView.findViewById(R.id.waktupost)

    }

    // Fungsi untuk membuat ViewHolder (Melakukan setting untuk XML yang akan kita gunakan untuk menampilkan data)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeopleViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
        return PeopleViewHolder(view)
    }

    // Fungsi untuk mengikat data dengan ViewHolder (memasukkan data yang kita miliki ke dalam XML ViewHolder)
    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val data = postList[position]

        holder.judul.text = data.name
        holder.deskripsi.text = data.description.shorten(85)

        // Mengatur image
        val uri = Uri.fromFile(data.image)
        holder.fotopostt.setImageURI(uri)

        // Mengatur aksi ketika item diklik
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(postList[holder.absoluteAdapterPosition]) }
        holder.btitik3.setOnClickListener { onItemClickCallback.onItemMore(postList[holder.bindingAdapterPosition]) }

        var isLiked = false // variabel untuk menandai apakah tombol "like" sudah ditekan atau belum
        var like = holder.bsuka2.text.toString().toInt()

        holder.bsuka.setOnClickListener {
            if (!isLiked) {
                like++
                holder.bsuka2.text = like.toString()
                holder.bsuka.setImageResource(R.drawable.ic_love2) // mengubah sumber daya ImageView menjadi versi merah
                isLiked = true // Setelah tombol "like" ditekan, tandai bahwa sudah ditekan
            } else {
                like++
                holder.bsuka2.text = like.toString()
                holder.bsuka.setImageResource(R.drawable.ic_love) // mengubah sumber daya ImageView menjadi versi putih
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
