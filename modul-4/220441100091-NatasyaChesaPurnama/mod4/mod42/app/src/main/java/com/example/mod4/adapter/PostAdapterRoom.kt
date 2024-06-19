package com.example.mod4.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mod4.R
import com.example.mod4.room.PostEntity
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
    }

    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: MaterialTextView = itemView.findViewById(R.id.judul)
        val description: MaterialTextView = itemView.findViewById(R.id.descpost)
        val img: ShapeableImageView = itemView.findViewById(R.id.imgpost)
        val imglove: ImageView = itemView.findViewById(R.id.love)
        val likee: TextView = itemView.findViewById(R.id.like)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeopleViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
        return PeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val data = postList[position]

        holder.title.text = data.judul
        holder.description.text = data.desc.shorten(85)
        val uri = Uri.fromFile(data.image)
        holder.img.setImageURI(uri)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(postList[holder.absoluteAdapterPosition]) }


        var isLiked = false
        var like = holder.likee.text.toString().toInt()

        holder.imglove.setOnClickListener {
            if (!isLiked) {
                like++
                holder.likee.text = like.toString()
                holder.imglove.setImageResource(R.drawable.ic_love2)
                isLiked = true
            } else {
                like++
                holder.likee.text = like.toString()
                holder.imglove.setImageResource(R.drawable.ic_love)
                isLiked = false
            }
        }
    }

    override fun getItemCount(): Int = postList.size

    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..." }
}
