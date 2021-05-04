package com.footballfan.ui.blog

import com.footballfan.ui.blog.model.BlogPost

sealed class BlogViewState

object Initial : BlogViewState()

object Error : BlogViewState()

object Loading : BlogViewState()

data class BlogPostsReady(val posts : ArrayList<BlogPost?>) : BlogViewState()