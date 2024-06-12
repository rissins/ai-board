package com.rissins.aiboard.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime

@Entity
@Table
@EntityListeners(AuditingEntityListener::class)
class Board(
    val title: String,
    val content: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var view: Int = 0

    @CreationTimestamp
    lateinit var createdAt: OffsetDateTime

    @UpdateTimestamp
    lateinit var updatedAt: OffsetDateTime

    var deleted: Boolean = false
}
