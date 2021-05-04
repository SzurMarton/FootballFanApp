package com.footballfan.ui.blog.model

data class BlogPost(
        val id: String?,
        val authorName: String?,
        val title: String?,
        val content: String?
)

data class Response(
        var posts: List<BlogPost>?,
        var exception: Exception?
)