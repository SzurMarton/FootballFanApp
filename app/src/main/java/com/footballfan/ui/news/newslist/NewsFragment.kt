package com.footballfan.ui.news.newslist

import android.os.Bundle
import android.util.Log
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.footballfan.R
import com.footballfan.ui.news.deatilnews.DetailNewsFragment
import com.footballfan.ui.news.newslist.model.UiNews
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : RainbowCakeFragment<NewsViewState, NewsViewModel>(), NewsAdapter.Listener{
    override fun getViewResource() = R.layout.fragment_news
    override fun provideViewModel() = getViewModelFromFactory()

    private lateinit var newsAdapter: NewsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsAdapter = NewsAdapter()
        newsAdapter.listener = this
        NewsRecyclerView.adapter = newsAdapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

    override fun render(viewState: NewsViewState) {
        when(viewState){
            is Loading -> viewFlipperMain.displayedChild = 0
            is NewsListReady -> {
                newsAdapter.submitList(viewState.newsData.articles)
                viewFlipperMain.displayedChild = 1
            }
            is Error -> {
                viewFlipperMain.displayedChild = 2
                Log.d("asd","errrorrr")
            }
        }
    }

    override fun onNewsClicked(news: UiNews) {
        navigator?.add(DetailNewsFragment.newInstance(news.title,news.content,news.urlToImage))
    }

}