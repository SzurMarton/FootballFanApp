package com.footballfan.data.network.news

import com.footballfan.data.network.news.model.NewsResult
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("https://newsapi.org/v2/everything")
    suspend fun getNews(@Query("q") category:String, @Query("apiKey") apikey:String)  : NewsResult
}