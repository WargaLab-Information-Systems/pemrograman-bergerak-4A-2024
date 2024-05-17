package com.example.a22_039_bungaayusaputri.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a22_039_bungaayusaputri.Data.Wisata
import com.example.a22_039_bungaayusaputri.R
import com.google.android.material.imageview.ShapeableImageView

class ItemHorizontal (private val ListData: List<Wisata>) : RecyclerView.Adapter<ItemHorizontal.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Wisata)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namaTempat: TextView = itemView.findViewById(R.id.namatempat)
        val lokasiTempat: TextView = itemView.findViewById(R.id.lokasi)
        val gambar: ShapeableImageView = itemView.findViewById(R.id.fotowisata)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.wisata_horizontal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = ListData[position]

        holder.namaTempat.text = data.namatempat
        holder.lokasiTempat.text = data.lokasitempat
        holder.gambar.setImageResource(data.gambar)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(ListData[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = ListData.size

    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}