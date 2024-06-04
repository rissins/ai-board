package com.rissins.aiboard.dto.request

class BoardRequest {

    data class Search(
        val title: String? = null,
    )
}