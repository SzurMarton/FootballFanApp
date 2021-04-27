package com.footballfan.ui.news.newslist

import com.footballfan.ui.news.newslist.model.UiNewsData

sealed class NewsViewState

object Initial : NewsViewState()

object Loading : NewsViewState()

data class NewsListReady(val newsData: UiNewsData) : NewsViewState()

object Error : NewsViewState()