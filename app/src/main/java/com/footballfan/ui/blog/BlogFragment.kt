package com.footballfan.ui.blog

import android.os.Bundle
import android.util.Log
import android.view.View
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.footballfan.R
import com.footballfan.ui.blog.model.BlogPost
import kotlinx.android.synthetic.main.addpostdialog.*
import kotlinx.android.synthetic.main.fragment_blog.*

class BlogFragment : RainbowCakeFragment<BlogViewState,BlogViewModel>(){
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_blog

    private lateinit var postListAdapter: PostListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postListAdapter = PostListAdapter()
        BlogRecyclerView.adapter = postListAdapter

        fab.setOnClickListener{
            viewModel.showDialog()
        }
    }

    override fun onStart() {
        super.onStart()
        //viewModel.savePost(BlogPost("asd","4thpost","hellooooooo"))
        viewModel.getPosts()
    }

    override fun render(viewState: BlogViewState) {
        when(viewState){
            Initial -> {}
            Loading -> {
                viewFlipperBlog.displayedChild = 0
            }
            is BlogPostsReady -> {
                Log.d("asd", viewState.posts.size.toString())
                Log.d("asd", viewState.posts.first()?.title.toString())
                //Log.d("asd", viewState.posts.first()?.uid.toString())
                postListAdapter.submitList(viewState.posts)
                viewFlipperBlog.displayedChild = 1
            }
            Error -> viewFlipperBlog.displayedChild = 2
        }
    }

    override fun onEvent(event: OneShotEvent) {
        when (event) {
            is BlogViewModel.ShowAddPostDialog -> {
                MaterialDialog(requireContext())
                    .customView(R.layout.addpostdialog)
                    .show {
                        noAutoDismiss()
                        title(text = "Add Blog Post")

                        btnAdd.setOnClickListener {
                            val title = title.text
                            val content = contentText.text
                            if (title.isNotEmpty() && content.isNotEmpty()) {
                                viewModel.savePost(BlogPost(title.toString(), content.toString()))
                                dismiss()
                            }
                        }

                        btnCancel.setOnClickListener {
                            dismiss()
                        }
                    }
            }
        }
    }
}