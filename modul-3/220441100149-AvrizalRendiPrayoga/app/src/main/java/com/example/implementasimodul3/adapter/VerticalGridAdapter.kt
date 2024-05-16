package com.example.implementasimodul3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.implementasimodul3.R
import com.example.implementasimodul3.datamodel.HotelModel
import com.example.implementasimodul3.datamodel.PlaceModel

class VerticalGridAdapter(

    private val listHotel: List<HotelModel>,
    private val listener: OnAdapterListener

): RecyclerView.Adapter<VerticalGridAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_grid_vertikal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hotel =  listHotel[position]
        holder.textTitle.text = hotel.name
        holder.textVisitor.text = hotel.visitor.toString()
        holder.textRating.text = hotel.rating.toString()
        holder.image.setImageResource(hotel.image)
        holder.itemView.setOnClickListener {
            listener.onClick(hotel)
        }
    }

    override fun getItemCount() = listHotel.size
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textTitle= view.findViewById<TextView>(R.id.hotel_title)
        val textVisitor = view.findViewById<TextView>(R.id.visitor)
        val textRating = view.findViewById<TextView>(R.id.rate)
        val image = view.findViewById<ImageView>(R.id.hotel_image)
    }

    interface OnAdapterListener {
        fun onClick(hotel: HotelModel)
    }
}