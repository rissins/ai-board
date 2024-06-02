package com.rissins.aiboard.service

import com.rissins.aiboard.entity.Board
import com.rissins.aiboard.repository.BoardRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {

    @Transactional
    fun findAll(): List<Board> {
        return boardRepository.findAll()
    }
}