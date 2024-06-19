package com.example.implementasimodul3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.implementasimodul3.R
import com.example.implementasimodul3.datamodel.PlaceModel

class HorizontalAdapter(

    private val listPlace: List<PlaceModel>,
    private val listener: OnAdapterListener

): RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_horizontal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place =  listPlace[position]
        holder.textName.text = place.name
        holder.textLocation.text = place.location
        holder.image.setImageResource(place.image)
        holder.itemView.setOnClickListener {
            listener.onClick(place)
        }
    }

    override fun getItemCount() = listPlace.size
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textName = view.findViewById<TextView>(R.id.place_name)
        val textLocation = view.findViewById<TextView>(R.id.place_location)
        val image = view.findViewById<ImageView>(R.id.place_image)
    }

    interface OnAdapterListener {
        fun onClick(place: PlaceModel)
    }
}