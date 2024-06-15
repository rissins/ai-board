package com.rissins.aiboard.service

import com.rissins.aiboard.dto.request.AnswerRequest
import com.rissins.aiboard.dto.request.PostRequest
import com.rissins.aiboard.dto.response.AnswerResponse
import com.rissins.aiboard.dto.response.PostResponse
import com.rissins.aiboard.dto.response.toDetail
import com.rissins.aiboard.entity.Answer
import com.rissins.aiboard.entity.Post
import com.rissins.aiboard.repository.AnswerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AnswerService(
    private val answerRepository: AnswerRepository,
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
        val answer = Answer(
            title = request.title,
            content = request.content,
        )
        return answerRepository.save(answer).toDetail()
    }

    @Transactional
    fun deleteById(id: Long) {
        answerRepository.deleteById(id)
    }
}