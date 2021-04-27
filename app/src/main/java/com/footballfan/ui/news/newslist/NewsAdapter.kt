package com.footballfan.ui.news.newslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.footballfan.R
import com.footballfan.ui.news.newslist.model.UiNews
import kotlinx.android.synthetic.main.row_newsitem.view.*

class NewsAdapter : ListAdapter<UiNews, NewsAdapter.NewsViewHolder>(NewsComparator) {
    var listener: Listener? =null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_newsitem, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.news = news
        holder.title.text = news.title
        holder.description.text = news.description
        Glide.with(holder.imageView)
                .load(news.urlToImage)
                .into(holder.imageView)
    }


    inner class NewsViewHolder(newsView: View) : RecyclerView.ViewHolder(newsView) {
        val title: TextView = newsView.newsTitle
        val imageView: ImageView = newsView.newsImage
        val description: TextView = newsView.newsDescription
        //val cardView: CardView = newsView.cardView
        var news: UiNews? = null

        init {
            newsView.setOnClickListener {
                news?.let { listener?.onNewsClicked(it) }
            }
        }
    }

    interface Listener{
        fun onNewsClicked(news: UiNews)
    }
}