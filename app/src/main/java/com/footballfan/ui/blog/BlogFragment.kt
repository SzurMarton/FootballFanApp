package com.footballfan.ui.blog

import android.util.Log
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.footballfan.R
import com.footballfan.ui.blog.model.BlogPost

class BlogFragment : RainbowCakeFragment<BlogViewState,BlogViewModel>(){
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_blog

    override fun onStart() {
        super.onStart()
       // viewModel.savePost(BlogPost(4,"asd","4thpost","hellooooooo"))
        viewModel.getPosts()
    }

    override fun render(viewState: BlogViewState) {
        when(viewState){
            Initial -> {}
            is BlogPostsReady -> {
                Log.d("asd", viewState.posts.size.toString())
            }
        }
    }
}