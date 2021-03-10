package com.footballfan.ui.news

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.domain.NewsInteractor
import com.footballfan.domain.models.DomainNewsData
import com.footballfan.networkutil.SomeResult
import com.footballfan.ui.news.model.UiNews
import com.footballfan.ui.news.model.UiNewsData
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val newsInteractor: NewsInteractor) {
    suspend fun getNewsData() : UiNewsData? = withIOContext{
        when(val response = newsInteractor.getNews()){
            is SomeResult -> response.result.toUiNewsData()
            else -> null
        }
    }

    private fun DomainNewsData.toUiNewsData() : UiNewsData {
        return UiNewsData(
            totalresult = totalResults ?: 0,
            articles = articles?.map { UiNews(
                author = it.author ?: "",
                title = it.title ?: "",
                description = it.description ?: "",
                urlToImage = it.urlToImage ?: "",
                content = it.content ?: ""
            )
            })
    }
}