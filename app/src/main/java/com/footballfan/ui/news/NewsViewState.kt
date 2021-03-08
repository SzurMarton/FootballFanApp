package com.footballfan.ui.news

sealed class NewsViewState

object Loading : NewsViewState()

data class NewsListReady(val news: List<NewsPresenter.NewsItem>?) : NewsViewState()

object NetworkError: NewsViewState()