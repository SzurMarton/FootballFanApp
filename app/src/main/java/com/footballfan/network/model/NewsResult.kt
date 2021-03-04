package com.footballfan.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NewsResult (val status:String?,val totalResults:Int?,val articles: List<News>?)


@JsonClass(generateAdapter = true)
class News(val source: Source,val author:String?,
           val title: String?,val description: String?,
           val url: String?,val urlToImage: String?,
           val publishedAt: String?,val content: String?
)

@JsonClass(generateAdapter = true)
class Source(val id : String?,val name: String?)