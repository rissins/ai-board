package com.rissins.aiboard.service

import com.rissins.aiboard.dto.request.BoardRequest
import com.rissins.aiboard.dto.response.BoardResponse
import com.rissins.aiboard.dto.response.toDetail
import com.rissins.aiboard.entity.Board
import com.rissins.aiboard.repository.BoardQueryRepository
import com.rissins.aiboard.repository.BoardRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(
    private val boardRepository: BoardRepository,
    private val boardQueryRepository: BoardQueryRepository
) {

    @Transactional
    fun findAll(): List<Board> {
        return boardRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): BoardResponse.Detail {
        return boardRepository.findById(id).orElseThrow().toDetail()
    }

    @Transactional(readOnly = true)
    fun search(boardRequest: BoardRequest.Search, pageable: Pageable): Page<BoardResponse.Detail> {
        val condition = BoardRequest.Search(
            title = boardRequest.title,
        )

        return boardQueryRepository.search(condition, pageable).map { it.toDetail() }
    }

    @Transactional
    fun create(request: BoardRequest.Create): BoardResponse.Detail {
        val board = Board(
            title = request.title,
            content = request.content,
        )
        return boardRepository.save(board).toDetail()
    }

    @Transactional
    fun deleteById(id: Long) {
        boardRepository.deleteById(id)
    }
}