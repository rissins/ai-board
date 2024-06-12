package com.rissins.aiboard.dto.request

class BoardRequest {

    data class Search(
        val title: String? = null,
    )

    data class Create(
        val title: String,
        val content: String,
    )
}