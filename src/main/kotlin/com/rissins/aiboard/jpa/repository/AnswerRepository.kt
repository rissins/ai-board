package com.rissins.aiboard.jpa.repository

import com.rissins.aiboard.entity.Answer
import com.rissins.aiboard.jpa.JpaCustomRepository


interface AnswerRepository : JpaCustomRepository<Answer, Long> {
}