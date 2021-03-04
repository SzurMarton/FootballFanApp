package com.footballfan.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsDataSource @Inject constructor(
        private val generalNewsAPI: GeneralNewsAPI
) {
    //suspend fun getNews()
}