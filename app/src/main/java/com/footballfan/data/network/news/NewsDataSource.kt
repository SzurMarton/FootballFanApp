package com.footballfan.data.network.news

import com.footballfan.domain.models.DomainNewsData
import com.footballfan.networkutil.NetworkResponse
import com.footballfan.networkutil.executeNetworkCall
import javax.inject.Inject

class NewsDataSource @Inject constructor(private val newsApi : NewsApi){
    suspend fun getNews() : NetworkResponse<DomainNewsData> =
        executeNetworkCall {
            newsApi.getNews("soccer","96b83721612e4f62ad4f1b5fa8a15cfc").let {
                DomainNewsData(
                    status = it.status,
                    totalResults = it.totalResults,
                    articles = it.articles
                )
            }
        }
}