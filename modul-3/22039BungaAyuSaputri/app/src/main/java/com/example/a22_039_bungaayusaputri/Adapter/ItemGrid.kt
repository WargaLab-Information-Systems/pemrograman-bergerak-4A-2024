package com.example.a22_039_bungaayusaputri.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a22_039_bungaayusaputri.Data.Hotel
import com.example.a22_039_bungaayusaputri.R
import com.google.android.material.imageview.ShapeableImageView

class ItemGrid (private val ListData: List<Hotel>) : RecyclerView.Adapter<ItemGrid.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hotel)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namaHotel: TextView = itemView.findViewById(R.id.namahotel)
        val pengunjung: TextView = itemView.findViewById(R.id.pengunjung)
        val rating: TextView = itemView.findViewById(R.id.rating)
        val gambar: ShapeableImageView = itemView.findViewById(R.id.fotohotel)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.hotel_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = ListData[position]

        holder.namaHotel.text = data.namahotel
        holder.pengunjung.text = data.jumlahpengunjung.toString()
        holder.rating.text = data.jumlahrating.toString()
        holder.gambar.setImageResource(data.gambar)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(ListData[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = ListData.size

    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}