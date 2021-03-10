package com.footballfan.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.footballfan.R
import com.footballfan.ui.news.model.UiNews
import com.footballfan.ui.news.model.UiNewsData
import kotlinx.android.synthetic.main.row_newsitem.view.*

class NewsAdapter : ListAdapter<UiNews, NewsAdapter.NewsViewHolder>(NewsComparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_newsitem, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.news = news
        holder.title.text = news.title
        holder.author.text = news.author
        Glide.with(holder.imageView)
                .load(news.urlToImage)
                .into(holder.imageView)
    }


    inner class NewsViewHolder(newsView: View) : RecyclerView.ViewHolder(newsView) {
        val title: TextView = newsView.newsTitle
        val imageView: ImageView = newsView.newsImage
        val author: TextView = newsView.newsAuthor

        var news: UiNews? = null
    }
}