package com.rissins.aiboard.repository

import com.querydsl.core.types.Predicate
import com.querydsl.jpa.impl.JPAQueryFactory
import com.rissins.aiboard.dto.request.BoardRequest
import com.rissins.aiboard.entity.Board
import com.rissins.aiboard.entity.QBoard.board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.stereotype.Repository

@Repository
class BoardQueryRepositoryImpl(private val jpaQueryFactory: JPAQueryFactory) : BoardQueryRepository {
    private fun getPredicates(condition: BoardRequest.Search): List<Predicate> {
        return listOfNotNull(
            condition.title?.let { board.title.eq(it) },
        )
    }

    override fun search(condition: BoardRequest.Search, pageable: Pageable): Page<Board> {
        val content = jpaQueryFactory
            .selectFrom(board)
            .where(
                *getPredicates(condition).toTypedArray(),
            )
            .orderBy(board.id.desc())
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        val countQuery = jpaQueryFactory
            .select(board.count())
            .from(board)
            .where(
                *getPredicates(condition).toTypedArray(),
            )

        return PageableExecutionUtils.getPage(content, pageable, content::)
    }
}