package com.rissins.aiboard.dto.request

class PostRequest {

    data class Search(
        val title: String? = null,
    )

    data class Create(
        val title: String,
        val content: String,
    )
}