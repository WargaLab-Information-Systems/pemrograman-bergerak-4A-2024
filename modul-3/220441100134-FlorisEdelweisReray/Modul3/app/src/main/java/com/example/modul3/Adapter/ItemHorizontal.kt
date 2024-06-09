package com.example.modul3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul3.Data.DataWisata
import com.example.modul3.R
import com.google.android.material.imageview.ShapeableImageView

class ItemHorizontal (private val ListData: List<DataWisata>) : RecyclerView.Adapter<ItemHorizontal.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataWisata)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namaTempat: TextView = itemView.findViewById(R.id.nama_tempat)
        val lokasiTempat: TextView = itemView.findViewById(R.id.lokasi)
        val gambar: ShapeableImageView = itemView.findViewById(R.id.pict_wisata)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata_horizontal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = ListData[position]

        holder.namaTempat.text = data.namaTempat
        holder.lokasiTempat.text = data.lokasiTempat
        holder.gambar.setImageResource(data.gambar)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(ListData[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = ListData.size

    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}