package com.example.modul4.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul4.R
import com.example.modul4.room.PostEntity
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class PostAdapterRoom (private var postList: List<PostEntity>) :
    RecyclerView.Adapter<PostAdapterRoom.PeopleViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: PostEntity)
        fun onItemMore(data: PostEntity)
    }

    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: MaterialTextView = itemView.findViewById(R.id.judul)
        val desc: MaterialTextView = itemView.findViewById(R.id.caption)
        val imgpost: ShapeableImageView = itemView.findViewById(R.id.image)
        val txtlove: TextView = itemView.findViewById(R.id.like2)
        val imglove: ImageView = itemView.findViewById(R.id.like)
        val bMore: ImageView = itemView.findViewById(R.id.menu)
        val waktu: TextView = itemView.findViewById(R.id.time)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeopleViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val data = postList[position]

        holder.title.text = data.name
        holder.desc.text = data.description.shorten(85)

        val uri = Uri.fromFile(data.image)
        holder.imgpost.setImageURI(uri)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(postList[holder.bindingAdapterPosition]) }
        holder.bMore.setOnClickListener { onItemClickCallback.onItemMore(postList[holder.bindingAdapterPosition]) }

        var isLiked = false
        var like = data.likeCount

        holder.imglove.setOnClickListener {
            if (!isLiked) {
                like++
                holder.txtlove.text = like.toString()
                holder.imglove.setImageResource(R.drawable.ic_like2)
                isLiked = true
            } else {
                holder.txtlove.text = like.toString()
                holder.imglove.setImageResource(R.drawable.ic_like)
                isLiked = false
            }
        }
    }

    override fun getItemCount(): Int = postList.size

    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}