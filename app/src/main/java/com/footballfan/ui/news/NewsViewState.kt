package com.footballfan.ui.news

import com.footballfan.ui.news.model.UiNewsData

sealed class NewsViewState

object Initial : NewsViewState()

object Loading : NewsViewState()

data class NewsListReady(val newsData: UiNewsData) : NewsViewState()

object Error : NewsViewState()