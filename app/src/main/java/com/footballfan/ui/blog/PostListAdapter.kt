package com.footballfan.ui.blog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.ListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.footballfan.R
import com.footballfan.ui.blog.model.BlogPost
import kotlinx.android.synthetic.main.row_blogpost.view.*
import java.util.zip.Inflater

class PostListAdapter : ListAdapter<BlogPost,PostListAdapter.PostListViewHolder>(BlogComparator){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_blogpost,parent,false)
        return PostListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostListViewHolder, position: Int) {
        val post = getItem(position)
        holder.post = post
        holder.title.text = post.title
        holder.content.text = post.content
    }

    inner class PostListViewHolder(postView: View) : RecyclerView.ViewHolder(postView){
        val title: TextView = postView.postTitle
        val content: TextView = postView.postContent
        var post : BlogPost? = null
    }
}