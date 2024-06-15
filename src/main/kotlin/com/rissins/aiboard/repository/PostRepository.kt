package com.rissins.aiboard.repository

import com.rissins.aiboard.entity.Post
import org.springframework.data.jpa.repository.JpaRepository


interface PostRepository : JpaRepository<Post, Long> {
//    fun findAllByStatusIn(status: List<BannerStatus>, page: Pageable): Page<Banner>
}