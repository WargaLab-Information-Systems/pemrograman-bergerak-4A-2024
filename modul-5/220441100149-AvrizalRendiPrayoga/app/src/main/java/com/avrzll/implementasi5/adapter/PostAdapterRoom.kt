package com.avrzll.implementasi5.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avrzll.implementasi5.R
import com.avrzll.implementasi5.room.PostDatabase
import com.google.android.material.imageview.ShapeableImageView

class PostAdapterRoom(private var postList: List<PostDatabase>) :
    RecyclerView.Adapter<PostAdapterRoom.PostViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemMore(data: PostDatabase)
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postTitle: TextView = itemView.findViewById(R.id.post_title)
        val postDesc: TextView = itemView.findViewById(R.id.post_desc)
        val postImg: ShapeableImageView = itemView.findViewById(R.id.post_img)
        val postLike: TextView = itemView.findViewById(R.id.post_like)
        val btnLike: ImageView = itemView.findViewById(R.id.btn_like)
        val btnMore: ImageView = itemView.findViewById(R.id.btn_more)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val data = postList[position]

        holder.postTitle.text = data.name
        holder.postDesc.text = data.description.shorten(500)
        holder.postLike.text = data.like.toString()

        val uri = Uri.fromFile(data.image)
        holder.postImg.setImageURI(uri)

        holder.btnLike.setOnClickListener {
            val likeText = holder.postLike.text.toString()
            val likeCount = likeText.toInt()
            holder.postLike.text = (likeCount+1).toString()
        }

        holder.btnMore.setOnClickListener {
            onItemClickCallback.onItemMore(postList[holder.absoluteAdapterPosition])
        }
    }

    override fun getItemCount(): Int = postList.size

    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}
