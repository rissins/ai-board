package com.rissins.common

import org.springframework.data.domain.Page

class PageResponse<T>(val contents: List<T>, val totalPages: Int, val totalElements: Long) {
    companion object {
        fun <T> of(page: Page<T>): PageResponse<T> {
            return PageResponse(page.content, page.totalPages, page.totalElements)
        }
    }
}

/** 페이징이 필요하지 않은 응답이지만, 형태를 맞춰서 클라에 전달하기 위한 목적 **/
fun <T> List<T>.toPageResponse(): PageResponse<T> {
    return PageResponse(
        contents = this,
        totalPages = 1,
        totalElements = this.size.toLong(),
    )
}

fun <T> Page<T>.toPageResponse(): PageResponse<T> {
    return PageResponse.of(this)
}
