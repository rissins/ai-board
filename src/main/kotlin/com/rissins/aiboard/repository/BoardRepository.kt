package com.rissins.aiboard.repository

import com.rissins.aiboard.entity.Board
import org.springframework.data.jpa.repository.JpaRepository


interface BoardRepository : JpaRepository<Board, Long> {
//    fun findAllByStatusIn(status: List<BannerStatus>, page: Pageable): Page<Banner>
}