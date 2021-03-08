package com.footballfan.domain

import android.util.Log
import com.footballfan.network.NewsDataSource
import javax.inject.Inject

class NewsInteractor @Inject constructor(
        private val newsDataSource: NewsDataSource
){
    suspend fun getNewsItems() : List<News>? {
        return newsDataSource.getFootballNews()

    }
}