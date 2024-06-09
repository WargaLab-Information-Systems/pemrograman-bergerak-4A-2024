package com.example.latihanrecyclerviewpraktikum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanrecyclerviewpraktikum.R
import com.example.latihanrecyclerviewpraktikum.data.TravelData
import com.google.android.material.imageview.ShapeableImageView

class Horizontal (private val ListData: List<TravelData>) : RecyclerView.Adapter<Horizontal.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TravelData)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val NamaTempat: TextView = itemView.findViewById(R.id.nama_tempat)
        val LokasiTempat: TextView = itemView.findViewById(R.id.lokasi)
        val Gambar: ShapeableImageView = itemView.findViewById(R.id.pict_wisata)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = ListData[position]

        holder.NamaTempat.text = data.NamaTempat
        holder.LokasiTempat.text = data.LokasiTempat
        holder.Gambar.setImageResource(data.Gambar)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(ListData[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = ListData.size

    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}