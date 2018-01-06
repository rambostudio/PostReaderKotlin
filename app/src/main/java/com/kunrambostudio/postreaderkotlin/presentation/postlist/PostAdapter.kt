package com.kunrambostudio.postreaderkotlin.presentation.postlist

import android.app.FragmentBreadCrumbs
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kunrambostudio.postreaderkotlin.R
import com.kunrambostudio.postreaderkotlin.data.entity.Post
import kotlin.properties.Delegates

/**
 * Created by rambo on 6/1/2561.
 */
class PostAdapter : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {
    var onPostClickListener: ((id: String) -> Unit)? = null
    var posts by Delegates.observable(listOf<Post>()) { _, _, _ -> notifyDataSetChanged() }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.post = posts[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return MyViewHolder(view, onPostClickListener)

    }

    override fun getItemCount(): Int {
        return posts.size
    }


    class MyViewHolder(view: View, onPostClickListener: ((id: String) -> Unit)?) : RecyclerView.ViewHolder(view) {
        val tvTtile: TextView = view.findViewById(R.id.tvPostTitle) as TextView

        var post: Post by Delegates.observable(Post()) { _, _, postItem ->
            tvTtile.text = postItem.title
        }

        init {
            view.setOnClickListener {
                onPostClickListener?.invoke(post.id)
            }
        }
    }
}