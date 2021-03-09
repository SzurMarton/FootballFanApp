package com.footballfan.data.network

import com.footballfan.data.network.model.NewsResult
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("/v2/everything")
    suspend fun getNews(@Query("q") category:String, @Query("apiKey") apikey:String)  : NewsResult
}