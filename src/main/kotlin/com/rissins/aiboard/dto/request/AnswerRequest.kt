package com.rissins.aiboard.dto.request

class AnswerRequest {

    data class Search(
        val title: String? = null,
    )

    data class Create(
        val postId: Long,
        val title: String,
        val content: String,
    )
}