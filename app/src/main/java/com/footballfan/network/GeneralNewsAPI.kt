package com.footballfan.network

import com.footballfan.network.model.NewsResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GeneralNewsAPI {
    @GET("/v2/everything")
    fun getNews(@Query("q") category:String,@Query("sortBy") asd: String,@Query("apiKey") apikey:String)  : Call<NewsResult>
}