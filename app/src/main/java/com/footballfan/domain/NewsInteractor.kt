package com.footballfan.domain

import com.footballfan.network.NewsDataSource
import javax.inject.Inject

class NewsInteractor @Inject constructor(
        private val newsDataSource: NewsDataSource
){

}