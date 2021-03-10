package com.footballfan.ui.news

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.footballfan.R
import com.footballfan.ui.news.model.UiNews
import com.footballfan.ui.news.model.UiNewsData
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : RainbowCakeFragment<NewsViewState, NewsViewModel>(){
    override fun getViewResource() = R.layout.fragment_news
    override fun provideViewModel() = getViewModelFromFactory()

    private lateinit var newsAdapter: NewsAdapter
   // private var news : List<UiNews>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsAdapter = NewsAdapter()
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

}