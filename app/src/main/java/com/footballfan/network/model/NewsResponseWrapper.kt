package com.footballfan.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NewsResponseWrapper (
        val response : NewsResult
)