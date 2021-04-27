package com.footballfan.ui.news.newslist.model

data class UiNewsData (
    val totalresult:Int,
    val articles: List<
            UiNews>?
)

data class UiNews(val author: String,
                  val title: String,
                  val description: String,
                  val urlToImage: String,
                  val content: String)