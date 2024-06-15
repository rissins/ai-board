package com.rissins.aiboard.repository

import com.rissins.aiboard.entity.Answer
import org.springframework.data.jpa.repository.JpaRepository


interface AnswerRepository : JpaRepository<Answer, Long> {
}