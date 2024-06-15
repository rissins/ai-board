package com.rissins.aiboard.jpa.repository

import com.rissins.aiboard.dto.request.PostRequest
import com.rissins.aiboard.entity.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PostQueryRepository {
    fun search(condition: PostRequest.Search, pageable: Pageable): Page<Post>
}