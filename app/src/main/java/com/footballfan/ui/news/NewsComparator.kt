package com.footballfan.ui.news

import androidx.recyclerview.widget.DiffUtil
import com.footballfan.ui.news.model.UiNews

object NewsComparator : DiffUtil.ItemCallback<UiNews>(){
    override fun areItemsTheSame(oldItem: UiNews, newItem: UiNews): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: UiNews, newItem: UiNews): Boolean {
        return oldItem == newItem
    }
}