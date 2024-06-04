package com.rissins.aiboard.dto.response

import com.rissins.aiboard.entity.Board

class BoardResponse {

    data class Detail(
        var title: String,
        val content: String,
        val view: Int,
    )
}

fun Board.toDetail(): BoardResponse.Detail {
    return BoardResponse.Detail(
        title = this.title,
        content = this.content,
        view = this.view,
    )
}