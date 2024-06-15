package com.rissins.aiboard.service

import com.rissins.aiboard.dto.request.AnswerRequest
import com.rissins.aiboard.dto.request.PostRequest
import com.rissins.aiboard.dto.response.AnswerResponse
import com.rissins.aiboard.dto.response.PostResponse
import com.rissins.aiboard.dto.response.toDetail
import com.rissins.aiboard.entity.Answer
import com.rissins.aiboard.entity.Post
import com.rissins.aiboard.jpa.findByIdOrThrow
import com.rissins.aiboard.jpa.repository.AnswerRepository
import com.rissins.aiboard.jpa.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AnswerService(
    private val answerRepository: AnswerRepository,
    private val postRepository: PostRepository
) {

    @Transactional
    fun findAll(): List<Answer> {
        return answerRepository.findAll()
    }

    @Transactional
    fun findById(id: Long): AnswerResponse.Detail {
        val answer = answerRepository.findById(id).orElseThrow()
        return answer.toDetail()
    }

    @Transactional
    fun create(request: AnswerRequest.Create): AnswerResponse.Detail {
        val post = postRepository.findByIdOrThrow(request.postId)
        val answer = Answer(
            title = request.title,
            content = request.content,
            post = post
        )

        return answerRepository.save(answer).toDetail()
    }

    @Transactional
    fun deleteById(id: Long) {
        answerRepository.deleteById(id)
    }
}