package com.footballfan.domain.models.news

import com.footballfan.data.network.news.model.News

data class DomainNewsData(val status:String?, val totalResults:Int?, val articles: List<News>?)

//TODO fix wrong class
data class News(val source: Source, val author:String?,
                val title: String?, val description: String?,
                val url: String?, val urlToImage: String?,
                val publishedAt: String?, val content: String?
)

data class Source(val id : String?,val name: String?)