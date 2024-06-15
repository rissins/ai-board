package com.rissins.aiboard.jpa.repository

import com.rissins.aiboard.entity.Post
import com.rissins.aiboard.jpa.JpaCustomRepository


interface PostRepository : JpaCustomRepository<Post, Long> {
//    fun findAllByStatusIn(status: List<BannerStatus>, page: Pageable): Page<Banner>
}