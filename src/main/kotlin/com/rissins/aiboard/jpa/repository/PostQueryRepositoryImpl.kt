package com.rissins.aiboard.jpa.repository

import com.querydsl.core.types.Predicate
import com.querydsl.jpa.impl.JPAQueryFactory
import com.rissins.aiboard.dto.request.PostRequest
import com.rissins.aiboard.entity.Post
import com.rissins.aiboard.entity.QPost.post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.stereotype.Repository

@Repository
class PostQueryRepositoryImpl(private val jpaQueryFactory: JPAQueryFactory) : PostQueryRepository {
    private fun getPredicates(condition: PostRequest.Search): List<Predicate> {
        return listOfNotNull(
            condition.title?.let { post.title.eq(it) },
        )
    }

    override fun search(condition: PostRequest.Search, pageable: Pageable): Page<Post> {
        val content = jpaQueryFactory
            .selectFrom(post)
            .where(
                *getPredicates(condition).toTypedArray(),
            )
            .orderBy(post.id.desc())
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        val countQuery = jpaQueryFactory
            .select(post.count())
            .from(post)
            .where(
                *getPredicates(condition).toTypedArray(),
            )

        return PageableExecutionUtils.getPage(content, pageable) { countQuery.fetchOne() ?: 0L }
    }
}