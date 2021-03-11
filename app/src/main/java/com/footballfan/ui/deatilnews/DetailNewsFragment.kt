package com.footballfan.ui.deatilnews

import android.os.Bundle
import android.util.Log
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.bumptech.glide.Glide
import com.footballfan.R
import com.footballfan.ui.news.model.UiNews
import kotlinx.android.synthetic.main.fragment_detailnews.*

class DetailNewsFragment : RainbowCakeFragment<DetailNewsViewState,DetailNewsViewModel>(){
    companion object {
        private const val ARG_NEWS_TITLE = "ARG_NEWS_TITLE"
        private const val ARG_NEWS_CONTENT = "ARG_NEWS_CONTENT"
        private const val ARG_NEWS_URLTOIMAGE = "ARG_NEWS_URLTOIMAGE"

        fun newInstance(newsTitle: String,newsContent:String,newsUrToImage: String): DetailNewsFragment {
            return DetailNewsFragment().applyArgs {
                putString(ARG_NEWS_TITLE, newsTitle)
                putString(ARG_NEWS_CONTENT,newsContent)
                putString(ARG_NEWS_URLTOIMAGE,newsUrToImage)
            }
        }
    }

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_detailnews
    private lateinit var newsTitle: String
    private lateinit var newsContent: String
    private lateinit var newsUrToImage: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArgs()
    }

    private fun initArgs() {
        newsTitle = requireArguments().requireString(ARG_NEWS_TITLE)
        newsContent = requireArguments().requireString(ARG_NEWS_CONTENT)
        newsUrToImage = requireArguments().requireString(ARG_NEWS_URLTOIMAGE)
    }

    override fun render(viewState: DetailNewsViewState) {
        when(viewState){
            Initial ->{
                titleText.text = newsTitle
                contentText.text = newsContent
                Glide.with(detailNewsImage)
                        .load(newsUrToImage)
                        .into(detailNewsImage)
            }
        }
    }

}