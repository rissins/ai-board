package com.rissins.aiboard.controller

import com.rissins.aiboard.dto.request.AnswerRequest
import com.rissins.aiboard.dto.request.PostRequest
import com.rissins.aiboard.dto.response.AnswerResponse
import com.rissins.aiboard.dto.response.PostResponse
import com.rissins.aiboard.service.AnswerService
import com.rissins.aiboard.service.PostService
import com.rissins.common.PageResponse
import com.rissins.common.toPageResponse
import io.swagger.v3.oas.annotations.Operation
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/answer")
class AnswerController(
    private val answerService: AnswerService
) {

    @PostMapping
    @Operation(summary = "답변을 작성한다.")
    fun create(
        @ParameterObject request: AnswerRequest.Create,
    ): AnswerResponse.Detail {
        return answerService.create(request)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "답변을 삭제한다.")
    fun deleteById(
        @PathVariable id:Long 
    ) {
        answerService.deleteById(id)
    }
}