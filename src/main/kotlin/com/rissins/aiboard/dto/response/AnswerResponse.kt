package com.rissins.aiboard.dto.response

import com.rissins.aiboard.entity.Answer

class AnswerResponse {

    data class Detail(
        var title: String,
        val content: String,
    )
}

fun Answer.toDetail(): AnswerResponse.Detail {
    return AnswerResponse.Detail(
        title = this.title,
        content = this.content,
    )
}