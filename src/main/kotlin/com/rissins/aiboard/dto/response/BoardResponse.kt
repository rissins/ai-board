package com.rissins.aiboard.dto.response

class BoardResponse {

    data class Detail(
        var title: String,
        var content: String,
        var view: String,
    )
}