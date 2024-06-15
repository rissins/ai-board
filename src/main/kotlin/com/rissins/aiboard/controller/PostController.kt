package com.rissins.aiboard.controller

import com.rissins.aiboard.dto.request.PostRequest
import com.rissins.aiboard.dto.response.PostResponse
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
@RequestMapping("/api/v1/board")
class PostController(
    private val postService: PostService
) {

    @GetMapping
    @Operation(summary = "게시판 목록을 검색한다.")
    fun findAll(
        @ParameterObject postRequest: PostRequest.Search,
        @ParameterObject pageable: Pageable,
    ): PageResponse<PostResponse.Detail> {
        return postService.search(postRequest, pageable).toPageResponse()
    }

    @GetMapping("/{id}")
    @Operation(summary = "게시글 상세보기.")
    fun find(
        @PathVariable id: Long,
    ): PostResponse.Detail {
        return postService.findById(id)
    }

    @PostMapping
    @Operation(summary = "게시판 글을 작성한다.")
    fun create(
        @ParameterObject postRequest: PostRequest.Create,
    ): PostResponse.Detail {
        return postService.create(postRequest)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시판 글을 삭제한다.")
    fun deleteById(
        @PathVariable id:Long 
    ) {
        postService.deleteById(id)
    }
}