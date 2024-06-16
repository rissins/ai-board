package com.rissins.aiboard.dto.response

import com.rissins.aiboard.entity.Post

class PostResponse {

    data class Detail(
        var title: String,
        val content: String,
        val view: Int,
        val answer: AnswerResponse.Detail?
    )
}

fun Post.toDetail(): PostResponse.Detail {
    return PostResponse.Detail(
        title = this.title,
        content = this.content,
        view = this.view,
        answer =  this.answer?.toDetail()
    )
}