package com.example.mod3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mod3.R
import com.example.mod3.Data.DataHotel
import com.google.android.material.imageview.ShapeableImageView

class ItemGrid (private val ListData: List<DataHotel>) : RecyclerView.Adapter<ItemGrid.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataHotel)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namaHotel: TextView = itemView.findViewById(R.id.nama_hotel)
        val pengunjung: TextView = itemView.findViewById(R.id.pengunjung)
        val rating: TextView = itemView.findViewById(R.id.rating)
        val gambar: ShapeableImageView = itemView.findViewById(R.id.pict_hotel)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_hotel_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = ListData[position]

        holder.namaHotel.text = data.namaHotel
        holder.pengunjung.text = data.jumlahPengunjung.toString()
        holder.rating.text = data.jumlahRating.toString()
        holder.gambar.setImageResource(data.gambar)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(ListData[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = ListData.size

    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}