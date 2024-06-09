package com.example.latihanrecyclerviewpraktikum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanrecyclerviewpraktikum.R
import com.example.latihanrecyclerviewpraktikum.data.HotelData
import com.google.android.material.imageview.ShapeableImageView

class Grid (private val ListData: List<HotelData>) : RecyclerView.Adapter<Grid.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: HotelData)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val NamaHotel: TextView = itemView.findViewById(R.id.nama_hotel)
        val Pengunjung: TextView = itemView.findViewById(R.id.pengunjung)
        val Rating: TextView = itemView.findViewById(R.id.rating)
        val Gambar: ShapeableImageView = itemView.findViewById(R.id.pict_hotel)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = ListData[position]

        holder.NamaHotel.text = data.NamaHotel
        holder.Pengunjung.text = data.JumlahPengunjung.toString()
        holder.Rating.text = data.JumlahRating.toString()
        holder.Gambar.setImageResource(data.Gambar)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(ListData[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = ListData.size

    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}