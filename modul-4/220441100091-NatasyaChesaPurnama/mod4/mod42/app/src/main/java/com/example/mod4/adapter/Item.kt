//package com.example.tugasmodul4.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.tugasmodul4.R
//import com.example.yubisayu.Data.ItemFeed
//import com.example.yubisayu.R
//import com.google.android.material.imageview.ShapeableImageView
//
//class Item (private val listFeed: List<ItemFeed>) : RecyclerView.Adapter<Item.ViewHolder>() {
//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }
//
//    interface OnItemClickCallback {
//        fun onItemClicked(data:ItemFeed)
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val nama: TextView = itemView.findViewById(R.id.namauser)
//        val deskripsi: TextView = itemView.findViewById(R.id.deskripsi)
//        val suka: TextView = itemView.findViewById(R.id.love)
//        val chat: TextView = itemView.findViewById(R.id.chat)
//        val gambar: ShapeableImageView = itemView.findViewById(R.id.gambar)
//    }
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): ViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val data = listFeed[holder.bindingAdapterPosition]
//
//        holder.nama.text = data.nama
//        holder.deskripsi.text = data.deskripsi
//        holder.suka.text = data.suka.toString()
//        holder.chat.text = data.chat.toString()
//        if (data.displayimg) {
//            holder.gambar.visibility = View.VISIBLE
//            holder.gambar.setImageResource(data.gambar)
//        } else {
//            holder.gambar.visibility = View.GONE
//        }
//        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listFeed[holder.bindingAdapterPosition]) }
//    }
//
//    override fun getItemCount(): Int = listFeed.size
//
//    private fun String.shorten(maxLength: Int): String {
//        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
//    }
//}