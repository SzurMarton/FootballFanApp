package com.footballfan.ui.news

import android.icu.text.CaseMap
import co.zsmb.rainbowcake.withIOContext
import com.footballfan.domain.NewsInteractor
import javax.inject.Inject

class NewsPresenter @Inject constructor(
        private val newsInteractor: NewsInteractor
){
    suspend fun getNewsItems() : List<NewsItem>? = withIOContext {
        newsInteractor.getNewsItems()?.map { news ->
            NewsItem(
                    title = news.title,
                    description = news.description,
                    urlToImage = news.urlToImage,
                    content = news.content
            )
        }

    }

    data class NewsItem(
            val title: String?,
            val description: String?,
            val urlToImage: String?,
            val content: String?
    )
}
//val title: String?,
//        val description: String?,
//        val urlToImage: String?,
//        val content: String?