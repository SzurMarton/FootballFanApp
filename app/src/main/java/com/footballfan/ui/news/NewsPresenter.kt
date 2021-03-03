package com.footballfan.ui.news

import com.footballfan.domain.NewsInteractor
import javax.inject.Inject

class NewsPresenter @Inject constructor(
        private val newsInteractor: NewsInteractor
){

}
