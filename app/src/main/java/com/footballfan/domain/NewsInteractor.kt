package com.footballfan.domain

import com.footballfan.data.network.news.NewsDataSource
import com.footballfan.domain.models.DomainNewsData
import com.footballfan.networkutil.DataTransferResponse
import com.footballfan.networkutil.DataTransferSuccess
import com.footballfan.networkutil.NetworkResult
import com.footballfan.networkutil.NetworkUnavailableNotCached
import javax.inject.Inject

class NewsInteractor @Inject constructor(
    private val newsDataSource: NewsDataSource
){
    suspend fun getNews() : DataTransferResponse<DomainNewsData> {
        return when(val response = newsDataSource.getNews()){
            is NetworkResult -> {
                DataTransferSuccess(response.result)
            }
            else -> {
                NetworkUnavailableNotCached
            }
        }
    }
}