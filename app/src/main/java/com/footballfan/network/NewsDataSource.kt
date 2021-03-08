package com.footballfan.network

import android.util.Log
import com.footballfan.domain.News
import retrofit2.awaitResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsDataSource @Inject constructor(
        private val generalNewsAPI: GeneralNewsAPI
) {
    //TODO null safety
    suspend fun getFootballNews() : List<News>? {
        return generalNewsAPI.getNews("soccer","96b83721612e4f62ad4f1b5fa8a15cfc")
                .response.articles
                ?.map { news ->
                    News(
                        title = news.title, description = news.description,
                        urlToImage = news.urlToImage,content = news.content
                    )
                }


    }
}