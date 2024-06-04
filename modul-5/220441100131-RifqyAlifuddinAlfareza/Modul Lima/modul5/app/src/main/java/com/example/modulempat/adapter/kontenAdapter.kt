package com.example.modulempat.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modulempat.R
import com.example.modulempat.room.kontenDatabase
import com.google.android.material.imageview.ShapeableImageView

class kontenAdapter(private val kontenList: List<kontenDatabase>) : RecyclerView.Adapter<kontenAdapter.kontenViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onMoreClicked(data: kontenDatabase, position: Int)
    }

    class kontenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val deskripsi: TextView = itemView.findViewById(R.id.deskripsi_konten)
        val gambar: ShapeableImageView = itemView.findViewById(R.id.gambar_konten)
        var like: TextView = itemView.findViewById(R.id.likefield)
        val btnLike: ImageButton = itemView.findViewById(R.id.like_button)
        var isClik = false
        val btnMore: ImageButton = itemView.findViewById(R.id.btnMore)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): kontenViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.konten, parent, false)
        return kontenViewHolder(view)
    }

    override fun onBindViewHolder(holder: kontenViewHolder, position: Int) {
        val data = kontenList[position]

        holder.deskripsi.text = data.deskripsi
        holder.like.text = data.like.toString()

        val uri = Uri.fromFile(data.image)
        holder.gambar.setImageURI(uri)

        holder.btnMore.setOnClickListener { onItemClickCallback.onMoreClicked(kontenList[holder.absoluteAdapterPosition], holder.absoluteAdapterPosition) }

        holder.btnLike.setOnClickListener {
            if (holder.isClik == false){
                holder.like.text = "1"

                holder.isClik = true
                return@setOnClickListener
            }else{
                holder.like.text = "0"
                holder.isClik = false
                return@setOnClickListener
            }
        }

//
//        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(kontenList[holder.ab])}
    }

    override fun getItemCount(): Int = kontenList.size



}