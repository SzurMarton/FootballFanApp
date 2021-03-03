package com.footballfan.ui.news

sealed class NewsViewState

object Loading : NewsViewState()

//data class NewsListReady(val news: List<NewsItem>) : NewsViewState()

//object NetworkError: NewsViewState()