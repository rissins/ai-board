package com.rissins.aiboard.controller

import com.rissins.aiboard.dto.request.BoardRequest
import com.rissins.aiboard.dto.response.BoardResponse
import com.rissins.aiboard.service.BoardService
import com.rissins.common.PageResponse
import com.rissins.common.toPageResponse
import io.swagger.v3.oas.annotations.Operation
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
@RequestMapping("/api/v1/board")
class BoardController(
    private val boardService: BoardService
) {

    @GetMapping
    @Operation(summary = "게시판 목록을 검색한다.")
    fun findAll(
        @ParameterObject boardRequest: BoardRequest.Search,
        @ParameterObject pageable: Pageable,
    ): PageResponse<BoardResponse.Detail> {
        return boardService.search(boardRequest, pageable).toPageResponse()
    }

    @PostMapping
    @Operation(summary = "게시판 글을 작성한다.")
    fun create(
        @ParameterObject boardRequest: BoardRequest.Create,
    ): BoardResponse.Detail {
        return boardService.create(boardRequest)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시판 글을 삭제한다.")
    fun deleteById(
        @PathVariable id:Long 
    ) {
        boardService.deleteById(id)
    }
}