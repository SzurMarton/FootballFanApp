package com.footballfan.domain

import com.footballfan.data.network.news.NewsDatasource
import com.footballfan.domain.models.DomainNewsData
import com.footballfan.networkutil.DataTransferResponse
import com.footballfan.networkutil.DataTransferSuccess
import com.footballfan.networkutil.NetworkResult
import com.footballfan.networkutil.NetworkUnavailableNotCached
import javax.inject.Inject

class NewsInteractor @Inject constructor(
    private val newsDatasource: NewsDatasource
){
    suspend fun getNews() : DataTransferResponse<DomainNewsData> {
        return when(val response = newsDatasource.getNews()){
            is NetworkResult -> {
                DataTransferSuccess(response.result)
            }
            else -> {
                NetworkUnavailableNotCached
            }
        }
    }
}