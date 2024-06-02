package com.rissins.aiboard.controller

import com.rissins.aiboard.entity.Board
import com.rissins.aiboard.service.BoardService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/api/v1/board")
class BoardController(
    private val boardService: BoardService
) {

    @GetMapping
    fun findAll(): List<Board> {
        return emptyList()
    }
}