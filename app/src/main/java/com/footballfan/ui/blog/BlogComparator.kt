package com.footballfan.ui.blog

import androidx.recyclerview.widget.DiffUtil
import com.footballfan.ui.blog.model.BlogPost
import com.footballfan.ui.news.newslist.model.UiNews

object BlogComparator : DiffUtil.ItemCallback<BlogPost>(){
    override fun areItemsTheSame(oldItem: BlogPost, newItem: BlogPost): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: BlogPost, newItem: BlogPost): Boolean {
        return oldItem == newItem
    }
}