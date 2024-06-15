package com.rissins.aiboard.service

import com.rissins.aiboard.dto.request.PostRequest
import com.rissins.aiboard.dto.response.PostResponse
import com.rissins.aiboard.dto.response.toDetail
import com.rissins.aiboard.entity.Post
import com.rissins.aiboard.jpa.repository.PostQueryRepository
import com.rissins.aiboard.jpa.repository.PostRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    private val postRepository: PostRepository,
    private val postQueryRepository: PostQueryRepository
) {

    @Transactional
    fun findAll(): List<Post> {
        return postRepository.findAll()
    }

    @Transactional
    fun findById(id: Long): PostResponse.Detail {
        val post = postRepository.findById(id).orElseThrow()
        post.plusView()
        return post.toDetail()
    }

    @Transactional(readOnly = true)
    fun search(postRequest: PostRequest.Search, pageable: Pageable): Page<PostResponse.Detail> {
        val condition = PostRequest.Search(
            title = postRequest.title,
        )

        return postQueryRepository.search(condition, pageable).map { it.toDetail() }
    }

    @Transactional
    fun create(request: PostRequest.Create): PostResponse.Detail {
        val post = Post(
            title = request.title,
            content = request.content,
        )
        return postRepository.save(post).toDetail()
    }

    @Transactional
    fun deleteById(id: Long) {
        postRepository.deleteById(id)
    }
}