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
        val search = boardService.search(boardRequest, pageable)
        val toPageResponse = boardService.search(boardRequest, pageable).toPageResponse()
        return toPageResponse
    }
}